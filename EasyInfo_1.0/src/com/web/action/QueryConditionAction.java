package com.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.domain.AnnualReview;
import com.domain.CompileMateria;
import com.domain.HorizontalResearch;
import com.domain.InstructedStudents;
import com.domain.Instructor;
import com.domain.Patent;
import com.domain.Practice;
import com.domain.Reward;
import com.domain.Teacher;
import com.domain.TeachingEvaluation;
import com.domain.Thesis;
import com.domain.Train;
import com.domain.VerticalResearch;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.AnnualReviewService;
import com.service.CompileMateriaService;
import com.service.HorizontalResearchService;
import com.service.InstructedStudentsService;
import com.service.InstructorService;
import com.service.PatentService;
import com.service.PracticeService;
import com.service.RewardService;
import com.service.TeacherService;
import com.service.TeachingEvaluationService;
import com.service.ThesisService;
import com.service.TrainService;
import com.service.VerticalResearchService;
import com.utilBeanS.QueryCondition;
import com.utils.PageBean;

@SuppressWarnings("all")
public class QueryConditionAction extends ActionSupport implements
		ModelDriven<QueryCondition> {

	private QueryCondition queryCondition = new QueryCondition();
	private TeacherService teacherService;// 教师service
	private ThesisService thesisService;// 论文service
	private PatentService patentService;// 专利service
	private RewardService rewardService;// 奖励service
	private CompileMateriaService compileMateriaService;// 著作service
	private TeachingEvaluationService teachingEvaluationService;// 教学评估service
	private VerticalResearchService verticalResearchService;// 纵向研究
	private HorizontalResearchService horizontalResearchService;// 横向科研service
	private InstructedStudentsService instructedStudentsService;// 指导学生service
	private PracticeService practiceService;// 挂职实践service
	private TrainService trainService;// 培训学习service
	private AnnualReviewService annualReviewService;// 年终考核service
	private InstructorService instructorService;// 辅导员service
	private Integer currentPage;
	private Integer pageSize;

	private String time2;

	public String list() throws Exception {

		PageBean pb = null;
		DetachedCriteria dc = null;

		// 查询教师基本信息
		if (queryCondition.getCondition().equalsIgnoreCase("0")) {
			dc = DetachedCriteria.forClass(Teacher.class);
			// 封装离线查询对象，获取结果
			List list = getAfterSelectTeaList();
			if (list != null) {
				dc.add(Restrictions.in("tea_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = teacherService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 论文信息
		if (queryCondition.getCondition().equalsIgnoreCase("b")) {
			dc = DetachedCriteria.forClass(Thesis.class);
			List list = getAfterSelectThesis();
			if (list != null) {
				dc.add(Restrictions.in("the_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = thesisService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 专利信息
		if (queryCondition.getCondition().equalsIgnoreCase("c")) {
			dc = DetachedCriteria.forClass(Patent.class);
			List list = getAfterSelectPatent();
			if (list != null) {
				dc.add(Restrictions.in("pat_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = patentService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 奖励信息
		if (queryCondition.getCondition().equalsIgnoreCase("d")) {
			dc = DetachedCriteria.forClass(Reward.class);
			List list = getAfterSelectReward();
			if (list != null) {
				dc.add(Restrictions.in("rew_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = rewardService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 著作出版
		if (queryCondition.getCondition().equalsIgnoreCase("e")) {
			dc = DetachedCriteria.forClass(CompileMateria.class);
			List list = getAfterSelectCompileMateria();
			if (list != null) {
				dc.add(Restrictions.in("cm_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = compileMateriaService.getPageBean(dc, currentPage,
						pageSize);
			}
		}
		// 教学评估
		if (queryCondition.getCondition().equalsIgnoreCase("f")) {
			dc = DetachedCriteria.forClass(TeachingEvaluation.class);
			List list = getAfterSelectTeachingEvaluation();
			if (list != null) {
				dc.add(Restrictions.in("tea_eva_id", list));
				dc.addOrder(Order.asc("tea_eva_year"));
				// 1 调用Service查询分页数据(PageBean)
				pb = teachingEvaluationService.getPageBean(dc, currentPage,
						pageSize);
			}
		}
		// 纵向研究
		if (queryCondition.getCondition().equalsIgnoreCase("g")) {
			dc = DetachedCriteria.forClass(VerticalResearch.class);
			List list = getAfterSelectVerticalResearch();
			if (list != null) {
				dc.add(Restrictions.in("ver_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = verticalResearchService.getPageBean(dc, currentPage,
						pageSize);
			}
		}
		// 横向科研
		if (queryCondition.getCondition().equalsIgnoreCase("h")) {
			dc = DetachedCriteria.forClass(HorizontalResearch.class);
			List list = getAfterSelectHorizontalResearch();
			if (list != null) {
				dc.add(Restrictions.in("hor_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = horizontalResearchService.getPageBean(dc, currentPage,
						pageSize);
			}
		}
		// 指导学生
		if (queryCondition.getCondition().equalsIgnoreCase("i")) {
			dc = DetachedCriteria.forClass(InstructedStudents.class);
			List list = getAfterSelectInstructedStudents();
			if (list != null) {
				dc.add(Restrictions.in("ins_stu_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = instructedStudentsService.getPageBean(dc, currentPage,
						pageSize);
			}
		}
		// 挂职实践
		if (queryCondition.getCondition().equalsIgnoreCase("j")) {
			dc = DetachedCriteria.forClass(Practice.class);
			List list = getAfterSelectPractice();
			if (list != null) {
				dc.add(Restrictions.in("pra_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = practiceService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 培训学习
		if (queryCondition.getCondition().equalsIgnoreCase("k")) {
			dc = DetachedCriteria.forClass(Train.class);
			List list = getAfterSelectTrain();
			if (list != null) {
				dc.add(Restrictions.in("tra_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = trainService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 年终考核
		if (queryCondition.getCondition().equalsIgnoreCase("l")) {
			dc = DetachedCriteria.forClass(AnnualReview.class);
			List list = getAfterSelectAnnualReview();
			if (list != null) {
				dc.add(Restrictions.in("ann_rev_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = annualReviewService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 辅导员情况
		if (queryCondition.getCondition().equalsIgnoreCase("m")) {
			dc = DetachedCriteria.forClass(Instructor.class);
			List list = getAfterSelectInstructor();
			if (list != null) {
				dc.add(Restrictions.in("ins_id", list));
				// 1 调用Service查询分页数据(PageBean)
				pb = instructorService.getPageBean(dc, currentPage, pageSize);
			}
		}
		// 2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	/**
	 * 
	 * @Title: getAfterSelectTeaList
	 * @Description: TODO(筛选teacher的信息)
	 * @param @return 设定文件
	 * @return List 返回tea_id集合
	 * @throws
	 */
	private List getAfterSelectTeaList() {
		DetachedCriteria dc1 = DetachedCriteria.forClass(Teacher.class);

		if (StringUtils.isNotBlank(queryCondition.getTea_id())) {
			dc1.add(Restrictions.like("tea_id",
					"%" + queryCondition.getTea_id() + "%"));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_workTime())) {
			String[] strings = queryCondition.getTea_workTime().split("to");
			String begin = strings[0].trim();
			String end = strings[1].trim();
			/*
			 * String begin = "2010-10-5"; String end = "2020-10-5";
			 */
			java.sql.Date beginDate = java.sql.Date.valueOf(begin);
			java.sql.Date endDate = java.sql.Date.valueOf(end);
			dc1.add(Restrictions.between("tea_workDate", beginDate, endDate));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_name())) {
			dc1.add(Restrictions.like("tea_name",
					"%" + queryCondition.getTea_name() + "%"));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_gender())) {
			dc1.createAlias("tea_gender", "baseDict1");
			dc1.add(Restrictions.eq("baseDict1.dict_id",
					queryCondition.getTea_gender()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_nation())) {
			dc1.createAlias("tea_nation", "baseDict2");
			dc1.add(Restrictions.eq("baseDict2.dict_id",
					queryCondition.getTea_nation()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_political())) {
			dc1.createAlias("tea_political", "baseDict3");
			dc1.add(Restrictions.eq("baseDict3.dict_id",
					queryCondition.getTea_political()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_jobTitel())) {
			dc1.createAlias("tea_jobTitel", "baseDict4");
			dc1.add(Restrictions.eq("baseDict4.dict_id",
					queryCondition.getTea_jobTitel()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_eduBG())) {
			dc1.createAlias("tea_eduBG", "baseDict5");
			dc1.add(Restrictions.eq("baseDict5.dict_id",
					queryCondition.getTea_eduBG()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_degree())) {
			dc1.createAlias("tea_degree", "baseDict6");
			dc1.add(Restrictions.eq("baseDict6.dict_id",
					queryCondition.getTea_degree()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_dep())) {
			dc1.createAlias("tea_dep", "baseDict7");
			dc1.add(Restrictions.eq("baseDict7.dict_id",
					queryCondition.getTea_dep()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_enable())) {
			dc1.createAlias("tea_enable", "baseDict8");
			dc1.add(Restrictions.eq("baseDict8.dict_id",
					queryCondition.getTea_enable()));
		}
		if (StringUtils.isNotBlank(queryCondition.getTea_role())) {
			dc1.createAlias("tea_role", "baseDict9");
			dc1.add(Restrictions.eq("baseDict9.dict_id",
					queryCondition.getTea_role()));
		}
		// 设置只查询tea_id列
		dc1.setProjection(Projections.distinct(Projections.property("tea_id")));
		List list = teacherService.getAnyTypeList(dc1);
		dc1.setProjection(null);
		return list;
	}

	/**
	 * 
	 * @Title: getAfterSelectThesis
	 * @Description: TODO(论文查询)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectThesis() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Thesis.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.createAlias("the_level", "baseDict");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 论文发布时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("the_pubTime", beginDate, endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_level())) {
				// 论文层次
				dc2.add(Restrictions.eq("baseDict.dict_id",
						queryCondition.getThe_level()));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_author())) {
				// 论文作者
				dc2.add(Restrictions.or(
						Restrictions.like("the_firstAuthor", "%"
								+ queryCondition.getThe_author() + "%"),
						Restrictions.like("the_otherAuthor", "%"
								+ queryCondition.getThe_author() + "%")));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_title())) {
				// 论文题目
				dc2.add(Restrictions.like("the_title",
						"%" + queryCondition.getThe_title() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getThe_periodical())) {
				// 发表刊物名称
				dc2.add(Restrictions.like("the_periodical", "%"
						+ queryCondition.getThe_periodical() + "%"));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("the_id")));
			list2 = thesisService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 
	 * @Title: getAfterSelectPatent
	 * @Description: TODO(专利信息筛选)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectPatent() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Patent.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.createAlias("pat_type", "baseDict");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 专利获取时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("pat_pubTime", beginDate, endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getPat_type())) {
				// 专利类型
				dc2.add(Restrictions.eq("baseDict.dict_id",
						queryCondition.getPat_type()));
			}
			if (StringUtils.isNotBlank(queryCondition.getPat_author())) {
				// 专利作者
				dc2.add(Restrictions.like("pat_author",
						"%" + queryCondition.getPat_author() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getPat_registerNum())) {
				// 专利登记号
				dc2.add(Restrictions.like("pat_registerNum", "%"
						+ queryCondition.getPat_registerNum() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getPat_name())) {
				// 专利名称
				dc2.add(Restrictions.like("pat_name",
						"%" + queryCondition.getPat_name() + "%"));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("pat_id")));
			list2 = patentService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 
	 * @Title: getAfterSelectReward
	 * @Description: TODO(筛选奖励信息)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectReward() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Reward.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.createAlias("rew_level", "baseDict1");
			dc2.createAlias("rew_family", "baseDict2");
			dc2.createAlias("rew_ascription", "baseDict3");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 奖励获取时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("rew_time", beginDate, endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getRew_level())) {
				// 奖励级别rew_level
				dc2.add(Restrictions.eq("baseDict1.dict_id",
						queryCondition.getRew_level()));
			}
			if (StringUtils.isNotBlank(queryCondition.getRew_family())) {
				// 奖励类别rew_family
				dc2.add(Restrictions.eq("baseDict2.dict_id",
						queryCondition.getRew_family()));
			}
			if (StringUtils.isNotBlank(queryCondition.getRew_ascription())) {
				// 奖励所属rew_ascription
				dc2.add(Restrictions.like("baseDict3.dict_id",
						queryCondition.getRew_ascription()));
			}
			if (StringUtils.isNotBlank(queryCondition.getRew_name())) {
				// 奖励名称
				dc2.add(Restrictions.like("rew_name",
						"%" + queryCondition.getRew_name() + "%"));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("rew_id")));
			list2 = rewardService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 
	 * @Title: getAfterSelectCompileMateria
	 * @Description: TODO(筛选著作信息)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectCompileMateria() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(CompileMateria.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 出版时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("cm_pubTime", beginDate, endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getCm_editor())) {
				// 著作编写人员
				dc2.add(Restrictions.or(
						Restrictions.like("cm_chiefEditor", "%"
								+ queryCondition.getCm_editor() + "%"),
						Restrictions.like("cm_subeditor",
								"%" + queryCondition.getCm_editor() + "%")));
			}
			if (StringUtils.isNotBlank(queryCondition.getCm_name())) {
				// 著作书名
				dc2.add(Restrictions.like("cm_name",
						"%" + queryCondition.getCm_name() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getCm_publisher())) {
				// 出版社
				dc2.add(Restrictions.like("cm_publisher",
						"%" + queryCondition.getCm_publisher() + "%"));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("cm_id")));
			list2 = compileMateriaService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 
	 * @Title: getAfterSelectTeachingEvaluation
	 * @Description: TODO(教学评估筛选)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectTeachingEvaluation() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(TeachingEvaluation.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.createAlias("tea_eva_grade", "baseDict");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 评估区间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions
						.between("tea_eva_year", beginDate, endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getTea_eva_grade())) {
				// 评估成绩
				dc2.add(Restrictions.eq("baseDict.dict_id",
						queryCondition.getTea_eva_grade()));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("tea_eva_id")));
			list2 = teachingEvaluationService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 纵向研究
	 * 
	 * @Title: getAfterSelectVerticalResearch
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectVerticalResearch() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(VerticalResearch.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.createAlias("ver_nature", "baseDict1");
			dc2.createAlias("ver_projectLevel", "baseDict2");

			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 立项时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("ver_projectTime", beginDate,
						endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_nature())) {
				// 研究性质
				dc2.add(Restrictions.eq("baseDict1.dict_id",
						queryCondition.getVer_nature()));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_projectLevel())) {
				// 立项级别
				dc2.add(Restrictions.eq("baseDict2.dict_id",
						queryCondition.getVer_projectLevel()));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_identLevel())) {
				// 鉴定级别
				dc2.createAlias("ver_identLevel", "baseDict3");
				dc2.add(Restrictions.eq("baseDict3.dict_id",
						queryCondition.getVer_identLevel()));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_no())) {
				// 研究编号
				dc2.add(Restrictions.like("ver_no",
						"%" + queryCondition.getVer_no() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_manager())) {
				// 项目负责人
				dc2.add(Restrictions.like("ver_manager",
						"%" + queryCondition.getVer_manager() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_personnel())) {
				// 项目参加人员
				dc2.add(Restrictions.like("ver_personnel",
						"%" + queryCondition.getVer_personnel() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getVer_courseName())) {
				// 项目名称
				dc2.add(Restrictions.like("ver_courseName", "%"
						+ queryCondition.getVer_courseName() + "%"));
			}
			// 设置只查询ver_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("ver_id")));
			list2 = verticalResearchService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 筛选横向科研
	 * 
	 * @Title: getAfterSelectHorizontalResearch
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectHorizontalResearch() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(HorizontalResearch.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 立项时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("hor_projectTime", beginDate,
						endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getHor_no())) {
				// 研究编号
				dc2.add(Restrictions.eq("hor_no", queryCondition.getHor_no()));
			}
			if (StringUtils.isNotBlank(queryCondition.getHor_manager())) {
				// 项目人员
				dc2.add(Restrictions.or(
						Restrictions.like("hor_manager",
								"%" + queryCondition.getHor_manager() + "%"),
						Restrictions.like("hor_personnel",
								"%" + queryCondition.getHor_manager() + "%")));
			}
			if (StringUtils.isNotBlank(queryCondition.getHor_courseName())) {
				// 课题名称
				dc2.add(Restrictions.like("hor_courseName", "%"
						+ queryCondition.getHor_courseName() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getHor_cilentName())) {
				// 客户名称
				dc2.add(Restrictions.like("hor_cilentName", "%"
						+ queryCondition.getHor_cilentName() + "%"));
			}
			// 设置只查询ver_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("hor_id")));
			list2 = horizontalResearchService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 指导学生
	 * 
	 * @Title: getAfterSelectInstructedStudents
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectInstructedStudents() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(InstructedStudents.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 项目开始时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("ins_stu_startTime", beginDate,
						endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_stuName())) {
				// 学生姓名
				dc2.add(Restrictions.like("ins_stu_name",
						"%" + queryCondition.getIns_stu_stuName() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_stuNum())) {
				// 学号
				dc2.add(Restrictions.like("ins_stu_num",
						"%" + queryCondition.getIns_stu_stuNum() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_teancher())) {
				// 指导教师姓名
				dc2.add(Restrictions.or(
						Restrictions.like("ins_stu_teancherOne", "%"
								+ queryCondition.getIns_stu_teancher() + "%"),
						Restrictions.like("ins_stu_teacherTwo", "%"
								+ queryCondition.getIns_stu_teancher() + "%")));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_proName())) {
				// 项目名称
				dc2.add(Restrictions.like("ins_stu_proName", "%"
						+ queryCondition.getIns_stu_proName() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_rewardLevel())) {
				// 学生获奖级别
				dc2.createAlias("ins_stu_rewardLevel", "baseDict3");// 学生获奖级别
				dc2.add(Restrictions.eq("baseDict3.dict_id",
						queryCondition.getIns_stu_rewardLevel()));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_reward())) {
				// 是否获奖
				dc2.createAlias("ins_stu_reward", "baseDict2");// 是否获奖
				dc2.add(Restrictions.eq("baseDict2.dict_id",
						queryCondition.getIns_stu_reward()));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_stu_type())) {
				// 队伍类型
				dc2.createAlias("ins_stu_type", "baseDict1");// 集体或个人
				dc2.add(Restrictions.eq("baseDict1.dict_id",
						queryCondition.getIns_stu_type()));
			}
			// 设置只查询the_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("ins_stu_id")));
			list2 = instructedStudentsService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	// 挂职实践
	private List getAfterSelectPractice() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Practice.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 实践开始时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("pra_startTime", beginDate,
						endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getPra_company())) {
				// 实践单位
				dc2.add(Restrictions.like("pra_company",
						"%" + queryCondition.getPra_company() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getPra_post())) {
				// 实践职位
				dc2.add(Restrictions.like("pra_post",
						"%" + queryCondition.getPra_post() + "%"));
			}
			// 设置只查询pra_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("pra_id")));
			list2 = practiceService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 培训学习
	 * 
	 * @Title: getAfterSelectTrain
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectTrain() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Train.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 学习开始时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("tra_startTime", beginDate,
						endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getTra_theme())) {
				// 学习主题
				dc2.add(Restrictions.like("tra_theme",
						"%" + queryCondition.getTra_theme() + "%"));
			}
			if (StringUtils.isNotBlank(queryCondition.getTra_result())) {
				// 培训成功
				dc2.createAlias("tra_result", "baseDict");
				dc2.add(Restrictions.eq("baseDict.dict_id",
						queryCondition.getTra_result()));
			}
			// 设置只查询tra_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("tra_id")));
			list2 = practiceService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 年终考核
	 * 
	 * @Title: getAfterSelectAnnualReview
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectAnnualReview() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(AnnualReview.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 考核年份
				String[] strings = queryCondition.getOtherTime().split("to");
				String year = strings[0].trim().substring(0, 4);
				queryCondition.setOtherTime(year);
				Integer yearSql = Integer.valueOf(year);
				dc2.add(Restrictions.eq("ann_rev_year", yearSql));
			}
			if (StringUtils.isNotBlank(queryCondition.getAnn_rev_grade())) {
				// 考核结果
				dc2.createAlias("ann_rev_grade", "baseDict");
				dc2.add(Restrictions.eq("baseDict.dict_id",
						queryCondition.getAnn_rev_grade()));
			}
			// 设置只查询tra_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("ann_rev_id")));
			list2 = annualReviewService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	/**
	 * 辅导员情况
	 * 
	 * @Title: getAfterSelectInstructor
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	private List getAfterSelectInstructor() {
		// 封装离线查询对象，获取teacher_tea_id结果
		List list = getAfterSelectTeaList();
		List list2 = null;
		if (list != null) {
			DetachedCriteria dc2 = DetachedCriteria
					.forClass(Instructor.class);
			// 建立引用
			dc2.createAlias("tea_id", "teacher");
			dc2.add(Restrictions.in("teacher.tea_id", list));
			if (StringUtils.isNotBlank(queryCondition.getOtherTime())) {
				// 开始辅导时间
				String[] strings = queryCondition.getOtherTime().split("to");
				String begin = strings[0].trim();
				String end = strings[1].trim();
				java.sql.Date beginDate = java.sql.Date.valueOf(begin);
				java.sql.Date endDate = java.sql.Date.valueOf(end);
				dc2.add(Restrictions.between("ins_startTime", beginDate,
						endDate));
			}
			if (StringUtils.isNotBlank(queryCondition.getIns_classes())) {
				// 辅导班级
				dc2.add(Restrictions.like("ins_classes",
						"%"+queryCondition.getIns_classes()+"%"));
			}
			// 设置只查询tra_id列
			dc2.setProjection(Projections.distinct(Projections
					.property("ins_id")));
			list2 = instructorService.getAnyTypeList(dc2);
			dc2.setProjection(null);
		}
		return list2;
	}

	@Override
	public QueryCondition getModel() {
		return queryCondition;
	}

	public QueryCondition getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(QueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public void setThesisService(ThesisService thesisService) {
		this.thesisService = thesisService;
	}

	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}

	public void setRewardService(RewardService rewardService) {
		this.rewardService = rewardService;
	}

	public void setCompileMateriaService(
			CompileMateriaService compileMateriaService) {
		this.compileMateriaService = compileMateriaService;
	}

	public void setTeachingEvaluationService(
			TeachingEvaluationService teachingEvaluationService) {
		this.teachingEvaluationService = teachingEvaluationService;
	}

	public void setVerticalResearchService(
			VerticalResearchService verticalResearchService) {
		this.verticalResearchService = verticalResearchService;
	}

	public void setHorizontalResearchService(
			HorizontalResearchService horizontalResearchService) {
		this.horizontalResearchService = horizontalResearchService;
	}

	public void setInstructedStudentsService(
			InstructedStudentsService instructedStudentsService) {
		this.instructedStudentsService = instructedStudentsService;
	}

	public void setTrainService(TrainService trainService) {
		this.trainService = trainService;
	}

	public void setAnnualReviewService(AnnualReviewService annualReviewService) {
		this.annualReviewService = annualReviewService;
	}

	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	public void setPracticeService(PracticeService practiceService) {
		this.practiceService = practiceService;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

}
