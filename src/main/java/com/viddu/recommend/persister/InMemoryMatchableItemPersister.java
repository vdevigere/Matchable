package com.viddu.recommend.persister;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.viddu.recommend.bo.Matchable;

@Singleton
public class InMemoryMatchableItemPersister implements MatchableItemPersiser {

	private Map<Long, Matchable> matchableItemMap = new HashMap<Long, Matchable>();
	
	@Inject
	public InMemoryMatchableItemPersister(Map<Long, Matchable> mItemMap){
		this.matchableItemMap = mItemMap;
	}

	@Override
	public Matchable findById(Long id) {
		return matchableItemMap.get(id);
	}

	@Override
	public void save(Matchable mItem) {
		matchableItemMap.put(mItem.getId(), mItem);
	}

	@Override
	public void replace(Matchable mItem) {
	}

	@Override
	public void delete(Long id) {
		matchableItemMap.remove(id);
	}

	@Override
	public void addDesciptionTag(Long id, String tagName) {
		matchableItemMap.get(id).addDescriptionTag(tagName);
	}

	@Override
	public void removeDesciptionTag(Long id, String tagName) {
		matchableItemMap.get(id).removeDescriptionTag(tagName);
	}

	@Override
	public void addRecommendationTag(Long id, String tagName) {
		matchableItemMap.get(id).addRecommendationTag(tagName);
	}

	@Override
	public void removeRecommendationTag(Long id, String tagName) {
		matchableItemMap.get(id).removeRecommendationTag(tagName);
	}

}
