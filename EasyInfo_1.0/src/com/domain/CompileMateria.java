package com.domain;

import java.sql.Date;

/**
 * CompileMateria教材著作表
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: CompileMateria 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 上午9:07:41 
*
 */
public class CompileMateria {
	
	private Integer cm_id;//教材著作id

	private String cm_rank;//排名
	private String cm_chiefEditor;//主编
	private String cm_subeditor;//副主编
	private String cm_name;//著作名称
	private String cm_edition;//版次
	private String cm_location;//出版地
	private String cm_publisher;//出版者
	private String cm_scan;//扫描件
	
	private Date cm_pubTime;//出版时间
	private Integer cm_pageNum;//页码
	private Integer cm_bearNum;//承担字数
	
	private Teacher tea_id;//职工号 

	public Integer getCm_id() {
		return cm_id;
	}

	public void setCm_id(Integer cm_id) {
		this.cm_id = cm_id;
	}

	public String getCm_rank() {
		return cm_rank;
	}

	public void setCm_rank(String cm_rank) {
		this.cm_rank = cm_rank;
	}

	public String getCm_chiefEditor() {
		return cm_chiefEditor;
	}

	public void setCm_chiefEditor(String cm_chiefEditor) {
		this.cm_chiefEditor = cm_chiefEditor;
	}

	public String getCm_subeditor() {
		return cm_subeditor;
	}

	public void setCm_subeditor(String cm_subeditor) {
		this.cm_subeditor = cm_subeditor;
	}

	public String getCm_name() {
		return cm_name;
	}

	public void setCm_name(String cm_name) {
		this.cm_name = cm_name;
	}

	public String getCm_edition() {
		return cm_edition;
	}

	public void setCm_edition(String cm_edition) {
		this.cm_edition = cm_edition;
	}

	public String getCm_location() {
		return cm_location;
	}

	public void setCm_location(String cm_location) {
		this.cm_location = cm_location;
	}

	public String getCm_publisher() {
		return cm_publisher;
	}

	public void setCm_publisher(String cm_publisher) {
		this.cm_publisher = cm_publisher;
	}

	public String getCm_scan() {
		return cm_scan;
	}

	public void setCm_scan(String cm_scan) {
		this.cm_scan = cm_scan;
	}

	public Date getCm_pubTime() {
		return cm_pubTime;
	}

	public void setCm_pubTime(Date cm_pubTime) {
		this.cm_pubTime = cm_pubTime;
	}

	public Integer getCm_pageNum() {
		return cm_pageNum;
	}

	public void setCm_pageNum(Integer cm_pageNum) {
		this.cm_pageNum = cm_pageNum;
	}

	public Integer getCm_bearNum() {
		return cm_bearNum;
	}

	public void setCm_bearNum(Integer cm_bearNum) {
		this.cm_bearNum = cm_bearNum;
	}

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}

	@Override
	public String toString() {
		return "CompileMateria [cm_id=" + cm_id + ", cm_rank=" + cm_rank
				+ ", cm_subeditor=" + cm_subeditor + ", cm_edition="
				+ cm_edition + ", cm_location=" + cm_location
				+ ", cm_publisher=" + cm_publisher + ", cm_scan=" + cm_scan
				+ ", cm_pubTime=" + cm_pubTime + ", cm_pageNum=" + cm_pageNum
				+ ", tea_id=" + tea_id + "]";
	}
	
	
	
	
	
	
	
}
