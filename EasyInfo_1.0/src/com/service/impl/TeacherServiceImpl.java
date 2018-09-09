package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dao.TeacherDao;
import com.dao.UserDao;
import com.domain.Teacher;
import com.domain.User;
import com.domain.UserLogin;
import com.service.TeacherService;
import com.utils.PageBean;
import com.dao.getListFromDBDao;
import com.dao.impl.getListFromDBDaoImpl;
public class TeacherServiceImpl implements TeacherService {

	private getListFromDBDaoImpl getListFromDBDao;
	private TeacherDao teacherDao;
	@Override
	//展示教师信息
	public ArrayList<Object> getAllTeacherByid(UserLogin user) {
		//1根据用户id查找是否存在此用户
		System.out.println("11111111111111111111111111111111111111");
		ArrayList<Object> existU = getListFromDBDao.getList(user.getTea_id());
		
		System.out.println("222222222222222222222222222222222222222");
		
		//查看传递的信息是否错误
		user.toString();
		//2不存在抛出异常
		if(existU == null){
			throw new RuntimeException(user.toString()+"用户不存在");
		}
		//3正确返回UserLogin
		return existU;
	}
	
	

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		// 1 调用Dao查询总记录数
		Integer totalCount = teacherDao.getTotalCount(dc);
		// 2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3 调用Dao查询分页列表数据
		List<Teacher> list = (List<Teacher>) teacherDao.getPageList(dc,
				pb.getStart(), pb.getPageSize());
		// 4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public List<Teacher> getTeaByDC(DetachedCriteria dc) {
		List<Teacher> list = teacherDao.getList(dc);
		return list;
	}

	@Override
	public List getAnyTypeList(DetachedCriteria dc1) {
		List list = teacherDao.getAnyTypeList(dc1);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	// 获取教师个人数据信息
	public Teacher getTeacherByid(String tea_id) {
		return teacherDao.getById(tea_id);
	}
	//注入Dao

	public void setGetListFromDBDao(getListFromDBDaoImpl getListFromDBDao) {
		this.getListFromDBDao = getListFromDBDao;
	}
}
