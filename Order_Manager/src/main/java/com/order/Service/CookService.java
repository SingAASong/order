package com.order.Service;

import java.util.List;

import com.order.pojo.Cook;
import com.order.pojo.PageResult;

public interface CookService {
	 void add(Cook cook);

	 PageResult selectAll(Integer pages, Integer rows, String keyword);

	 Cook findById(Long id);

	 void update(Cook cook);

	 void delete(int id);

	 List<Cook> findAll();
}
