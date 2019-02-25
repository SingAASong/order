package com.protal.Service;

import com.protal.pojo.Cook;

import java.util.List;

public interface OrderService {
    /**
     * 查询所有菜系名称
     * @return
     */
    List<Cook> selectAllCook();
}
