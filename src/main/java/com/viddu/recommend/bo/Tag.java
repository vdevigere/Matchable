package com.viddu.recommend.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tag {
	private String name;

	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
