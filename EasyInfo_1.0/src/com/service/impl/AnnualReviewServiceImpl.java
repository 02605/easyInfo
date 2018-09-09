package com.service.impl;

import com.dao.AnnualReviewDao;
import com.domain.AnnualReview;
import com.service.AnnualReviewService;

public class AnnualReviewServiceImpl extends BaseServiceImpl<AnnualReview>
		implements AnnualReviewService {

	private AnnualReviewDao annualReviewDao;

	public void setAnnualReviewDao(AnnualReviewDao annualReviewDao) {
		this.annualReviewDao = annualReviewDao;
		super.setBaseDao(annualReviewDao);
	}
	
}
