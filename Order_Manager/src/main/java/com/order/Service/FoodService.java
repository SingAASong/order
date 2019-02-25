package com.order.Service;

import java.util.List;

import com.order.pojo.Food;
import com.order.pojo.PageResult;
import com.order.pojo.result;

public interface FoodService {

	void save(Food food);

	PageResult findPage(Integer pages, Integer rows, String keyword);


	void update(Food food);

	void delete(Integer id);

	Food findById(Integer id);

}
