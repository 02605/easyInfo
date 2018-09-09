package com.service;

import com.domain.PublicTemplate;

import com.domain.PrivateTemplate;

public interface MethodsService {
//	// 根据教师id查询私人模板
//	PrivateTemplate getPrivateMethodsByTea_id(PrivateTemplate privateTemplate);
	// 新增私人模板
	void savePrivateMethods(PrivateTemplate privateTemplate);
	
//	// 根据教师id查询私人模板
//	PublicTemplate getPublicMethodsByTea_id(privateTemplate privateTemplate);
	// 新增私人模板
	void savePublicMethods(PublicTemplate PublicTemplate);
}
