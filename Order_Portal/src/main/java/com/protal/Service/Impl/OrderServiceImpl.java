package com.protal.Service.Impl;

import com.protal.Mapper.CookMapper;
import com.protal.Service.OrderService;
import com.protal.pojo.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    CookMapper cookMapper;

    /**
     * 查询所有菜系名称
     * @return
     */
    @Override
    public List<Cook> selectAllCook() {
        return cookMapper.selectByExample(null);
    }
}
