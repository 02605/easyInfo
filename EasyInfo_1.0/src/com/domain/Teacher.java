package com.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Teacher 
* @Description: TODO(普通用戶表(教师表)) 
* @date 2018年8月29日 上午9:00:04 
*
 */
/** 
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Teacher 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 下午2:41:22 
*  
*/ 
public class Teacher {
	/*
	 * tea_id 职工号 varchar tea_name 姓名 varchar tea_gender 性别 Varchar tea_birthday
	 * 出生日期 Date tea_identityId 身份证号 varchar tea_nation 民族 Varchar tea_political
	 * 政治面貌 Varchar tea_workDate 参加工作时间 Date tea_jobTitel 职称 Varchar tea_eduBG
	 * 学历 Varchar tea_degree 学位 Varchar tea_home 家庭住址 varchar tea_phone 电话
	 * varchar tea_qq QQ varchar tea_weChat 微信 varchar tea_dep 系别 varchar
	 * tea_enable 状态 varchar tea_email 邮箱 varchar tea_role 角色 varchar
	 */
	private String tea_id; // 职工号
	private String tea_name; // 姓名
	private String tea_identityId; // 身份证号
	private String tea_home; // 家庭住址
	private String tea_phone; // 电话
	private String tea_qq; // qq
	private String tea_weChat; // 微信
	private String tea_email; // 邮箱
	private String tea_img;//证件照
	
	private Date tea_birthday; // 出生日期
	private Date tea_workDate; // 参加工作日期

	private BaseDict tea_nation; // 民族
	private BaseDict tea_political; // 政治面貌
	private BaseDict tea_jobTitel; // 职称
	private BaseDict tea_eduBG; // 学历
	private BaseDict tea_degree; // 学位
	private BaseDict tea_gender; // 性别
	private BaseDict tea_role; // 角色
	private BaseDict tea_dep; // 系别
	private BaseDict tea_enable; // 状态

	private Set<TeachingEvaluation> TeachingEvaluationS = new HashSet<TeachingEvaluation>();// 教学评估
	
	private Set<AnnualReview> AnnualReviewS = new HashSet<AnnualReview>();//年终考核表
	
	private Set<Thesis> ThesisS = new HashSet<Thesis>();//论文表
	
	private Set<CompileMateria> CompileMateriaS = new HashSet<CompileMateria>();//教材著作
	
	private Set<Patent> PatentS = new HashSet<Patent>();//专利
	
	private Set<VerticalResearch> VerticalResearchS = new HashSet<VerticalResearch>();//科研教研（纵向）
	
	private Set<HorizontalResearch> HorizontalResearchS = new HashSet<HorizontalResearch>();//横向科研
	
	private Set<InstructedStudents> InstructedStudentsS = new HashSet<InstructedStudents>();//指导学生
	
	private Set<Practice> PracticeS = new HashSet<Practice>();//挂职实践
	
	private Set<Train> TrainS = new HashSet<Train>();//培训学习
	
	private Set<Reward> RewardS = new HashSet<Reward>();//奖励
	
	private Set<Instructor> InstructorS = new HashSet<Instructor>();
	
	
	
	public Set<Instructor> getInstructorS() {
		return InstructorS;
	}

	public void setInstructorS(Set<Instructor> instructorS) {
		InstructorS = instructorS;
	}

	public Set<Reward> getRewardS() {
		return RewardS;
	}

	public void setRewardS(Set<Reward> rewardS) {
		RewardS = rewardS;
	}

	public Set<Train> getTrainS() {
		return TrainS;
	}

	public void setTrainS(Set<Train> trainS) {
		TrainS = trainS;
	}

	public Set<Practice> getPracticeS() {
		return PracticeS;
	}

	public void setPracticeS(Set<Practice> practiceS) {
		PracticeS = practiceS;
	}

	public Set<InstructedStudents> getInstructedStudentsS() {
		return InstructedStudentsS;
	}

	public void setInstructedStudentsS(Set<InstructedStudents> instructedStudentsS) {
		InstructedStudentsS = instructedStudentsS;
	}

	public Set<HorizontalResearch> getHorizontalResearchS() {
		return HorizontalResearchS;
	}

	public void setHorizontalResearchS(Set<HorizontalResearch> horizontalResearchS) {
		HorizontalResearchS = horizontalResearchS;
	}

	public Set<VerticalResearch> getVerticalResearchS() {
		return VerticalResearchS;
	}

