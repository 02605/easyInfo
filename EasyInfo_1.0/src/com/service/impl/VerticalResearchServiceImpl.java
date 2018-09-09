package com.service.impl;

import com.dao.VerticalResearchDao;
import com.domain.VerticalResearch;
import com.service.VerticalResearchService;

public class VerticalResearchServiceImpl extends
		BaseServiceImpl<VerticalResearch> implements VerticalResearchService {

	private VerticalResearchDao verticalResearchDao;

	public void setVerticalResearchDao(VerticalResearchDao verticalResearchDao) {
		this.verticalResearchDao = verticalResearchDao;
		super.setBaseDao(verticalResearchDao);
	}

}
