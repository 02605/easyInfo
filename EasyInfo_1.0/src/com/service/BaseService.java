package com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.utils.PageBean;

public interface BaseService<T> {
	
	//查询分页数据
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	//查询任何类型返回
	List getAnyTypeList(DetachedCriteria dc);

}
