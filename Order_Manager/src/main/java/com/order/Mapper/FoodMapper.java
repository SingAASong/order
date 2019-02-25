package com.order.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.order.pojo.Food;
import com.order.pojo.result;

public interface FoodMapper {

	void save(Food food);

	List<Food> selectLike(@Param(value="keyword") String keyword);

	List<Food> selectAll();

	List<Food> findByid(Integer id);

	void update(Food food);

	void delete(Integer id);
}
