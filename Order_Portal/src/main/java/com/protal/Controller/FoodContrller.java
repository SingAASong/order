package com.protal.Controller;

import com.protal.Service.FoodService;
import com.protal.pojo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodContrller {
    @Autowired
    FoodService foodService;

    /**
     * 根据cookID查询相应菜系
     * @param id
     * @return
     */
    @RequestMapping("findFood")
    public List<Food> findByCookId(Long id){
        return foodService.findByCookId(id);
    }
}
