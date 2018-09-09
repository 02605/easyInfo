package com.test;

import java.util.Date;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.AdminDao;
import com.dao.TeacherDao;
import com.dao.TeachingEvaluationDao;
import com.dao.UserDao;
import com.dao.impl.TeacherDaoImpl;
import com.domain.AdminLogin;
import com.domain.PublicTemplate;
import com.domain.Teacher;
import com.domain.TeachingEvaluation;
import com.domain.UserLogin;
import com.domain.PrivateTemplate;
import com.service.MethodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class tyhHibernateTest {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 测试UserLogin对象的写入
	 */
	@Test
	public void testUserLogin() {
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
	}

	@Resource(name = "teacherDao")
	private TeacherDao teacherDao;

	/**
	 * 测试teacher对象的读取
	 */
	@Test
	public void teacherTest() {
		Teacher teacher = teacherDao.getById("101");
		int count = teacherDao.getTotalCount(DetachedCriteria
				.forClass(Teacher.class));
		System.out.println(teacher.toString());
		System.out.println(count);
	}

	/**
	 * 测试teacher对象的写入,spring
	 */
	@Test
	public void teacherTest2() {
		Teacher teacher = new Teacher();
		teacher.setTea_id("2016405A621");
		teacher.setTea_home("浙江台州");
		teacher.setTea_qq("827957168");
		teacherDao.save(teacher);
	}

	/**
	 * 测试sessionFactory存储事务
	 */

	@Test
	public void teacherTest3() {
		Teacher teacher = new Teacher();
		teacher.setTea_id("2016405A621");
		teacher.setTea_home("浙江台州");
		teacher.setTea_qq("827957168");
		teacherDao.save(teacher);
	}

	/**
	 * 获取管理员登陆信息
	 */
	@Resource(name = "adminDao")
	private AdminDao ad;

	@Test
	public void getAdminLogin() {
		AdminLogin adminLogin = ad.getById("2016");
		System.out.println(adminLogin.toString());
	}

	/**
	 * 获取教学评估信息
	 */
	@Resource(name = "teachingEvaluationDao")
	private TeachingEvaluationDao te;

	@Test
	public void getTeachingEvaluation() {
		TeachingEvaluation temp = te.getById(1);
		TeachingEvaluation temp2 = te.getById(2);
		System.out.println(temp.getTea_eva_year());
		System.out.println(temp2.getTea_eva_year());
	}

	@Resource(name = "methodsService")
	private MethodsService ms;
	@Resource(name = "teacherDao")
	private TeacherDao td;

	@Test
	public void methodsOption() {
		// PrivateTemplate pt = new PrivateTemplate();
		// pt.setPri_tem_id(1);
		// pt.setPri_tem_describe("hello");
		// Teacher t = td.getById("101");
		// pt.setTea_id(t);
		// pt.setPri_tem_url("test");
		// pt.setPri_tem_name("world");
		// pt.setPri_tem_img("what fuck...");
		// ms.savePrivateMethods(pt);
		PublicTemplate pt = new PublicTemplate();
		pt.setPub_tem_id(1);
		pt.setPub_tem_describe("hello");
		pt.setPub_tem_url("test");
		pt.setPub_tem_name("world");
		pt.setPub_tem_img("what fuck...");
		ms.savePublicMethods(pt);
	}
}
