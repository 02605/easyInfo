package com.utilBeanS;

import java.sql.Date;

/**
 * 这个类用来封装所有的查询条件
 * 
 * @author DELL
 * @authorEmail lamadiemofly@163.com
 * @ClassName: QueryCondition
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月30日 下午6:19:19
 * 
 */
public class QueryCondition {

	// 查询类别
	private String condition;
	//时间的定义
	private String tea_workTime;//教师入职区间
	private String otherTime;//其余时间区间
	// Teacher教师表
	private String tea_id;// 职工号
	private String tea_name;// 姓名
	private String tea_gender;// 性别
	private String tea_birthday;// 出生日期
	private String tea_identityId;// 身份证号
	private String tea_nation;// 民族
	private String tea_political;// 政治面貌
	/*private String tea_workDate;// 参加工作时间
*/	private String tea_jobTitel;// 职称
	private String tea_eduBG;// 学历
	private String tea_degree;// 学位
	private String tea_dep;// 系别
	private String tea_enable;// 状态
	private String tea_role;// 角色
	private String tea_phone;// 电话

	// TeachingEvaluation教学评估表
	private Date tea_eva_year;// 学年			
	private String tea_eva_grade;// 评估成绩		

	// AnnualReview年终考核
	private Integer ann_rev_year;// 年份
	private String ann_rev_grade;// 考核结果

	// Thesis论文
	private String the_id;// 论文id
	private String the_author;// 论文作者		
	private String the_title;// 论文题目		
	private String the_periodical;// 刊物名称
	private String the_pubTime;// 出版时间	
	private String the_level;// 论文层次	

	// CompileMateria教材著作
	private String cm_editor;// 编写者
	private String cm_name;// 著作名称
	private String cm_publisher;// 出版社

	// Patent专利
	private String pat_registerNum;// 登记号
	private String pat_country;// 国别
	private String pat_name;// 题名
	private String pat_author;// 作者
	private String pat_type;// 专利类型

	// Vertical Research科研教研（纵向）
	private String ver_no;// 纵向科研编号
	private String ver_nature;// 性质
	private String ver_manager;// 项目负责人
	private String ver_personnel;// 参加人员
	private String ver_courseName;// 课题名称
	private Date ver_projectTime;// 立项时间
	private Date ver_endTime;// 结题时间
	private String ver_projectUnit;// 立项单位
	private String ver_projectLevel;// 立项级别
	private String ver_identLevel;// 鉴定级别

	// Horizontal Research横向科研
	private String hor_no;// 横向科研编号
	private String hor_manager;// 项目负责人
	private String hor_personnel;// 参加人员
	private String hor_courseName;// 课题名称
	private Date hor_projectTime;// 立项时间
	private Date hor_endTime;// 结题时间
	private String hor_cilentName;// 客户名称
	private Double hor_money;// 总经费

	// Instructed students指导学生
	private String ins_stu_teancher;// 指导教师
	private String ins_stu_stuNum;// 学生学号
	private String ins_stu_stuName;// 学生姓名
	private String ins_stu_proName;// 项目名称
	private Date ins_stu_startTime;// 开始时间（年月日）
	private Date ins_stu_endTime;// 结束时间（年月日）
	private String ins_stu_type;// 集体或个人
	private String ins_stu_reward;// 是否获奖
	private String ins_stu_rewardLevel;// 学生获奖级别

	// Practice 挂职实践
	private String pra_company;// 实践单位
	private Date pra_startTime;// 起始时间
	private Date pra_endTime;// 结束时间
	private String pra_post;// 实践职务

	// Train培训学习
	private Date tra_startTime;// 起始时间
	private Date tra_endTime;// 结束时间
	private String tra_theme;// 主题
	private String tra_result;// 培训成果

	// Reward奖励
	private String rew_level;// 奖励级别
	private Date rew_time;// 奖励时间
	private String rew_family;// 奖励类别
	private String rew_ascription;// 集体或个人
	private String rew_name           ;//奖励名称

