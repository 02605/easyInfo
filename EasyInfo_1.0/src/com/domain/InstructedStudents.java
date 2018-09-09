package com.domain;

import java.sql.Date;

/**
 * 指导学生
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: InstructedStudents 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 上午11:00:13 
*
 */
public class InstructedStudents {
	
	private Integer ins_stu_id           ;// 索引id    

	private String ins_stu_rank          ;//排名
	private String ins_stu_teancherOne   ;//指导教师一
	private String ins_stu_oneUnit       ;//指导教师一单位
	private String ins_stu_teacherTwo    ;//指导教师二
	private String ins_stu_twoUnit       ;//指导教师二单位
	private String ins_stu_teacherThree  ;//指导教师三
	private String ins_stu_threeUnit     ;//指导教师三单位
	private String ins_stu_num           ;//学号
	private String ins_stu_name          ;//学生姓名
	private String ins_stu_comName       ;//竞赛名称
	private String ins_stu_proName       ;//项目名称
	private String ins_stu_others        ;//团队其他成员
	private String ins_stu_organizer     ;//主办单位
	private String ins_stu_rewardDetail  ;//获奖等级或奖项名称
	private String ins_stu_scan          ;//扫描件
	
	private Date ins_stu_startTime       ;//开始时间（年月日）
	private Date ins_stu_endTime         ;//结束时间（年月日）
	private Date ins_stu_rewardTime      ;//获奖时间
	
	private Teacher tea_id               ;//职工号 
	
	private BaseDict ins_stu_type        ;//集体或个人
	private BaseDict ins_stu_reward      ;//是否获奖
	private BaseDict ins_stu_rewardLevel ;//学生获奖级别
	public Integer getIns_stu_id() {
		return ins_stu_id;
	}
	public void setIns_stu_id(Integer ins_stu_id) {
		this.ins_stu_id = ins_stu_id;
	}
	public String getIns_stu_rank() {
		return ins_stu_rank;
	}
	public void setIns_stu_rank(String ins_stu_rank) {
		this.ins_stu_rank = ins_stu_rank;
	}
	public String getIns_stu_teancherOne() {
		return ins_stu_teancherOne;
	}
	public void setIns_stu_teancherOne(String ins_stu_teancherOne) {
		this.ins_stu_teancherOne = ins_stu_teancherOne;
	}
	public String getIns_stu_oneUnit() {
		return ins_stu_oneUnit;
	}
	public void setIns_stu_oneUnit(String ins_stu_oneUnit) {
		this.ins_stu_oneUnit = ins_stu_oneUnit;
	}
	public String getIns_stu_teacherTwo() {
		return ins_stu_teacherTwo;
	}
	public void setIns_stu_teacherTwo(String ins_stu_teacherTwo) {
		this.ins_stu_teacherTwo = ins_stu_teacherTwo;
	}
	public String getIns_stu_twoUnit() {
		return ins_stu_twoUnit;
	}
	public void setIns_stu_twoUnit(String ins_stu_twoUnit) {
		this.ins_stu_twoUnit = ins_stu_twoUnit;
	}
	public String getIns_stu_teacherThree() {
		return ins_stu_teacherThree;
	}
	public void setIns_stu_teacherThree(String ins_stu_teacherThree) {
		this.ins_stu_teacherThree = ins_stu_teacherThree;
	}
	public String getIns_stu_threeUnit() {
		return ins_stu_threeUnit;
	}
	public void setIns_stu_threeUnit(String ins_stu_threeUnit) {
		this.ins_stu_threeUnit = ins_stu_threeUnit;
	}
	public String getIns_stu_num() {
		return ins_stu_num;
	}
	public void setIns_stu_num(String ins_stu_num) {
		this.ins_stu_num = ins_stu_num;
	}
	public String getIns_stu_name() {
		return ins_stu_name;
	}
	public void setIns_stu_name(String ins_stu_name) {
		this.ins_stu_name = ins_stu_name;
	}
	public String getIns_stu_comName() {
		return ins_stu_comName;
	}
	public void setIns_stu_comName(String ins_stu_comName) {
		this.ins_stu_comName = ins_stu_comName;
	}
	public String getIns_stu_proName() {
		return ins_stu_proName;
	}
	public void setIns_stu_proName(String ins_stu_proName) {
		this.ins_stu_proName = ins_stu_proName;
	}
	public String getIns_stu_others() {
		return ins_stu_others;
	}
	public void setIns_stu_others(String ins_stu_others) {
		this.ins_stu_others = ins_stu_others;
	}
	public String getIns_stu_organizer() {
		return ins_stu_organizer;
	}
	public void setIns_stu_organizer(String ins_stu_organizer) {
		this.ins_stu_organizer = ins_stu_organizer;
	}
	public String getIns_stu_rewardDetail() {
		return ins_stu_rewardDetail;
	}
	public void setIns_stu_rewardDetail(String ins_stu_rewardDetail) {
		this.ins_stu_rewardDetail = ins_stu_rewardDetail;
	}
	public String getIns_stu_scan() {
		return ins_stu_scan;
	}
	public void setIns_stu_scan(String ins_stu_scan) {
		this.ins_stu_scan = ins_stu_scan;
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
	public Date getIns_stu_rewardTime() {
		return ins_stu_rewardTime;
	}
	public void setIns_stu_rewardTime(Date ins_stu_rewardTime) {
		this.ins_stu_rewardTime = ins_stu_rewardTime;
	}
	public Teacher getTea_id() {
		return tea_id;
	}
	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	public BaseDict getIns_stu_type() {
		return ins_stu_type;
	}
	public void setIns_stu_type(BaseDict ins_stu_type) {
		this.ins_stu_type = ins_stu_type;
	}
	public BaseDict getIns_stu_reward() {
		return ins_stu_reward;
	}
	public void setIns_stu_reward(BaseDict ins_stu_reward) {
		this.ins_stu_reward = ins_stu_reward;
	}
	public BaseDict getIns_stu_rewardLevel() {
		return ins_stu_rewardLevel;
	}
	public void setIns_stu_rewardLevel(BaseDict ins_stu_rewardLevel) {
		this.ins_stu_rewardLevel = ins_stu_rewardLevel;
	}
	
	
}
