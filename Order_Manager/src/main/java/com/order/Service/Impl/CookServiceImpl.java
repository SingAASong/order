package com.order.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.order.Mapper.CookMapper;
import com.order.Service.CookService;
import com.order.pojo.Cook;
import com.order.pojo.PageResult;
@Service
public class CookServiceImpl implements CookService {
	@Autowired
	private CookMapper cookMapper;
	/**
	 * 添加菜系
	 */
	@Override
	public void add(Cook cook) {
		cookMapper.add(cook);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageResult selectAll(Integer pages, Integer rows,String keyword) {
		PageResult pageResult = new PageResult(pages, rows);
		//分页
		PageHelper.startPage(pageResult.getPage(), pageResult.getRows());
		Page<Cook> selectAll;
		if(keyword!=null&&keyword!=""){
			selectAll=(Page<Cook>) cookMapper.selectLike(keyword);
		}else{
			selectAll = (Page<Cook>) cookMapper.selectAll();
		}
		pageResult.setList(selectAll.getResult());
		pageResult.setTotal(selectAll.getTotal());
		return pageResult;
	}
	@Override
	public Cook findById(Long id) {
		Cook findById = cookMapper.findById(id);
		return findById;
	}
	@Override
	public void update(Cook cook) {
		cookMapper.update(cook);
		
	}
	@Override
	public void delete(int id) {
		cookMapper.delete(id);
	}
	@Override
	public List<Cook> findAll() {
		return cookMapper.selectAll();
	}

}
