package com.order.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.order.pojo.Order;

public interface TableMapper {
	int insert(Order order);

	List<Order> selectAll();

	Order findById(Integer id);

	void update(Order order);

	void deleteById(Integer id);

	List<Order> selectByem(@Param(value="keyword") String keyword);

	void updateById(Map<String, Object> map);

}
