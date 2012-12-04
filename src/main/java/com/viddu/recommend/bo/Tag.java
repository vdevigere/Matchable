package com.viddu.recommend.bo;

import javax.xml.bind.annotation.XmlRootElement;

@Deprecated
@XmlRootElement
public class Tag {
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}

}
