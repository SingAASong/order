package com.protal.Service.Impl;

import com.protal.Mapper.FoodMapper;
import com.protal.Service.FoodService;
import com.protal.pojo.Food;
import com.protal.pojo.FoodExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodMapper foodMapper;
    @Override
    public List<Food> findByCookId(Long id) {
        //创建查询条件
        FoodExample foodExample = new FoodExample();
        FoodExample.Criteria criteria = foodExample.createCriteria();
        criteria.andCookIdEqualTo(id);
        return foodMapper.selectByExample(foodExample);
    }
}
