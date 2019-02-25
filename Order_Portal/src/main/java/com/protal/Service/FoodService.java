package com.protal.Service;

import com.protal.pojo.Food;

import java.util.List;

public interface FoodService {
    List<Food> findByCookId(Long id);
}
