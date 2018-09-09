package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.Teacher;
import com.domain.User;
import com.domain.UserLogin;
import com.utils.PageBean;

public interface UserService {

	// 登陆
	UserLogin getUserLoginByTea_id(UserLogin userLogin);

	// 根据职工id查找用户信息
	User getUserMesByid(String tea_id);
	UserLogin getUserByid(String tea_id);
	// 注册普通用户
	void saveUser(UserLogin userLogin,Teacher teacher);

	// 修改用户账号信息
	void updateUser(UserLogin user,Teacher teacher);
	
	//删除用户账户
	void deleteUser(UserLogin user,Teacher teacher);
   
//	// 分页查询用户
//	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
//			Integer pageSize);
//	
	//hql分页查询
	PageBean getPageBean(String tea_id, Integer currentPage,
			Integer pageSize);


}
