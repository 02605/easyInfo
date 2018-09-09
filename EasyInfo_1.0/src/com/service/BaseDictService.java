package com.service;

import java.util.List;

import com.domain.BaseDict;

public interface BaseDictService {
	//根据类别查找BaseDict的集合list
	List<BaseDict> getListByTypeCode(String dict_type_code);
	
	//根据i查找BaseDict的集合list
	 List<BaseDict> getListById(String dict_id);
	 
	//根据项目名查找BaseDict的集合list
	 List<BaseDict> getListByItemName(String dict_item_name);
}
