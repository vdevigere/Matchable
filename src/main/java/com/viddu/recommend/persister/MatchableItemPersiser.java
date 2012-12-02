package com.viddu.recommend.persister;

import com.viddu.recommend.bo.Matchable;

public interface MatchableItemPersiser {

	public Matchable findById(Long id);

	public void save(Matchable mItem);

	public void replace(Matchable mItem);

	public void delete(Long id);

	public void addDesciptionTag(Long id, String tagName);

	public void removeDesciptionTag(Long id, String tagName);

	public void addRecommendationTag(Long id, String tagName);

	public void removeRecommendationTag(Long id, String tagName);

}
