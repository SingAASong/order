package com.order.Service;

import com.order.pojo.PageResult;
import com.order.pojo.result;

public interface TableService {
	/*
	 * 添加新桌
	 */
	void AddTable(String bName);
	/**
	 * 显示分页列表
	 * @param page 当前页
	 * @param row 每页显示条数
	 * @return
	 */
	PageResult showList(String keyword,Integer page, Integer row);
	/**
	 * 退桌
	 * @param id
	 */
	void updateById(Integer id);
	/**
	 * 删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 预定
	 * @param id
	 */
	void plannedTable(Integer id);
}
