package com.viddu.recommend.bo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Matchable {
	private Long id;
	// private List<Image> imageList;
	private String title;
	private List<Tag> descriptionTags = new ArrayList<Tag>();
	private List<Tag> recommendationTags = new ArrayList<Tag>();

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

	public List<Tag> getDescriptionTags() {
		return descriptionTags;
	}

	public void addDescriptionTag(Tag tag) {
		descriptionTags.add(tag);
	}

	public void removeDescriptionTag(Tag tag) {
		descriptionTags.remove(tag);
	}

	public List<Tag> getRecommendationTags() {
		return recommendationTags;
	}

	public void addRecommendationTag(Tag tag) {
		recommendationTags.add(tag);
	}

	public void removeRecommendationTag(Tag tag) {
		recommendationTags.remove(tag);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescriptionTags(List<Tag> descriptionTags) {
		this.descriptionTags = descriptionTags;
	}

	public void setRecommendationTags(List<Tag> recommendationTags) {
		this.recommendationTags = recommendationTags;
	}

}
