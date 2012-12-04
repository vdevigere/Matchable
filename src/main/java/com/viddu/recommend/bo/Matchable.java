package com.viddu.recommend.bo;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Matchable {
	private Long id;
	// private List<Image> imageList;
	private String title;
	private Set<String> descriptionTags = new HashSet<String>();
	private Set<String> recommendationTags = new HashSet<String>();

	public Matchable() {
		// TODO Auto-generated constructor stub
	}

	public Matchable(Long id, String title) {
		this.title = title;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getDescriptionTags() {
		return descriptionTags;
	}

	public void addDescriptionTag(String tag) {
		descriptionTags.add(tag);
	}

	public void removeDescriptionTag(String tag) {
		descriptionTags.remove(tag);
	}

	public Set<String> getRecommendationTags() {
		return recommendationTags;
	}

	public void addRecommendationTag(String tag) {
		recommendationTags.add(tag);
	}

	public void removeRecommendationTag(String tag) {
		recommendationTags.remove(tag);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescriptionTags(Set<String> descriptionTags) {
		this.descriptionTags = descriptionTags;
	}

	public void setRecommendationTags(Set<String> recommendationTags) {
		this.recommendationTags = recommendationTags;
	}

}