	public void setVerticalResearchS(Set<VerticalResearch> verticalResearchS) {
		VerticalResearchS = verticalResearchS;
	}

	public Set<Patent> getPatentS() {
		return PatentS;
	}

	public void setPatentS(Set<Patent> patentS) {
		PatentS = patentS;
	}

	public Set<CompileMateria> getCompileMateriaS() {
		return CompileMateriaS;
	}

	public void setCompileMateriaS(Set<CompileMateria> compileMateriaS) {
		CompileMateriaS = compileMateriaS;
	}

	public Set<AnnualReview> getAnnualReviewS() {
		return AnnualReviewS;
	}

	public void setAnnualReviewS(Set<AnnualReview> annualReviewS) {
		AnnualReviewS = annualReviewS;
	}

	public Set<TeachingEvaluation> getTeachingEvaluationS() {
		return TeachingEvaluationS;
	}

	public void setTeachingEvaluationS(
			Set<TeachingEvaluation> teachingEvaluationS) {
		TeachingEvaluationS = teachingEvaluationS;
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

	public String getTea_identityId() {
		return tea_identityId;
	}

	public void setTea_identityId(String tea_identityId) {
		this.tea_identityId = tea_identityId;
	}

	public String getTea_home() {
		return tea_home;
	}

	public void setTea_home(String tea_home) {
		this.tea_home = tea_home;
	}

	public String getTea_phone() {
		return tea_phone;
	}

	public void setTea_phone(String tea_phone) {
		this.tea_phone = tea_phone;
	}

	public String getTea_qq() {
		return tea_qq;
	}

	public void setTea_qq(String tea_qq) {
		this.tea_qq = tea_qq;
	}

	public String getTea_weChat() {
		return tea_weChat;
	}

	public void setTea_weChat(String tea_weChat) {
		this.tea_weChat = tea_weChat;
	}

	public String getTea_email() {
		return tea_email;
	}

	public void setTea_email(String tea_email) {
		this.tea_email = tea_email;
	}

	public Date getTea_birthday() {
		return tea_birthday;
	}

	public void setTea_birthday(Date tea_birthday) {
		this.tea_birthday = tea_birthday;
	}

	public Date getTea_workDate() {
		return tea_workDate;
	}

	public void setTea_workDate(Date tea_workDate) {
		this.tea_workDate = tea_workDate;
	}

	public BaseDict getTea_nation() {
		return tea_nation;
	}

	public void setTea_nation(BaseDict tea_nation) {
		this.tea_nation = tea_nation;
	}

	public BaseDict getTea_political() {
		return tea_political;
	}

	public void setTea_political(BaseDict tea_political) {
		this.tea_political = tea_political;
	}

	public BaseDict getTea_jobTitel() {
		return tea_jobTitel;
	}

	public void setTea_jobTitel(BaseDict tea_jobTitel) {
		this.tea_jobTitel = tea_jobTitel;
	}

	public BaseDict getTea_eduBG() {
		return tea_eduBG;
	}

	public void setTea_eduBG(BaseDict tea_eduBG) {
		this.tea_eduBG = tea_eduBG;
	}

	public BaseDict getTea_degree() {
		return tea_degree;
	}

	public void setTea_degree(BaseDict tea_degree) {
		this.tea_degree = tea_degree;
	}

	public BaseDict getTea_gender() {
		return tea_gender;
	}

	public void setTea_gender(BaseDict tea_gender) {
		this.tea_gender = tea_gender;
	}

	public BaseDict getTea_role() {
		return tea_role;
	}

	public void setTea_role(BaseDict tea_role) {
		this.tea_role = tea_role;
	}

	public BaseDict getTea_dep() {
		return tea_dep;
	}

	public void setTea_dep(BaseDict tea_dep) {
		this.tea_dep = tea_dep;
	}

	public BaseDict getTea_enable() {
		return tea_enable;
	}

	public void setTea_enable(BaseDict tea_enable) {
		this.tea_enable = tea_enable;
	}

	
	public String getTea_img() {
		return tea_img;
	}

	public void setTea_img(String tea_img) {
		this.tea_img = tea_img;
	}

	
	public Set<Thesis> getThesisS() {
		return ThesisS;
	}

	public void setThesisS(Set<Thesis> thesisS) {
		ThesisS = thesisS;
	}

	@Override
	public String toString() {
		return "Teacher [tea_id=" + tea_id + ", tea_name=" + tea_name
				+ ", tea_role=" + tea_role + "]";
	}

}
