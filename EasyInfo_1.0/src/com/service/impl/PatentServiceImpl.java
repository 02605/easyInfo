package com.service.impl;

import com.dao.PatentDao;
import com.domain.Patent;
import com.service.PatentService;

public class PatentServiceImpl extends BaseServiceImpl<Patent> implements PatentService {

	private PatentDao patentDao;



	public void setPatentDao(PatentDao patentDao) {
		this.patentDao = patentDao;
		super.setBaseDao(patentDao);
	}

}
