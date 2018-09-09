package com.service.impl;

import com.dao.PrivateMethodsDao;
import com.dao.PublicMethodsDao;
import com.domain.PrivateTemplate;
import com.domain.PublicTemplate;
import com.service.MethodsService;

public class MethodsServiceImpl implements MethodsService {
	private PrivateMethodsDao privateMethodsDao;
	private PublicMethodsDao publicMethodsDao;

	// 用于spring注入
	public void setPublicMethodsDao(PublicMethodsDao publicMethodsDao) {
		this.publicMethodsDao = publicMethodsDao;
	}

	// 用于spring注入
	public void setPrivateMethodsDao(PrivateMethodsDao privateMethodsDao) {
		this.privateMethodsDao = privateMethodsDao;
	}

	@Override
	public void savePrivateMethods(PrivateTemplate t) {
		privateMethodsDao.save(t);

	}

	@Override
	public void savePublicMethods(PublicTemplate PublicTemplate) {
		// TODO Auto-generated method stub
		publicMethodsDao.save(PublicTemplate);
	}

}
