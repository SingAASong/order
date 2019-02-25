package com.order.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.order.Mapper.TableMapper;
import com.order.Service.TableService;
import com.order.pojo.Order;
import com.order.pojo.PageResult;

import javax.annotation.Resource;

@Service
public class TableServiceImpl implements TableService{
	
	@Resource
	private TableMapper tableMapper;
	@Override
	public void AddTable(String bName) {
		Order order = new Order();
		//设置新餐桌名称
		order.setTableName(bName);
		//设置餐桌状态为空闲
		order.setStatus("0");
		order.setCreatTime("");
		tableMapper.insert(order);
		
	}
	/**
	 * 分页
	 */
	@Override
	public PageResult showList(String keyword,Integer page, Integer row) {
		//用pageResult接收
		PageResult pageResult = new PageResult(page,row);
		//mybatis分页
		Page startPage = PageHelper.startPage(pageResult.getPage(),pageResult.getRows());
		Page<Order> result;
		if(keyword!=null&&keyword!=""){
			result = (Page<Order>) tableMapper.selectByem(keyword);
		}else{
			result = (Page<Order>) tableMapper.selectAll();
		}
		//分页结果
		List<Order> result1 = result.getResult();
		pageResult.setList(result1);

		//总条数
		long total = result.getTotal();
		pageResult.setTotal(total);
		return pageResult;
	}
	@Override
	public void updateById(Integer id) {
		Order order = tableMapper.findById(id);
		if(order.getStatus().equals("1")){
			order.setStatus("0");
			order.setCreatTime("");
			tableMapper.update(order);
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		tableMapper.deleteById(id);
	}
	
	@Override
	public void plannedTable(Integer id) {
		//设置预定餐桌的时间
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("creatTime",date);
		//设置状态为预定“1”
		map.put("status","1");
		tableMapper.updateById(map);
	}

}
