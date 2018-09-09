package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dao.BaseDictDao;
import com.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements
		BaseDictDao {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {

		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		// 添加查询条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		// 执行查询，返回结果
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate()
				.findByCriteria(dc);
		return list;
	}
	public List<BaseDict> getListById(String dict_id) {

		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		// 添加查询条件
		dc.add(Restrictions.eq("dict_id", dict_id));
		// 执行查询，返回结果
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate()
				.findByCriteria(dc);
		return list;
	}
	public List<BaseDict> getListByItemName(String dict_item_name) {

		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		// 添加查询条件
		dc.add(Restrictions.eq("dict_item_name", dict_item_name));
		// 执行查询，返回结果
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate()
				.findByCriteria(dc);
		return list;
	}
}
