package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dao.TeacherDao;
import com.dao.UserDao;
import com.domain.Teacher;
import com.domain.UserLogin;
import com.domain.User;
import com.service.UserService;
import com.utils.PageBean;
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private TeacherDao teacherDao;
	//登陆
	public UserLogin  getUserLoginByTea_id(UserLogin userLogin) {
		//1根据用户id查找是否存在此用户
		UserLogin existU = userDao.getUserByid(userLogin.getTea_id());
		//查看传递的信息是否错误
		userLogin.toString();
		//2不存在抛出异常
		if(existU == null){
			throw new RuntimeException(userLogin.toString()+"用户不存在");
		}
		//3存在则检验密码是否正确，密码不正确抛出异常
		if(!existU.getUser_password().equals(userLogin.getUser_password())){
			throw new RuntimeException("密码错误");
		}
		//4正确返回UserLogin
		return existU;
	}
	public void saveUser(UserLogin user,Teacher teacher) {
		teacherDao.save(teacher);
		userDao.save(user);		
	}

	public void updateUser(UserLogin user,Teacher teacher) {
		teacherDao.update(teacher);	
		userDao.update(user);		
	}
	
	public void deleteUser(UserLogin user,Teacher teacher) {
		userDao.delete(user);	
		teacherDao.delete(teacher);		
	}
	
	//查找用户信息
//	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
//			Integer pageSize) {
//		//1 调用Dao查询总记录数
//		Integer totalCount = userDao.getTotalCount(dc);
//		//2 创建PageBean对象
//		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
//		//3 调用Dao查询分页列表数据
//	//	List<UserLogin> list = userDao.getPageList(dc,pb.getStart(),pb.getPageSize());
//		List<User> list = userDao.getUserPageList(dc,pb.getStart(),pb.getPageSize());
//		//4 列表数据放入pageBean中.并返回
//		pb.setList(list);
//		return pb;
//	}
	
	//使用hql进行多表分页查询
	public PageBean getPageBean(String tea_id, Integer currentPage,
			Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = userDao.getTotalCount(tea_id);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		List<User> list = userDao.getUserPageList(tea_id,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	//根据职工id查找用户信息
	public User getUserMesByid(String tea_id) {
		return userDao.getUserMesByid(tea_id);
	}
	public UserLogin getUserByid(String tea_id) {
		return userDao.getById(tea_id);
	}

	//set方法使用spring注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
}
