package com.domain;

import java.sql.Date;

/**
 * 纵向研究
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: VerticalResearch 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 上午10:24:15 
*
 */
public class VerticalResearch {
	
	private Integer ver_id;//纵向科研id

	private String ver_no;//纵向科研编号
	private String ver_rank;//排名
	private String ver_manager;//项目负责人
	private String ver_personnel;//参加人员
	private String ver_courseName;//课题名称
	private String ver_introduction;//简单介绍
	private String ver_projectUnit;//立项单位
	private String ver_identCon;//鉴定结论
	private String ver_scan;//扫描件
	
	private Date ver_projectTime;//立项时间
	private Date ver_endTime;//结题时间
	private Date ver_identTime;//鉴定时间
	
	private Teacher tea_id;//职工号 
	
	private BaseDict ver_nature;//性质
	private BaseDict ver_projectLevel;//立项级别
	private BaseDict ver_identLevel;//鉴定级别
	public Integer getVer_id() {
		return ver_id;
	}
	public void setVer_id(Integer ver_id) {
		this.ver_id = ver_id;
	}
	public String getVer_no() {
		return ver_no;
	}
	public void setVer_no(String ver_no) {
		this.ver_no = ver_no;
	}
	public String getVer_rank() {
		return ver_rank;
	}
	public void setVer_rank(String ver_rank) {
		this.ver_rank = ver_rank;
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
	public String getVer_introduction() {
		return ver_introduction;
	}
	public void setVer_introduction(String ver_introduction) {
		this.ver_introduction = ver_introduction;
	}
	public String getVer_projectUnit() {
		return ver_projectUnit;
	}
	public void setVer_projectUnit(String ver_projectUnit) {
		this.ver_projectUnit = ver_projectUnit;
	}
	public String getVer_identCon() {
		return ver_identCon;
	}
	public void setVer_identCon(String ver_identCon) {
		this.ver_identCon = ver_identCon;
	}
	public String getVer_scan() {
		return ver_scan;
	}
	public void setVer_scan(String ver_scan) {
		this.ver_scan = ver_scan;
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
	public Date getVer_identTime() {
		return ver_identTime;
	}
	public void setVer_identTime(Date ver_identTime) {
		this.ver_identTime = ver_identTime;
	}
	public Teacher getTea_id() {
		return tea_id;
	}
	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	public BaseDict getVer_nature() {
		return ver_nature;
	}
	public void setVer_nature(BaseDict ver_nature) {
		this.ver_nature = ver_nature;
	}
	public BaseDict getVer_projectLevel() {
		return ver_projectLevel;
	}
	public void setVer_projectLevel(BaseDict ver_projectLevel) {
		this.ver_projectLevel = ver_projectLevel;
	}
	public BaseDict getVer_identLevel() {
		return ver_identLevel;
	}
	public void setVer_identLevel(BaseDict ver_identLevel) {
		this.ver_identLevel = ver_identLevel;
	}
	
	
}
