package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增
	void save(T t);
	//删
	void delete(T t);
	//删
	void delete(Serializable id);
	//改
	void update(T t);
	//查 根据id查询
	T	getById(Serializable id);
	//查 根据id查询
	T	getById(String id);
	//查 符合条件的总记录数
	Integer	getTotalCount(DetachedCriteria dc);
	//查 查询分页列表数据
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	//查 查符合条件的所有
	List<T> getList(DetachedCriteria dc);
	//查询任何返回类型的结果
	List getAnyTypeList(DetachedCriteria dc);

}
