package com.protal.Service.Impl;

import com.protal.Mapper.NewTableMapper;
import com.protal.Service.HomePageService;
import com.protal.pojo.NewTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页服务层
 */
@Service
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    NewTableMapper newTableMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<NewTable> selectAll() {
        return newTableMapper.selectByExample(null);
    }
}
