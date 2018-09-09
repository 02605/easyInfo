package com.service.impl;

import java.util.List;

import com.dao.BaseDictDao;
import com.domain.BaseDict;
import com.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;

	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return baseDictDao.getListByTypeCode(dict_type_code);
	}

	public List<BaseDict> getListById(String dict_id) {
		return baseDictDao.getListById(dict_id);
	}

	public List<BaseDict> getListByItemName(String dict_item_name) {
		return baseDictDao.getListByItemName(dict_item_name);
	}

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

}
