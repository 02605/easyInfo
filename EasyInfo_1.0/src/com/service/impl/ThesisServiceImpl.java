package com.service.impl;


import com.dao.ThesisDao;
import com.domain.Thesis;
import com.service.ThesisService;

public class ThesisServiceImpl extends BaseServiceImpl<Thesis> implements ThesisService {

	private ThesisDao thesisDao;

	public void setThesisDao(ThesisDao thesisDao) {
		super.setBaseDao(thesisDao);
		this.thesisDao = thesisDao;
	}
}
