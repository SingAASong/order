package com.protal.Controller;

import com.protal.Service.HomePageService;
import com.protal.pojo.NewTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homePage")
public class HomePageController {
    @Autowired
    HomePageService homePageService;

    /**
     * 查询所有的餐桌名称
     * @return
     */
    @RequestMapping("/findTable")
    public List<NewTable> selectAllTable(){
        return homePageService.selectAll();
    }
}
