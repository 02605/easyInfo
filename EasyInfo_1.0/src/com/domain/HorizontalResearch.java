package com.domain;

import java.sql.Date;

/**
 * 横向科研表
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: HorizontalResearch 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 上午10:44:50 
*
 */
public class HorizontalResearch {
	
	private Integer hor_id;//横向科研id

	private String hor_no;//横向科研编号
	private String hor_rank;//排名
	private String hor_manager;//项目负责人
	private String hor_personnel;//参加人员
	private String hor_courseName;//课题名称
	private String hor_introduction;//简单介绍
	private String hor_cilentName;//客户名称
	private String hor_scan;//扫描件
	
	private Date hor_projectTime;//立项时间
	private Date hor_endTime;//结题时间
	
	private Double hor_subjcerCost;//课题总经费
	private Double hor_inplactCost;//到位经费
	
	private Teacher tea_id;//职工号 

	public Integer getHor_id() {
		return hor_id;
	}

	public void setHor_id(Integer hor_id) {
		this.hor_id = hor_id;
	}

	public String getHor_no() {
		return hor_no;
	}

	public void setHor_no(String hor_no) {
		this.hor_no = hor_no;
	}

	public String getHor_rank() {
		return hor_rank;
	}

	public void setHor_rank(String hor_rank) {
		this.hor_rank = hor_rank;
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

	public String getHor_introduction() {
		return hor_introduction;
	}

	public void setHor_introduction(String hor_introduction) {
		this.hor_introduction = hor_introduction;
	}

	public String getHor_cilentName() {
		return hor_cilentName;
	}

	public void setHor_cilentName(String hor_cilentName) {
		this.hor_cilentName = hor_cilentName;
	}

	public String getHor_scan() {
		return hor_scan;
	}

	public void setHor_scan(String hor_scan) {
		this.hor_scan = hor_scan;
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

	public Double getHor_subjcerCost() {
		return hor_subjcerCost;
	}

	public void setHor_subjcerCost(Double hor_subjcerCost) {
		this.hor_subjcerCost = hor_subjcerCost;
	}

	public Double getHor_inplactCost() {
		return hor_inplactCost;
	}

	public void setHor_inplactCost(Double hor_inplactCost) {
		this.hor_inplactCost = hor_inplactCost;
	}

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	
	
	
}
