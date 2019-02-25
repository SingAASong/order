package com.order.pojo;

import java.io.Serializable;

public class Cook implements Serializable{
	//主键
	private Long id;
	//菜系名称
	private String cookName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCookName() {
		return cookName;
	}
	public void setCookName(String cookName) {
		this.cookName = cookName;
	}
	
	
}
