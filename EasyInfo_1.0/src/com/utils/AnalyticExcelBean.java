package com.utils;

import java.util.ArrayList;

public class AnalyticExcelBean {

	ArrayList<String[]> list = new ArrayList<String[]>();

	public AnalyticExcelBean() {
		// 基础信息Teacher
		list.add(new String[] { "tea_id", "职工号", "id", "ID", "编号", "教师编号",
				"教师ID", "教师id" });
		list.add(new String[] { "tea_name", "姓名", "Name", "教师姓名", "教师Name",
				"教师name" });
		list.add(new String[] { "tea_gender", "性别", "gender", "教师性别" });
		list.add(new String[] { "tea_birthday", "出生日期", "Age" ,"出生年月","生日"});
		list.add(new String[] { "tea_identityId", "身份证号", "identityId", "身份证",
				"身份证件号"});
		list.add(new String[] { "tea_nation", "民族", "nation"});
		list.add(new String[] { "tea_political", "政治面貌", "political" });
		list.add(new String[] { "tea_workDate", "参加工作时间", "workDate"  });
		list.add(new String[] { "tea_jobTitel", "职称", "jobTitle","职位","所在职位" });
		list.add(new String[] { "tea_eduBG", "学历", "eduBG","教育经历"});
		list.add(new String[] { "tea_degree", "学位", "degree"});
		list.add(new String[] { "tea_home", "家庭住址", "地址", "家庭地址", "居住地址",
				"居住所在地","现居住地址"});
		list.add(new String[] { "tea_phone", "手机号", "联系电话", "电话", "手机", "号码",
				"手机号码" });
		list.add(new String[] { "tea_qq", "qq", "QQ", "qq号", "QQ号", "QQ账号"});
		list.add(new String[] { "tea_weChat", "微信", "微信号","微信账号" });
		list.add(new String[] { "tea_dep", "系别","所在系别","任教系别" });
		list.add(new String[] { "tea_enable", "状态","department" });
		list.add(new String[] { "tea_email", "邮箱", "邮件地址", "邮件", "电子邮箱","email" });
		list.add(new String[] { "tea_role", "角色","role"});
		list.add(new String[] { "tea_img", "证件照","照片" });
		list.add(new String[] { "admin_password", "管理员密码" });// 测试数组
		// 教学评估TeachingEvaluation
		list.add(new String[] { "tea_eva_year", "学年", "评估学年", "评估年份" ,"评估日期"});
		list.add(new String[] { "tea_eva_grade", "评估成绩", "教学评估成绩","教学质量评估成绩",
				"教学质量评估"});
		// 年终考核AnnualReview
		list.add(new String[] { "ann_rev_year", "考核年份","考核日期","考核年月" });
		list.add(new String[] { "ann_rev_grade", "考核结果","年终考核结果"});
		// 论文Thesis
		list.add(new String[] { "the_id", "论文id","论文编号" });
		list.add(new String[] { "the_rank", "论文排名","论文所在排名","论文名次"});
		list.add(new String[] { "the_firstAuthor", "第一作者", "论文第一作者","论文主要作者"});
		list.add(new String[] { "the_otherAuthor", "其他作者", "论文其他作者" });
		list.add(new String[] { "the_title", "论文题目", "论文标题"});
		list.add(new String[] { "the_periodical", "刊物名称", "刊登于" });
		list.add(new String[] { "the_pubTime", "出版时间", "论文出版时间","出版日期" });
		list.add(new String[] { "the_reelNum", "卷号", "论文卷号" });
		list.add(new String[] { "the_issue", "期号", "论文期号" });
		list.add(new String[] { "the_startNum", "起始页码", "论文起始页码" });
		list.add(new String[] { "the_endNum", "终止页码", "论文终止页码" });
		list.add(new String[] { "the_wordNum", "字数", "论文字数" });
		list.add(new String[] { "the_level", "论文层次", "层次" });
		list.add(new String[] { "the_scan", "论文扫描件" });
		list.add(new String[] { "the_merge", "论文综合" });
		// 教材著作CompileMateria
		list.add(new String[] { "cm_id", "教材著作id" ,"教材著作编号"});
		list.add(new String[] { "cm_rank", "著作排名", "教材著作排名" });
		list.add(new String[] { "cm_chiefEditor", "主编", "教材主编", "著作主编" });
		list.add(new String[] { "cm_subeditor", "副主编", "教材副主编", "著作副主编" });
		list.add(new String[] { "cm_name", "著作名称", "教材名称" });
		list.add(new String[] { "cm_edition", "版次", "教材版次", "著作版次" });
		list.add(new String[] { "cm_location", "出版地", "著作出版地", "出版社", "著作出版社",
				"教材出版社" });
		list.add(new String[] { "cm_publisher", "出版者", "著作出版者", "教材出版者" ,"出版人","教材出版人"});
		list.add(new String[] { "cm_pubTime", "出版时间", "著作出版时间", "教材出版时间" ,"出版日期","教材出版日期"});
		list.add(new String[] { "cm_pageNum", "页码", "著作页码" ,"页码总数","教材页码"});
		list.add(new String[] { "cm_bearNum", "承担字数" });
		list.add(new String[] { "cm_scan", "教材著作扫描件" });
		list.add(new String[] { "cm_merge", "教材著作综合" });
		// 专利Patent
		list.add(new String[] { "pat_id", "专利id","专利编号"});
		list.add(new String[] { "pat_rank", "专利排名","专利名次"});
		list.add(new String[] { "pat_type", "专利类型" });
		list.add(new String[] { "pat_author", "作者", "专利作者" ,"专利申请人","专利权人"});
		list.add(new String[] { "pat_name", "题名" ,"专利名","专利名称"});
		list.add(new String[] { "pat_country", "国别","国籍" });
		list.add(new String[] { "pat_registerNum", "登记号" ,"登记号码"});
		list.add(new String[] { "pat_pubTime", "发布日期","发布年份","发布时间"});
		list.add(new String[] { "pat_scan", "专利扫描件"});
		list.add(new String[] { "pat_merge", "专利综合"});
		// 纵向科研Vertical Research
		list.add(new String[] { "ver_id", "纵向科研id" });
		list.add(new String[] { "ver_no", "纵向科研编号" });
		list.add(new String[] { "ver_rank", "纵向科研排名" });
		list.add(new String[] { "ver_nature", "纵向科研性质" });
		list.add(new String[] { "ver_manager", "纵向科研项目负责人","项目负责人" });
		list.add(new String[] { "ver_personnel", "纵向科研参加人员" ,"参加人员"});
		list.add(new String[] { "ver_courseName", "纵向科研课题名称" ,"课题名称"});
		list.add(new String[] { "ver_introduction", "纵向科研简单介绍","纵向科研简介" });
		list.add(new String[] { "ver_projectTime", "纵向科研立项时间","立项时间" });
		list.add(new String[] { "ver_endTime", "纵向科研结题时间" ,"结题时间"});
		list.add(new String[] { "ver_projectUnit", "立项单位" });
		list.add(new String[] { "ver_projectLevel", "立项级别" });
		list.add(new String[] { "ver_identTime", "鉴定时间" });
		list.add(new String[] { "ver_identLevel", "鉴定级别" });
		list.add(new String[] { "ver_identCon", "鉴定结论" });
		list.add(new String[] { "ver_scan", "纵向科研扫描件" });
		// 横向科研Horizontal Research
		list.add(new String[] { "hor_id", "横向科研id" });
		list.add(new String[] { "hor_no", "横向科研编号" });
		list.add(new String[] { "hor_rank", "横向科研排名" });
		list.add(new String[] { "hor _manager", "横向科研项目负责人","项目负责人" });
		list.add(new String[] { "hor _personnel", "横向科研参加人员","参加人员"});
		list.add(new String[] { "hor _courseName", "横向科研课题名称","课题名称" });
		list.add(new String[] { "hor_introduction", "横向科研简单介绍","横向科研简介"});
		list.add(new String[] { "hor _projectTime", "横向科研立项时间","立项时间"});
		list.add(new String[] { "hor _endTime", "结题时间","结题日期"});
		list.add(new String[] { "hor_cilentName", "客户名称" });
		list.add(new String[] { "hor_subjcerCost", "课题总经费","总经费" });
		list.add(new String[] { "hor_inplactCost", "到位经费" });
		list.add(new String[] { "hor _scan", "横向科研扫描件" });
		// 指导学生Instructed students
		list.add(new String[] { "ins_stu_id", "索引id" });
		list.add(new String[] { "ins_stu_rank", "排名" });
		list.add(new String[] { "ins_stu _teancherOne", "指导教师一" });
		list.add(new String[] { "ins_stu_oneUnit", "指导教师一单位" });
		list.add(new String[] { "ins_stu_teacherTwo", "指导教师二" });
		list.add(new String[] { "ins_stu_twoUnit", "指导教师二单位" });
		list.add(new String[] { "ins_stu_teacherThree", "指导教师三" });
		list.add(new String[] { "ins_stu_threeUnit", "指导教师三单位" });
		list.add(new String[] { "ins_stu_num", "学号" });
		list.add(new String[] { "ins_stu_name", "学生姓名" });
		list.add(new String[] { "ins_stu_comName", "竞赛名称" });
		list.add(new String[] { "ins_stu_proName", "项目名称" });
		list.add(new String[] { "ins_stu_startTime", "开始时间（年月日）" });
		list.add(new String[] { "ins_stu_endTime", "结束时间（年月日）" });
		list.add(new String[] { "ins_stu_type", "集体或个人" });
		list.add(new String[] { "ins_stu_others", "团队其他成员" });
		list.add(new String[] { "ins_stu_organizer", "主办单位" });
		list.add(new String[] { "ins_stu_reward", "是否获奖" });
		list.add(new String[] { "ins_stu_rewardTime", "获奖时间","获奖日期" });
		list.add(new String[] { "ins_stu_rewardLevel", "学生获奖级别","获奖级别"});
		list.add(new String[] { "ins_stu_rewardDetail",
				"获奖等级或奖项名称（特定奖、一等奖、最佳设计奖等等）说明" });
		list.add(new String[] { "ins_stu_scan", "扫描件" });
		// 挂职实践Practice
		list.add(new String[] { "pra_id", "索引id" });
		list.add(new String[] { "pra_startTime", "起始时间" });
		list.add(new String[] { "pra_endTime", "结束时间" });
		list.add(new String[] { "pra_post", "实践职务","时间职位"});
		list.add(new String[] { "pra_project", "依托项目" });
		list.add(new String[] { "pra_content", "实践内容" });
		list.add(new String[] { "pra_scan", "扫描件" });
		// 培训学习Train
		list.add(new String[] { "tra_id", "索引id" });
		list.add(new String[] { "tra_startTime", "起始时间" });
		list.add(new String[] { "tra_endTime", "结束时间" });
		list.add(new String[] { "tra_address", "地点" ,"培训地址"});
		list.add(new String[] { "tra_theme", "主题" ,"培训主题"});
		list.add(new String[] { "tra_content", "培训内容" });
		list.add(new String[] { "tra_result", "培训成果" ,"培训结果"});
		list.add(new String[] { "tra_scan", "扫描件" });
		// 奖励Reward
		list.add(new String[] { "rew_id", "索引id" });
		list.add(new String[] { "rew_time", "奖励时间","奖励日期"});
		list.add(new String[] { "rew_name", "奖励名称"});
		list.add(new String[] { "rew_department", "奖励部门" });
		list.add(new String[] { "rew_level", "奖励级别" });
		list.add(new String[] { "rew_levelDetail", "获奖等级或奖项名称" });
		list.add(new String[] { "rew_family", "奖励类别" });
		list.add(new String[] { "rew_ascription", "集体或个人" });
		list.add(new String[] { "rew-scan", "扫描件" });
		// 当辅导员情况Instructor
		list.add(new String[] { "ins_id", "索引id" });
		list.add(new String[] { "ins_startTime", "起始时间" });
		list.add(new String[] { "ins_endTime", "结束时间" });
		list.add(new String[] { "ins_classes", "班级" });
		// list.add(new String[] { "", "" });

	}

	public ArrayList<String[]> getBasicCheckTable() {
		return list;
	}

	public void setBasicCheckTable(ArrayList<String[]> basicCheckTable) {
		this.list = basicCheckTable;
	}
}
