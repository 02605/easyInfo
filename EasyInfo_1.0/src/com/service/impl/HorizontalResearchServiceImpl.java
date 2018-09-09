package com.service.impl;

import com.dao.HorizontalResearchDao;
import com.domain.HorizontalResearch;
import com.service.HorizontalResearchService;

public class HorizontalResearchServiceImpl extends
		BaseServiceImpl<HorizontalResearch> implements
		HorizontalResearchService {
	
	private HorizontalResearchDao horizontalResearchDao;

	public void setHorizontalResearchDao(HorizontalResearchDao horizontalResearchDao) {
		this.horizontalResearchDao = horizontalResearchDao;
		super.setBaseDao(horizontalResearchDao);
	}
	
	
	
}
