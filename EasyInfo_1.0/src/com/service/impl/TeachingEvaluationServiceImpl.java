package com.service.impl;

import com.dao.TeachingEvaluationDao;
import com.domain.TeachingEvaluation;
import com.service.TeachingEvaluationService;

public class TeachingEvaluationServiceImpl extends BaseServiceImpl<TeachingEvaluation>
		implements TeachingEvaluationService {

	private TeachingEvaluationDao teachingEvaluationDao;

	public void setTeachingEvaluationDao(TeachingEvaluationDao teachingEvaluationDao) {
		this.teachingEvaluationDao = teachingEvaluationDao;
		super.setBaseDao(teachingEvaluationDao);
	}
	
	
}