	// Instructor当辅导员情况
	private Date ins_startTime;// 起始时间
	private Date ins_endTime;// 结束时间
	private String ins_classes;// 班级

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public String getTea_name() {
		return tea_name;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	public String getTea_gender() {
		return tea_gender;
	}

	public void setTea_gender(String tea_gender) {
		this.tea_gender = tea_gender;
	}

	public String getTea_birthday() {
		return tea_birthday;
	}

	public void setTea_birthday(String tea_birthday) {
		this.tea_birthday = tea_birthday;
	}

	public String getTea_identityId() {
		return tea_identityId;
	}

	public void setTea_identityId(String tea_identityId) {
		this.tea_identityId = tea_identityId;
	}

	public String getTea_nation() {
		return tea_nation;
	}

	public void setTea_nation(String tea_nation) {
		this.tea_nation = tea_nation;
	}

	public String getTea_political() {
		return tea_political;
	}

	public void setTea_political(String tea_political) {
		this.tea_political = tea_political;
	}

	public String getTea_jobTitel() {
		return tea_jobTitel;
	}

	public void setTea_jobTitel(String tea_jobTitel) {
		this.tea_jobTitel = tea_jobTitel;
	}

	public String getTea_eduBG() {
		return tea_eduBG;
	}

	public void setTea_eduBG(String tea_eduBG) {
		this.tea_eduBG = tea_eduBG;
	}

	public String getTea_degree() {
		return tea_degree;
	}

	public void setTea_degree(String tea_degree) {
		this.tea_degree = tea_degree;
	}

	public String getTea_dep() {
		return tea_dep;
	}

	public void setTea_dep(String tea_dep) {
		this.tea_dep = tea_dep;
	}

	public String getTea_enable() {
		return tea_enable;
	}

	public void setTea_enable(String tea_enable) {
		this.tea_enable = tea_enable;
	}

	public String getTea_role() {
		return tea_role;
	}

	public void setTea_role(String tea_role) {
		this.tea_role = tea_role;
	}

	public String getTea_phone() {
		return tea_phone;
	}

	public void setTea_phone(String tea_phone) {
		this.tea_phone = tea_phone;
	}

	public Date getTea_eva_year() {
		return tea_eva_year;
	}

	public void setTea_eva_year(Date tea_eva_year) {
		this.tea_eva_year = tea_eva_year;
	}

	public String getTea_eva_grade() {
		return tea_eva_grade;
	}

	public void setTea_eva_grade(String tea_eva_grade) {
		this.tea_eva_grade = tea_eva_grade;
	}

	public Integer getAnn_rev_year() {
		return ann_rev_year;
	}

	public void setAnn_rev_year(Integer ann_rev_year) {
		this.ann_rev_year = ann_rev_year;
	}

	public String getAnn_rev_grade() {
		return ann_rev_grade;
	}

	public void setAnn_rev_grade(String ann_rev_grade) {
		this.ann_rev_grade = ann_rev_grade;
	}

	public String getThe_id() {
		return the_id;
	}

	public void setThe_id(String the_id) {
		this.the_id = the_id;
	}

	public String getThe_author() {
		return the_author;
	}

	public void setThe_author(String the_author) {
		this.the_author = the_author;
	}

	public String getThe_title() {
		return the_title;
	}

	public void setThe_title(String the_title) {
		this.the_title = the_title;
	}

	public String getThe_periodical() {
		return the_periodical;
	}

	public void setThe_periodical(String the_periodical) {
		this.the_periodical = the_periodical;
	}


	public String getThe_pubTime() {
		return the_pubTime;
	}

	public void setThe_pubTime(String the_pubTime) {
		this.the_pubTime = the_pubTime;
	}

	public String getThe_level() {
		return the_level;
	}

	public void setThe_level(String the_level) {
		this.the_level = the_level;
	}

	public String getCm_editor() {
		return cm_editor;
	}

	public void setCm_editor(String cm_editor) {
		this.cm_editor = cm_editor;
	}

	public String getCm_name() {
		return cm_name;
	}

	public void setCm_name(String cm_name) {
		this.cm_name = cm_name;
	}

	public String getCm_publisher() {
		return cm_publisher;
	}

	public void setCm_publisher(String cm_publisher) {
		this.cm_publisher = cm_publisher;
	}

	public String getPat_registerNum() {
		return pat_registerNum;
	}

	public void setPat_registerNum(String pat_registerNum) {
		this.pat_registerNum = pat_registerNum;
	}

	public String getPat_country() {
		return pat_country;
	}

	public void setPat_country(String pat_country) {
		this.pat_country = pat_country;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getPat_author() {
		return pat_author;
	}

	public void setPat_author(String pat_author) {
		this.pat_author = pat_author;
	}

	public String getPat_type() {
		return pat_type;
	}

	public void setPat_type(String pat_type) {
		this.pat_type = pat_type;
	}

	public String getVer_no() {
		return ver_no;
	}

	public void setVer_no(String ver_no) {
		this.ver_no = ver_no;
	}

	public String getVer_nature() {
		return ver_nature;
	}

	public void setVer_nature(String ver_nature) {
		this.ver_nature = ver_nature;
	}

	public String getVer_manager() {
		return ver_manager;
	}

	public void setVer_manager(String ver_manager) {
		this.ver_manager = ver_manager;
	}

	public String getVer_personnel() {
		return ver_personnel;
	}

	public void setVer_personnel(String ver_personnel) {
		this.ver_personnel = ver_personnel;
	}

	public String getVer_courseName() {
		return ver_courseName;
	}

	public void setVer_courseName(String ver_courseName) {
		this.ver_courseName = ver_courseName;
	}

	public Date getVer_projectTime() {
		return ver_projectTime;
	}

	public void setVer_projectTime(Date ver_projectTime) {
		this.ver_projectTime = ver_projectTime;
	}

	public Date getVer_endTime() {
		return ver_endTime;
	}

	public void setVer_endTime(Date ver_endTime) {
		this.ver_endTime = ver_endTime;
	}

	public String getVer_projectUnit() {
		return ver_projectUnit;
	}

	public void setVer_projectUnit(String ver_projectUnit) {
		this.ver_projectUnit = ver_projectUnit;
	}

	public String getVer_projectLevel() {
		return ver_projectLevel;
	}

	public void setVer_projectLevel(String ver_projectLevel) {
		this.ver_projectLevel = ver_projectLevel;
	}

	public String getVer_identLevel() {
		return ver_identLevel;
	}

	public void setVer_identLevel(String ver_identLevel) {
		this.ver_identLevel = ver_identLevel;
	}

	public String getHor_no() {
		return hor_no;
	}

	public void setHor_no(String hor_no) {
		this.hor_no = hor_no;
	}

	public String getHor_manager() {
		return hor_manager;
	}

	public void setHor_manager(String hor_manager) {
		this.hor_manager = hor_manager;
	}

	public String getHor_personnel() {
		return hor_personnel;
	}

	public void setHor_personnel(String hor_personnel) {
		this.hor_personnel = hor_personnel;
	}

	public String getHor_courseName() {
		return hor_courseName;
	}

	public void setHor_courseName(String hor_courseName) {
		this.hor_courseName = hor_courseName;
	}

	public Date getHor_projectTime() {
		return hor_projectTime;
	}

	public void setHor_projectTime(Date hor_projectTime) {
		this.hor_projectTime = hor_projectTime;
	}

	public Date getHor_endTime() {
		return hor_endTime;
	}

	public void setHor_endTime(Date hor_endTime) {
		this.hor_endTime = hor_endTime;
	}

	public String getHor_cilentName() {
		return hor_cilentName;
	}

	public void setHor_cilentName(String hor_cilentName) {
		this.hor_cilentName = hor_cilentName;
	}

	public Double getHor_money() {
		return hor_money;
	}

	public void setHor_money(Double hor_money) {
		this.hor_money = hor_money;
	}

	public String getIns_stu_teancher() {
		return ins_stu_teancher;
	}

	public void setIns_stu_teancher(String ins_stu_teancher) {
		this.ins_stu_teancher = ins_stu_teancher;
	}

	public String getIns_stu_stuNum() {
		return ins_stu_stuNum;
	}

	public void setIns_stu_stuNum(String ins_stu_stuNum) {
		this.ins_stu_stuNum = ins_stu_stuNum;
	}

	public String getIns_stu_stuName() {
		return ins_stu_stuName;
	}

	public void setIns_stu_stuName(String ins_stu_stuName) {
		this.ins_stu_stuName = ins_stu_stuName;
	}

	public String getIns_stu_proName() {
		return ins_stu_proName;
	}

	public void setIns_stu_proName(String ins_stu_proName) {
		this.ins_stu_proName = ins_stu_proName;
	}

	public Date getIns_stu_startTime() {
		return ins_stu_startTime;
	}

	public void setIns_stu_startTime(Date ins_stu_startTime) {
		this.ins_stu_startTime = ins_stu_startTime;
	}

	public Date getIns_stu_endTime() {
		return ins_stu_endTime;
	}

	public void setIns_stu_endTime(Date ins_stu_endTime) {
		this.ins_stu_endTime = ins_stu_endTime;
	}

	public String getIns_stu_type() {
		return ins_stu_type;
	}

	public void setIns_stu_type(String ins_stu_type) {
		this.ins_stu_type = ins_stu_type;
	}

	public String getIns_stu_reward() {
		return ins_stu_reward;
	}

	public void setIns_stu_reward(String ins_stu_reward) {
		this.ins_stu_reward = ins_stu_reward;
	}

	public String getIns_stu_rewardLevel() {
		return ins_stu_rewardLevel;
	}

	public void setIns_stu_rewardLevel(String ins_stu_rewardLevel) {
		this.ins_stu_rewardLevel = ins_stu_rewardLevel;
	}

	public String getPra_company() {
		return pra_company;
	}

	public void setPra_company(String pra_company) {
		this.pra_company = pra_company;
	}

	public Date getPra_startTime() {
		return pra_startTime;
	}

	public void setPra_startTime(Date pra_startTime) {
		this.pra_startTime = pra_startTime;
	}

	public Date getPra_endTime() {
		return pra_endTime;
	}

	public void setPra_endTime(Date pra_endTime) {
		this.pra_endTime = pra_endTime;
	}

	public String getPra_post() {
		return pra_post;
	}

	public void setPra_post(String pra_post) {
		this.pra_post = pra_post;
	}

	public Date getTra_startTime() {
		return tra_startTime;
	}

	public void setTra_startTime(Date tra_startTime) {
		this.tra_startTime = tra_startTime;
	}

	public Date getTra_endTime() {
		return tra_endTime;
	}

	public void setTra_endTime(Date tra_endTime) {
		this.tra_endTime = tra_endTime;
	}

	public String getTra_theme() {
		return tra_theme;
	}

	public void setTra_theme(String tra_theme) {
		this.tra_theme = tra_theme;
	}

	public String getTra_result() {
		return tra_result;
	}

	public void setTra_result(String tra_result) {
		this.tra_result = tra_result;
	}

	public String getRew_level() {
		return rew_level;
	}

	public void setRew_level(String rew_level) {
		this.rew_level = rew_level;
	}

	public Date getRew_time() {
		return rew_time;
	}

	public void setRew_time(Date rew_time) {
		this.rew_time = rew_time;
	}

	public String getRew_family() {
		return rew_family;
	}

	public void setRew_family(String rew_family) {
		this.rew_family = rew_family;
	}

	public String getRew_ascription() {
		return rew_ascription;
	}

	public void setRew_ascription(String rew_ascription) {
		this.rew_ascription = rew_ascription;
	}

	public Date getIns_startTime() {
		return ins_startTime;
	}

	public void setIns_startTime(Date ins_startTime) {
		this.ins_startTime = ins_startTime;
	}

	public Date getIns_endTime() {
		return ins_endTime;
	}

	public void setIns_endTime(Date ins_endTime) {
		this.ins_endTime = ins_endTime;
	}

	public String getIns_classes() {
		return ins_classes;
	}

	public void setIns_classes(String ins_classes) {
		this.ins_classes = ins_classes;
	}

	@Override
	public String toString() {
		return "QueryCondition [condition=" + condition + ", tea_id=" + tea_id
				+ ", tea_name=" + tea_name + "]";
	}

	public String getTea_workTime() {
		return tea_workTime;
	}

	public void setTea_workTime(String tea_workTime) {
		this.tea_workTime = tea_workTime;
	}

	public String getOtherTime() {
		return otherTime;
	}

	public void setOtherTime(String otherTime) {
		this.otherTime = otherTime;
	}

	public String getRew_name() {
		return rew_name;
	}

	public void setRew_name(String rew_name) {
		this.rew_name = rew_name;
	}

	
}
