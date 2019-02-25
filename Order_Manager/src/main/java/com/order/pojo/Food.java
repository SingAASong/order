package com.order.pojo;

import java.io.File;
import java.io.Serializable;

public class Food implements Serializable{
	private  Long id;
	private String foodName;
	private Double price;
	private Double vipPrice;
	private Long cookId;
	private String company;
	private String files;
	private String cookName;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public String getCookName() {
		return cookName;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public Double getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}

	public Long getCookId() {
		return cookId;
	}

	public void setCookId(Long cookId) {
		this.cookId = cookId;
	}
	
	
}
