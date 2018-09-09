package com.service.impl;

import com.dao.RewardDao;
import com.domain.Reward;
import com.service.RewardService;

public class RewardServiceImpl extends BaseServiceImpl<Reward> implements
		RewardService {
	
	private RewardDao rewardDao;

	public void setRewardDao(RewardDao rewardDao) {
		this.rewardDao = rewardDao;
		super.setBaseDao(rewardDao);
	}
	
}
