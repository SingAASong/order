package com.protal.Controller;

import com.protal.Service.OrderService;
import com.protal.pojo.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    /*查询所有的菜系名称*/
    @RequestMapping("/findAll")
    public List<Cook> selectAllCook(){
        return orderService.selectAllCook();
    }
}
