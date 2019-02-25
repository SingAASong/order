package com.protal.Mapper;

import java.util.List;

import com.protal.pojo.Cook;
import com.protal.pojo.CookExample;
import org.apache.ibatis.annotations.Param;

public interface CookMapper {
    long countByExample(CookExample example);

    int deleteByExample(CookExample example);

    int insert(Cook record);

    int insertSelective(Cook record);

    List<Cook> selectByExample(CookExample example);

    int updateByExampleSelective(@Param("record") Cook record, @Param("example") CookExample example);

    int updateByExample(@Param("record") Cook record, @Param("example") CookExample example);
}