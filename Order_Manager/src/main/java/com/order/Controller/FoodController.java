package com.order.Controller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.order.Service.FoodService;
import com.order.pojo.Food;
import com.order.pojo.PageResult;
import com.order.pojo.result;


@RestController
@RequestMapping("/food")
public class FoodController {
	@Autowired
	private FoodService foodService;
	/**
	 * 添加菜品
	 * @param food
	 * @return
	 */
	@RequestMapping("/save")
	public result save(Food food){
		try {
			foodService.save(food);
			return new result("添加成功", true);
		} catch (Exception e) {
			return new result("添加失败", false);
		}
	}
	@RequestMapping("/uploadPic")
	public Map<String,Object> uploadPic(MultipartFile file,HttpServletRequest request){
		// 获取图片原始文件名
		String originalFilename = file.getOriginalFilename();
		// 文件名使用当前时间
		String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		// 获取上传图片的扩展名(jpg/png/...)
		String extension = FilenameUtils.getExtension(originalFilename);
		// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
		String path = "\\detail\\style\\images\\" + name + "." + extension;
		// 图片上传的绝对路径
		String url = request.getSession().getServletContext().getRealPath("") + path;
    	File dir = new File(url);
		if(!dir.exists()) {
		dir.mkdirs();
		}
		// 上传图片
		try {
			file.transferTo(dir);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("path", path);
		map.put("url", url);
		return map;

	}
	/*
	 * 
	 * 分页
	 */
	@RequestMapping("/list")
	public PageResult findlist(Integer pages,Integer rows,String keyword){
		return foodService.findPage(pages,rows,keyword);
	}
	/**
	 * 回显
	 * @param pages
	 * @param rows
	 * @param keyword
	 * @return
	 */
	@RequestMapping("/findById")
	public Food findById(Integer id){
		Food findById = foodService.findById(id);
		return findById;
	}
	
	@RequestMapping("/update")
	public result update(Food food){
		try {
			foodService.update(food);
			return new result("更新成功", true);
		} catch (Exception e) {
			return new result("更新失败",false);
		}
	}
	
	@RequestMapping("/delete")
	public result delete(int id){
		try {
			foodService.delete(id);
			return new result("删除成功", true);
		} catch (Exception e) {
			return new result("删除失败",false);
		}
	}
}
