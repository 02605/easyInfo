package com.service.impl;

import com.dao.AdminDao;
import com.domain.AdminLogin;
import com.domain.User;
import com.domain.UserLogin;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	@Override
	public AdminLogin getAdminLoginByTea_id(AdminLogin admin) {
		//1根据用户id查找是否存在此用户
				AdminLogin existU = adminDao.getById(admin.getTea_id());
				//2不存在抛出异常
				if(existU == null){
					throw new RuntimeException("用户不存在");
				}
				//3存在则检验密码是否正确，密码不正确抛出异常
				if(!existU.getAdmin_password().equals(admin.getAdmin_password())){
					throw new RuntimeException("密码错误");
				}
				//4正确返回UserLogin
				return existU;
	}
	//注册（保存）
	public void save(AdminLogin admin) {
		adminDao.save(admin);
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void update(AdminLogin admin) {
		adminDao.update(admin);
		
	}

	public AdminLogin getAdminByid(String tea_id) {
		return adminDao.getById(tea_id);
	}

	public void delete(AdminLogin admin) {
		adminDao.delete(admin);
		
	}

	
}
