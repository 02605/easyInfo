package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.dao.UserDao;
import com.domain.User;
import com.domain.UserLogin;

//HibernateDaoSupport需要注入sessionfactory
public class UserDaoImpl extends BaseDaoImpl<UserLogin> implements UserDao {

	// 为User实体类指定路径
	private String userLocal = "com.domain.User";

	// 根据职工id找普通用户
	public UserLogin getUserByid(final String tea_id) {
		/*
		 * 使用hql查询 return getHibernateTemplate().execute(new
		 * HibernateCallback<UserLogin>() {
		 * 
		 * @Override public UserLogin doInHibernate(Session session) throws
		 * HibernateException { String hql = "from userlogin where tea_id = ?";
		 * Query query = session.createQuery(hql); query.setParameter(0,
		 * tea_id); UserLogin userLogin = (UserLogin) query.uniqueResult();
		 * return userLogin; } });
		 */

		// 使用Criteria查询
		DetachedCriteria dc = DetachedCriteria.forClass(UserLogin.class);
		dc.add(Restrictions.eq("tea_id", tea_id));
		List<UserLogin> list = (List<UserLogin>) getHibernateTemplate()
				.findByCriteria(dc);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 根据职工id返回对应用户信息
	public User getUserMesByid(String tea_id) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		String hql = "select new " + userLocal
				+ "(u.tea_id,u.user_password,u.user_state,t.tea_role) "
				+ "from Teacher as t,UserLogin as u "
				+ "where u.tea_id = t.tea_id and u.tea_id = ?0";
		Query query = session.createQuery(hql);
		query.setParameter("0", tea_id);
		List<User> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	// 使用hql进行分页查询
	public List<User> getUserPageList(String tea_id, Integer start,
			Integer pageSize) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		String hql = new String();
		Query query;
		if (StringUtils.isEmpty(tea_id)) {
			hql = "select new " + userLocal
					+ "(u.tea_id,u.user_password,u.user_state,t.tea_role) "
					+ "from Teacher as t,UserLogin as u "
					+ "where u.tea_id = t.tea_id ";
			query = session.createQuery(hql);

		} else {
			hql = "select new " + userLocal
					+ "(u.tea_id,u.user_password,u.user_state,t.tea_role) "
					+ "from Teacher as t,UserLogin as u "
					+ "where u.tea_id = t.tea_id and u.tea_id like ?";
			query = session.createQuery(hql);
			query.setString(0, "%" + tea_id + "%");
		}

		query.setFirstResult(start);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public List<User> getUserPageList(DetachedCriteria dc, Integer start,
			Integer pageSize) {
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(
				dc, start, pageSize);
		return list;
	}

	public Integer getTotalCount(String tea_id) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Query query;
		String hql;
		if (StringUtils.isEmpty(tea_id)) {
			hql = "select count(*)  from UserLogin ";
			query = session.createQuery(hql);
		} else {
			hql = "select count(*) from UserLogin as u where u.tea_id like ?";
			query = session.createQuery(hql).setString(0,"%" + tea_id + "%");
		}
		int count = ((Long) query.iterate().next()).intValue();
		return count;

	}
}
