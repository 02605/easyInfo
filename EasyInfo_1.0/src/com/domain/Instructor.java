package com.domain;

import java.sql.Date;

/**
 * 辅导员情况
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Instructor 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 下午3:08:39 
*
 */
public class Instructor {

	private Integer ins_id          ;//索引id
	                                
	private String ins_classes      ;//班级
	                                
	private Date ins_startTime      ;//起始时间
	private Date ins_endTime        ;//结束时间
	                                
	private Teacher tea_id          ;//职工号 

	public Integer getIns_id() {
		return ins_id;
	}

	public void setIns_id(Integer ins_id) {
		this.ins_id = ins_id;
	}

	public String getIns_classes() {
		return ins_classes;
	}

	public void setIns_classes(String ins_classes) {
		this.ins_classes = ins_classes;
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

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	
	
	
}
