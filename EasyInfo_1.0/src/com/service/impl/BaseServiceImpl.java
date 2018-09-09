package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dao.BaseDao;
import com.service.BaseService;
import com.utils.PageBean;

public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> baseDao;
	
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		// 1 调用Dao查询总记录数
				Integer totalCount = baseDao.getTotalCount(dc);
				// 2 创建PageBean对象
				PageBean pb = new PageBean(currentPage, totalCount, pageSize);
				// 3 调用Dao查询分页列表数据
				List<T> list = baseDao.getPageList(dc,
						pb.getStart(), pb.getPageSize());
				// 4 列表数据放入pageBean中.并返回
				pb.setList(list);
				return pb;
	}


	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}


	public List getAnyTypeList(DetachedCriteria dc) {
		List list = baseDao.getAnyTypeList(dc);
		return list;
	}

}
