package com.domain;

import java.sql.Date;

/**
 * 挂职实践
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Practice 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 下午2:34:23 
*
 */
public class Practice {

	private Integer pra_id         ;//索引id
	                              
	private String pra_post        ;//实践职务
	private String pra_project     ;//依托项目
	private String pra_content     ;//实践内容
	private String pra_scan        ;//扫描件
	private String pra_company     ;//实践单位
	                              
	private Date pra_startTime     ;//起始时间
	private Date pra_endTime       ;//结束时间
	                             
	private Teacher tea_id         ;//职工号 

	public Integer getPra_id() {
		return pra_id;
	}

	public void setPra_id(Integer pra_id) {
		this.pra_id = pra_id;
	}

	public String getPra_post() {
		return pra_post;
	}

	public void setPra_post(String pra_post) {
		this.pra_post = pra_post;
	}

	public String getPra_project() {
		return pra_project;
	}

	public void setPra_project(String pra_project) {
		this.pra_project = pra_project;
	}

	public String getPra_content() {
		return pra_content;
	}

	public void setPra_content(String pra_content) {
		this.pra_content = pra_content;
	}

	public String getPra_scan() {
		return pra_scan;
	}

	public void setPra_scan(String pra_scan) {
		this.pra_scan = pra_scan;
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

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}

	public String getPra_company() {
		return pra_company;
	}

	public void setPra_company(String pra_company) {
		this.pra_company = pra_company;
	}
	
	
}
