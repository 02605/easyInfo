package com.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.Teacher;
import com.domain.User;
import com.domain.UserLogin;
import com.utils.PageBean;

public interface TeacherService {
	
	//查询教师信息 以便展示
	ArrayList<Object>  getAllTeacherByid(UserLogin user);

	//查询分页数据
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	//查询教师信息
	List<Teacher> getTeaByDC(DetachedCriteria dc);

	//查询任何类型的返回
	List getAnyTypeList(DetachedCriteria dc1);
	 //获取教师个人信息
	Teacher getTeacherByid(String tea_id);

	

	


}
