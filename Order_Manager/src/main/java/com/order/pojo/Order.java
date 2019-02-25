package com.order.pojo;

import java.io.Serializable;

public class Order implements Serializable{
	//餐桌主键
	private Long id;
	//餐桌名称
	private String tableName;
	//餐桌状态 0预定 1空闲
	private String status;
	//新桌添加时间
	private String creatTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	
}
