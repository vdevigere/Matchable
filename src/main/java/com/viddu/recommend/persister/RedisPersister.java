package com.viddu.recommend.persister;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

import com.viddu.recommend.bo.Matchable;

public class RedisPersister implements MatchableItemPersiser {

	private static final Logger LOG = LoggerFactory.getLogger(RedisPersister.class);
	private Jedis client;

	private enum TagType {
		DESC("descTag"), REC("recTag");

		private final String tagName;

		TagType(String name) {
			this.tagName = name;
		}

		@Override
		public String toString() {
			return tagName;
		}
	}

	@Inject
	public RedisPersister(RedisConfig config) {
		client = new Jedis(config.getHost(), config.getPort());
	}

	@Override
	public Matchable findById(Long id) {
		Matchable matchable = new Matchable(id, client.hget(getItemKey(id), "title"));
		Set<String> descTagSet = client.smembers(getItemKeyForTags(id, TagType.DESC));
		matchable.setDescriptionTags(descTagSet);
		Set<String> recTagSet = client.smembers(getItemKeyForTags(id, TagType.REC));
		matchable.setRecommendationTags(recTagSet);
		return matchable;
	}

	@Override
	public void save(Matchable mItem) {
		mItem.setId(client.incr("next.item.id"));
		String sItemKey = getItemKey(mItem.getId());
		LOG.debug("Adding keys to hash Set {}", sItemKey);

		// Add the mItem fields to the hash set.
		client.hset(sItemKey, "title", mItem.getTitle());

		for (String tag : mItem.getDescriptionTags()) {
			addDesciptionTag(mItem.getId(), tag);
		}

		for (String tag : mItem.getRecommendationTags()) {
			addRecommendationTag(mItem.getId(), tag);
		}
	}

	@Override
	public void replace(Matchable mItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDesciptionTag(Long id, String tagName) {
		String itemKeyForTag = getItemKeyForTags(id, TagType.DESC);
		LOG.debug("Adding tag {} to Item {} using key {}", tagName, id, itemKeyForTag);
		client.sadd(itemKeyForTag, tagName);
		String sDesc_Tag_Items = getTagKeyForItem(tagName, TagType.DESC);
		LOG.debug("Adding Item {} to tag {} using key {}", id, tagName, sDesc_Tag_Items);
		client.sadd(sDesc_Tag_Items, id.toString());
	}

	@Override
	public void removeDesciptionTag(Long id, String tagName) {
	}

	@Override
	public void addRecommendationTag(Long id, String tagName) {
		String itemKeyForTag = getItemKeyForTags(id, TagType.REC);
		LOG.debug("Removing tag {} to Item {} using key {}", tagName, id, itemKeyForTag);
		client.sadd(getItemKeyForTags(id, TagType.REC), tagName);
		String sRec_Tag_Items = getTagKeyForItem(tagName, TagType.REC);
		LOG.debug("Adding Item {} to tag {} using key {}", id, tagName, sRec_Tag_Items);
		client.sadd(sRec_Tag_Items, id.toString());
	}

	@Override
	public void removeRecommendationTag(Long id, String tagName) {
		// TODO Auto-generated method stub

	}

	private String getItemKey(Long id) {
		return new StringBuilder("item:").append(id).toString();
	}

	private String getItemKeyForTags(Long id, TagType tagType) {
		return new StringBuilder("item:").append(id).append(":").append(tagType).toString();
	}

	private String getTagKeyForItem(String tag, TagType tagType) {
		return new StringBuilder(tagType.toString()).append(":").append(tag).append(":items").toString();
	}
}
