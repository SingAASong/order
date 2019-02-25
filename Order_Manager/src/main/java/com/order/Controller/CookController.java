package com.order.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.order.Service.CookService;
import com.order.pojo.Cook;
import com.order.pojo.PageResult;
import com.order.pojo.result;

@Controller
@RequestMapping("/cook")
public class CookController {
	@Autowired
	private CookService cookService;
	
	@RequestMapping("/add")
	@ResponseBody
	public result add(Cook cook){
		try {
			cookService.add(cook);
			return new result("添加成功", true);
		} catch (Exception e) {
			return new result("添加失败", false);
		}
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Cook> findAll(){
		List<Cook> findAll = cookService.findAll();
		return findAll;
		}
	
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(Integer pages,Integer rows,String keyword){
		PageResult selectAll = cookService.selectAll(pages,rows,keyword);
		return selectAll;
		}
	
	@RequestMapping("/find")
	@ResponseBody
	public Cook findById(Long id){
		Cook findById = cookService.findById(id);
		return findById;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public result save(Cook cook){
		try {
			cookService.update(cook);
			return new result("更新成功", true);
		} catch (Exception e) {
			return new result("更新失败", false);
		}
		}
	@RequestMapping("/delete")
	@ResponseBody
	public result delete(int id){
		try {
			cookService.delete(id);
			return new result("删除成功", true);
		} catch (Exception e) {
			return new result("删除失败", false);
		}
		}
}
