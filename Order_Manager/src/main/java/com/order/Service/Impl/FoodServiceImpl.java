package com.order.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.order.Mapper.CookMapper;
import com.order.Mapper.FoodMapper;
import com.order.Service.FoodService;
import com.order.pojo.Cook;
import com.order.pojo.Food;
import com.order.pojo.PageResult;
@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodMapper foodMapper;
	@Autowired
	private CookMapper cookMapper;
	@Override
	public void save(Food food) {
		foodMapper.save(food);
	}
	
	@Override
	public PageResult findPage(Integer pages,Integer rows,String keyword) {
		PageResult pageResult = new PageResult(pages, rows);
		PageHelper.startPage(pageResult.getPage(),pageResult.getRows());
		Page<Food> page;
		if(keyword!=""&&keyword!=null){
			page=(Page<Food>) foodMapper.selectLike(keyword);
			
		}else{
			page=(Page<Food>) foodMapper.selectAll();
		}
		for (Food food : page) {
			Long id = food.getCookId();
			Cook findById = cookMapper.findById(id);
			food.setCookName(findById.getCookName());
		}
		pageResult.setList(page.getResult());
		pageResult.setTotal(page.getTotal());
		return pageResult;
	}

	@Override
	public Food findById(Integer id) {
		List<Food> findByid = foodMapper.findByid(id);
		return findByid.get(0);
	}

	@Override
	public void update(Food food) {
		 foodMapper.update(food);
	}

	@Override
	public void delete(Integer id) {
		 foodMapper.delete(id);
	}

}
