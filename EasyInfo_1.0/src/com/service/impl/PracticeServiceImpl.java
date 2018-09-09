package com.service.impl;

import com.dao.PracticeDao;
import com.domain.Practice;
import com.service.PracticeService;

public class PracticeServiceImpl extends BaseServiceImpl<Practice> implements
		PracticeService {
	
	private PracticeDao practiceDao;

	public void setPracticeDao(PracticeDao practiceDao) {
		this.practiceDao = practiceDao;
		super.setBaseDao(practiceDao);
	}
	
	
}
