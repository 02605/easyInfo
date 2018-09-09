package com.test;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.TeacherDao;
import com.dao.TeachingEvaluationDao;
import com.dao.UserDao;
import com.domain.AnnualReview;
import com.domain.CompileMateria;
import com.domain.Teacher;
import com.domain.TeachingEvaluation;
import com.domain.Thesis;
import com.domain.UserLogin;
import com.domain.VerticalResearch;
import com.service.ThesisService;
import com.service.UserService;
import com.service.VerticalResearchService;
import com.utils.PageBean;

/**
 * 
 * @author DELL
 * @authorEmail lamadiemofly@163.com
 * @ClassName: HibernateTest
 * @Description: TODO(用于测试hibernate的各种查询)
 * @date 2018年8月29日 上午8:55:58
 * 
 */
@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

	@Resource(name = "teacherDao")
	private TeacherDao td;

	@Resource(name = "userService")
	private UserService us;
	
	@Resource(name="thesisService")
	private ThesisService ts; 
	
	@Resource(name="verticalResearchService")
	private VerticalResearchService vs;
	@Test
	/**
	 * 
	 * @Title: fun1 
	 * @Description: TODO(单独测试hibernate) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun1() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// --------------------------------------------
		UserLogin userLogin = new UserLogin();
		userLogin.setTea_id("2016405A517");
		userLogin.setUser_password("1234");
//		userLogin.setUser_state("1");
		session.save(userLogin);
		// --------------------------------------------

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Resource(name = "sessionFactory")
	private SessionFactory sf;

	@Test
	/**
	 * 
	 * @Title: fun2 
	 * @Description: TODO(测试spring管理sessionFactory) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun2() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// --------------------------------------------
		UserLogin userLogin = new UserLogin();
		userLogin.setTea_id("renxu");
		userLogin.setUser_password("4567");
//		userLogin.setUser_state("1");
		session.save(userLogin);
		// --------------------------------------------

		transaction.commit();
		session.close();
	}

	@Resource(name = "userDao")
	private UserDao ud;

	@Test
	/**
	 * 
	 * @Title: fun3 
	 * @Description: TODO(测试dao hibernate模板) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun3() {
//		UserLogin userLogin = ud.getUserLoginByTea_id("任旭");
//		System.out.println(userLogin);
	}

	@Test
	/**
	 * 
	 * @Title: fun4 
	 * @Description: TODO(测试spring整合事务) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun4() {
		UserLogin userLogin = new UserLogin();
		userLogin.setTea_id("rose");
		userLogin.setUser_password("1234");
//		userLogin.setUser_state("1");
		System.out.println(userLogin);
//		us.saveUserLogin(userLogin);
	}

	@Test
	/**
	 * 
	 * @Title: fun6 
	 * @Description: TODO(测试离线查询) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun6() {
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		dc.add(Restrictions.eq("tea_id", "2018"));
		List<Teacher> list = td.getList(dc);
		for (Teacher teacher : list) {
			Set<TeachingEvaluation> evaluationS = teacher
					.getTeachingEvaluationS();
			for (TeachingEvaluation teachingEvaluation : evaluationS) {
				System.out.println(teachingEvaluation);
			}
		}
		System.out.println(list);
	}

	@Resource(name = "teachingEvaluationDao")
	private TeachingEvaluationDao ted;

	@Test
	/**
	 * 
	 * @Title: fun7 
	 * @Description: TODO(测试查询教师评估信息date时间的查询) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun7() {
		DetachedCriteria dc = DetachedCriteria
				.forClass(TeachingEvaluation.class);
		dc.add(Restrictions.sqlRestriction("tea_eva_year like '%2015%'"));
		List<TeachingEvaluation> list = ted.getList(dc);
		for (TeachingEvaluation teachingEvaluation : list) {
			System.out.println(teachingEvaluation);
		}
	}

	@Test
	/**
	 * 
	 * @Title: fun8 
	 * @Description: TODO(测试满足基础信息的查询教师评估信息) 
	 * @Description: TODO(查询名为tom，角色为超级管理员的教师的评估信息)
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun8() {
		DetachedCriteria dc = DetachedCriteria
				.forClass(TeachingEvaluation.class);
		dc.createAlias("tea_id", "t");
		dc.createAlias("t.tea_role", "basedict");
		dc.add(Restrictions.eq("t.tea_name", "tom"));
		dc.add(Restrictions.eq("basedict.dict_item_name", "超级管理员"));
		List<TeachingEvaluation> list = ted.getList(dc);
		if (list != null && list.size() > 0) {
			for (TeachingEvaluation teachingEvaluation : list) {
				System.out.println(teachingEvaluation);
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
	}

	@Test
	/***
	 * 
	 * @Title: fun9 
	 * @Description: TODO(查询系别是经济管理系 或 计算机与遥感信息技术学院的教学评估信息) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun9() {
		DetachedCriteria dc = DetachedCriteria
				.forClass(TeachingEvaluation.class);
		// 建立引用
		dc.createAlias("tea_id", "t");
		dc.createAlias("t.tea_dep", "basedict");
		dc.add(Restrictions.or(
				Restrictions.eq("basedict.dict_item_name", "经济管理系"),
				Restrictions.eq("basedict.dict_item_name", "计算机与遥感信息技术学院")));
		List<TeachingEvaluation> list = ted.getList(dc);
		if (list != null && list.size() > 0) {
			for (TeachingEvaluation teachingEvaluation : list) {
				System.out.println(teachingEvaluation);
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
	}

	@Test
	/**
	 * 
	 * @Title: fun10 
	 * @Description: TODO(测试按照sqlDate类型的区间查询，并按照时间升序排序) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun10() {
		DetachedCriteria dc = DetachedCriteria
				.forClass(TeachingEvaluation.class);
		String begin = "2010-10-5";
		String end = "2020-10-5";
		java.sql.Date beginDate = java.sql.Date.valueOf(begin);
		java.sql.Date endDate = java.sql.Date.valueOf(end);
		dc.add(Restrictions.between("tea_eva_year", beginDate, endDate));
		dc.addOrder(Order.asc("tea_eva_year"));
		List<TeachingEvaluation> list = ted.getList(dc);
		if (list != null && list.size() > 0) {
			for (TeachingEvaluation teachingEvaluation : list) {
				System.out.println(teachingEvaluation);
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
	}

	@Test
	/**
	 * 
	 * @Title: fun11 
	 * @Description: TODO(查找教师测评成绩为优秀的教师信息,存在教师重复问题) 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun11() {
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		// 建立引用
		dc.createAlias("TeachingEvaluationS", "tes");
		dc.createAlias("tes.tea_eva_grade", "baseDict");
		dc.add(Restrictions.eq("baseDict.dict_item_name", "优秀"));
		List<Teacher> list = td.getList(dc);
		if (list != null && list.size() > 0) {
			for (Teacher teacher : list) {
				System.out.println(teacher);
				for (TeachingEvaluation teachingEvaluation : teacher
						.getTeachingEvaluationS()) {
					System.out.println(teachingEvaluation);
				}
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
	}

	@Test
	/**
	 * 
	 * @Title: fun12 
	 * @Description: TODO(解决fun11的问题)
	 * 解决：限定条件： dc.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
	 * 可以解决，但也存在缺陷：ResultTransformer也只是对查询结果集做手脚，这样会造成分页的问题
	 * （本来一页应该有10条记录，但如果仅仅是在查询当前页做distinct，会导致本页只有9条）
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun12() {
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		// 建立引用
		dc.createAlias("TeachingEvaluationS", "tes");
		dc.createAlias("tes.tea_eva_grade", "baseDict");
		dc.add(Restrictions.eq("baseDict.dict_item_name", "优秀"));
		dc.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		List<Teacher> list = td.getList(dc);
		if (list != null && list.size() > 0) {
			for (Teacher teacher : list) {
				System.out.println(teacher);
				for (TeachingEvaluation teachingEvaluation : teacher
						.getTeachingEvaluationS()) {
					System.out.println(teachingEvaluation);
				}
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
	}

	@Test
	/**
	 * 
	 * @Title: fun13 
	 * @Description: TODO(fun12的解决方法)
	 * 先唯一查询符合条件的列，再使用in查询对象集 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void fun13() {
		double start  = System.currentTimeMillis();
		DetachedCriteria dc1 = DetachedCriteria.forClass(Teacher.class);
		DetachedCriteria dc2 = DetachedCriteria.forClass(Teacher.class);
		// 建立引用
		dc1.createAlias("TeachingEvaluationS", "tes");
		dc1.createAlias("tes.tea_eva_grade", "baseDict");
		dc1.add(Restrictions.eq("baseDict.dict_item_name", "优秀"));
		// 设置只查询tea_id列
		dc1.setProjection(Projections.distinct(Projections.property("tea_id")));
		List list = td.getAnyTypeList(dc1);
		dc1.setProjection(null);
		dc2.add(Restrictions.in("tea_id", list));
		List<Teacher> list2 = td.getList(dc2);
		if (list2 != null && list2.size() > 0) {
			for (Teacher teacher : list2) {
				System.out.println(teacher);
				/*
				 * for(TeachingEvaluation teachingEvaluation :
				 * teacher.getTeachingEvaluationS()){
				 * System.out.println(teachingEvaluation); }
				 */
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
		 double end = System.currentTimeMillis(); 
         System.out.println("time is : " + (end - start)/100); 

	}

	@Test
	/**
	 * 测试教师表和教学评估的关联
	* @Title: fun14 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void fun14(){
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		dc.add(Restrictions.eq("tea_id", "101"));
		List<Teacher> list = td.getList(dc);
		for (Teacher teacher : list) {
			Set<AnnualReview> set = teacher.getAnnualReviewS();
			for (AnnualReview annualReview : set) {
				System.out.println(annualReview);
			}
			//System.out.println(teacher.toString());
		}
	}
	
	@Test
	/**
	 * 
	* @Title: fun15 
	* @Description: TODO(查询论文等级为SCI检索的教师) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void fun15() {
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		// 建立引用
		dc.createAlias("ThesisS", "thes");
		dc.createAlias("thes.the_level", "baseDict");
		dc.add(Restrictions.eq("baseDict.dict_item_name", "SCI检索"));
		List<Teacher> list = td.getList(dc);
		if (list != null && list.size() > 0) {
			for (Teacher teacher : list) {
				for (Thesis thesis : teacher.getThesisS()) {
					System.out.println(thesis);
				}
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
	}
	
	@Test
	/**
	 * 教材著作查询
	* @Title: fun16 
	* @Description: TODO(查询系别是机电工程学院的教师著作) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void fun16() {
		double start  = System.currentTimeMillis();
		DetachedCriteria dc = DetachedCriteria.forClass(CompileMateria.class);
		// 建立引用
		dc.createAlias("tea_id", "teacher");
		dc.createAlias("teacher.tea_dep", "baseDict");
		dc.add(Restrictions.eq("baseDict.dict_item_name", "机电工程学院"));
		List<CompileMateria> list = td.getAnyTypeList(dc);
		if (list != null && list.size() > 0) {
			for (CompileMateria compileMateria : list) {
				System.out.println(compileMateria.toString());
			}
		} else {
			System.out.println("没有该内容。。。。。。。");
		}
		 double end = System.currentTimeMillis(); 
         System.out.println("time is : " + (end - start)/100); 

	}
	
	
	@Test
	/**
	 * 
	* @Title: fun17 
	* @Description: TODO(表关联配置完毕，测试表数据) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void fun17(){
		double start  = System.currentTimeMillis();
		Teacher teacher = td.getById("2018");
		double end = System.currentTimeMillis(); 
        System.out.println("time is : " + (end - start)/100); 
	}
	
	@Test
	public void fun18(){
		double start  = System.currentTimeMillis();
		DetachedCriteria dc = DetachedCriteria.forClass(Thesis.class);
		PageBean pageBean = ts.getPageBean(dc, 1, 5);
		double end = System.currentTimeMillis(); 
        System.out.println("time is : " + (end - start)/100); 
	}
	
	@Test
	public void fun19(){
		double start  = System.currentTimeMillis();
		DetachedCriteria dc = DetachedCriteria.forClass(VerticalResearch.class);
		dc.setProjection(Projections.distinct(Projections
				.property("ver_id")));
		List list = vs.getAnyTypeList(dc);
		System.out.println(list);
		double end = System.currentTimeMillis(); 
        System.out.println("time is : " + (end - start)/100); 
	}
}
