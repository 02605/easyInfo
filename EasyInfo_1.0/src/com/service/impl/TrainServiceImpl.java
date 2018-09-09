package com.service.impl;

import com.dao.TrainDao;
import com.domain.Train;
import com.service.TrainService;

public class TrainServiceImpl extends BaseServiceImpl<Train> implements
		TrainService {

	private TrainDao trainDao;

	public void setTrainDao(TrainDao trainDao) {
		this.trainDao = trainDao;
		super.setBaseDao(trainDao);
	}
	
}
