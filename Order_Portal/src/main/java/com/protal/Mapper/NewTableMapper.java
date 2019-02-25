package com.protal.Mapper;


import com.protal.pojo.NewTable;
import com.protal.pojo.NewTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewTableMapper {
    long countByExample(NewTableExample example);

    int deleteByExample(NewTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewTable record);

    int insertSelective(NewTable record);

    List<NewTable> selectByExample(NewTableExample example);

    NewTable selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewTable record, @Param("example") NewTableExample example);

    int updateByExample(@Param("record") NewTable record, @Param("example") NewTableExample example);

    int updateByPrimaryKeySelective(NewTable record);

    int updateByPrimaryKey(NewTable record);
}