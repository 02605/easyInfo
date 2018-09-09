package com.service;

import com.domain.AdminLogin;


public interface AdminService {
	//登陆
	AdminLogin  getAdminLoginByTea_id(AdminLogin admin);
	
	//注册用户
	void save(AdminLogin admin);
	
	//修改用户
	void update(AdminLogin admin);
	
	//删除用户
	void delete(AdminLogin admin);
	
	//查找用户
	AdminLogin getAdminByid(String tea_id);
}
