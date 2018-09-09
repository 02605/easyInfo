package com.domain;

import java.sql.Date;

/**
 * 专利表
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Patent 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 上午9:57:38 
*
 */
public class Patent {
	
	private Integer pat_id;//专利id
	
	private String pat_rank;//排名
	private String pat_author;//作者
	private String pat_name;//题名
	private String pat_country;//国别
	private String pat_registerNum;//登记号
	private String pat_scan;//扫描件
	
	private Date pat_pubTime;//发布日期
	
	private Teacher tea_id;//职工号 
	
	private BaseDict pat_type;//专利类型

	public Integer getPat_id() {
		return pat_id;
	}

	public void setPat_id(Integer pat_id) {
		this.pat_id = pat_id;
	}

	public String getPat_rank() {
		return pat_rank;
	}

	public void setPat_rank(String pat_rank) {
		this.pat_rank = pat_rank;
	}

	public String getPat_author() {
		return pat_author;
	}

	public void setPat_author(String pat_author) {
		this.pat_author = pat_author;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getPat_country() {
		return pat_country;
	}

	public void setPat_country(String pat_country) {
		this.pat_country = pat_country;
	}

	public String getPat_registerNum() {
		return pat_registerNum;
	}

	public void setPat_registerNum(String pat_registerNum) {
		this.pat_registerNum = pat_registerNum;
	}

	public String getPat_scan() {
		return pat_scan;
	}

	public void setPat_scan(String pat_scan) {
		this.pat_scan = pat_scan;
	}

	public Date getPat_pubTime() {
		return pat_pubTime;
	}

	public void setPat_pubTime(Date pat_pubTime) {
		this.pat_pubTime = pat_pubTime;
	}

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}

	public BaseDict getPat_type() {
		return pat_type;
	}

	public void setPat_type(BaseDict pat_type) {
		this.pat_type = pat_type;
	}
	
	
	
	
	

}
