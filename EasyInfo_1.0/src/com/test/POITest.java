package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.utils.showExcel.POIReadExcelToHtml;
import com.utils.showExcel.excel2Picture;
import com.dao.TeacherDao;
import com.domain.AnnualReview;
import com.domain.Teacher;
import com.domain.TeachingEvaluation;
import com.service.ExcelService;

/*
 * 这是junit4整合测试必须的文件，
 * @RunWith：读取junit4测试包
 * @ContextConfiguration：访问配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class POITest {
	/*
	 * 哪里使用哪里就注解注入dao
	 * 
	 * @Resource 的name属性为application配置文件中dao对应的name属性值 任旭
	 */

	// // 这个注解必须加否则报错
	// @Autowired
	// @Resource(name = "getListFromDBDao")
	// private getListFromDBDao gd;
	//
	@Resource(name = "excelService")
	private ExcelService es;

	@Test
	public void testExcelService() throws Exception {
		// 模拟批量生成，后续由action提供teacherList
		// 使用批量导出的时候，传递一个包含了需要批量导出的教师信息list即可
		long start, end;
		start = System.currentTimeMillis();

		ArrayList<String> teaList = new ArrayList<String>();
		teaList.add("101");
		// teaList.add("102");
		// 新建resultList，存储处理后的数据
		ArrayList<String[]> resultList = new ArrayList<String[]>();
		// 遍历teaList，用于批量处理
		for (String tea : teaList) {
			// 填充Excel文件，并且返回excel文件地址
			String toFile = es
					.autoFillData(tea, "WebRoot/methods/publicMethods/",
							"WebRoot/methods/autoCreateExcel/",
							"简洁个人信息-back-pub.xlsx");
			System.out.println(toFile);
			// 生成html代码
			String htmlExcel = new POIReadExcelToHtml().main(toFile);// 生成html
			// 处理png文件，返回png文件地址 // 以防万一生成图片报错
			String pngFile = new excel2Picture().createPng(toFile);
			// 第一项为生成的excel文件地址，第二项为html代码，第三项为png文件地址
			String[] result = { toFile, htmlExcel, pngFile };
			// 加入到结果集合里
			resultList.add(result);
		}
		//输出执行时间，用以提高执行效率
		end = System.currentTimeMillis();
		System.out.println("start time:" + start + "; end time:" + end
				+ "; Run Time:" + (end - start) + "(ms)");
		// 哪个部分需要使用就直接调用resultList中对应的String[]，再获取相应的内容即可。
	}

	@Resource(name = "teacherDao")
	private TeacherDao teacherDao;

	@Ignore
	public void searchAll() {
		// DetachedCriteria dc1 = DetachedCriteria.forClass(Teacher.class);
		// dc1.add(Restrictions.eq("tea_id", "101"));
		// List<Teacher> list = teacherDao.getById("101");
		// System.out.println(list.toString());
		DetachedCriteria dc = DetachedCriteria.forClass(Teacher.class);
		dc.add(Restrictions.eq("tea_id", "101"));
		List<Teacher> list = teacherDao.getList(dc);
		for (Teacher teacher : list) {
			Set<AnnualReview> set = teacher.getAnnualReviewS();
			for (AnnualReview annualReview : set) {
				System.out.println(annualReview);
			}
			Set<TeachingEvaluation> set2 = teacher.getTeachingEvaluationS();
			for (TeachingEvaluation t : set2) {
				System.out.println(t.toString());
			}
			// System.out.println(teacher.toString());
		}
	}
}
