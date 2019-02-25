package com.order.pojo;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
	//当前页数
	private Integer page;
	//每页显示条数
	private Integer rows;
	//总条数数
	private Long total;
	//返回的数据
	private List list;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public PageResult(Integer page, Integer rows) {
		super();
		this.page = page;
		this.rows = rows;
		if (this.page==null || this.page < 1) {
			this.page=1;
		}
		if (this.rows==null) {
			this.rows=10;
		}
	}
}
