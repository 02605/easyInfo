package com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.User;
import com.domain.UserLogin;

public interface UserDao extends BaseDao<UserLogin>{

	//根据职工号找UserLogin
	UserLogin getUserByid(final String tea_id);
	
	//根据职工号查询对应信息
	User getUserMesByid(String tea_id);
	
    //采用User对象存储需要的信息返回列表
	List<User> getUserPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
	//使用hql进行分页查询
	List<User> getUserPageList(String tea_id,Integer start,Integer pageSize);	
	
	//查 符合条件的总记录数	
	Integer	getTotalCount(String tea_id);

}
