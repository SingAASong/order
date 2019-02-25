package com.order.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.order.pojo.Cook;

public interface CookMapper {
    void add(Cook cook);
    List<Cook> selectAll();
	Cook findById(Long id);
	void update(Cook cook);
	List<Cook> selectLike(@Param(value="keyword")String keyword);
	void delete(int id);
}
