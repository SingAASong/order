package com.order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.order.Service.TableService;
import com.order.pojo.PageResult;
import com.order.pojo.result;

import java.util.List;

@RestController
public class TableController {
	
	@Autowired
	private TableService tableservice;
	
	@RequestMapping("/add")
	public result addTable(String bName){
		try {
			tableservice.AddTable(bName);
			return new result("添加成功", true);
		} catch (Exception e) {
			return new result("添加失败", true);
		}
	}
	
	@RequestMapping("/list")
	public PageResult list(String keyword,Integer pages,Integer rows) {
		PageResult showList = tableservice.showList(keyword,pages, rows);
		List list = showList.getList();

		return showList;
	}
	
	@RequestMapping("/returnTable")
	public result returnTable(Integer ids) {
		try {
			tableservice.updateById(ids);
			return new result("退桌成功", true);
		} catch (Exception e) {
			return new result("退桌失败", false);
		}
	}
	@RequestMapping("/deleteTable")
	public result deleteTable(Integer id) {
		try {
			tableservice.deleteById(id);
			return new result("删除成功", true);
		} catch (Exception e) {
			return new result("删除失败", false);
		}
	}
	@RequestMapping("/planned")
	public result planned(Integer ids) {
		try {
			tableservice.plannedTable(ids);
			return new result("预定成功", true);
		} catch (Exception e) {
			return new result("预定失败", false);
		}
	}
}
