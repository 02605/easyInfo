package com.dao;

import java.util.List;

import com.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);
	List<BaseDict> getListById(String dict_id);
	List<BaseDict> getListByItemName(String dict_item_name);
}
