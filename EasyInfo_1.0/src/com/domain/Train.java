package com.domain;

import java.sql.Date;

/**
 * 培训学习
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Train 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 下午2:46:30 
*
 */
public class Train {
	
	private Integer tra_id         ;//索引id
	                              
	private String tra_address     ;//地点
	private String tra_theme       ;//主题
	private String tra_content     ;//培训内容
	private String tra_scan        ;//扫描件
	                               
	private Date tra_startTime     ;//起始时间
	private Date tra_endTime       ;//结束时间
	                               
	private Teacher tea_id         ;//职工号 
	
	private BaseDict tra_result    ;//培训成果

	public Integer getTra_id() {
		return tra_id;
	}

	public void setTra_id(Integer tra_id) {
		this.tra_id = tra_id;
	}

	public String getTra_address() {
		return tra_address;
	}

	public void setTra_address(String tra_address) {
		this.tra_address = tra_address;
	}

	public String getTra_theme() {
		return tra_theme;
	}

	public void setTra_theme(String tra_theme) {
		this.tra_theme = tra_theme;
	}

	public String getTra_content() {
		return tra_content;
	}

	public void setTra_content(String tra_content) {
		this.tra_content = tra_content;
	}

	public String getTra_scan() {
		return tra_scan;
	}

	public void setTra_scan(String tra_scan) {
		this.tra_scan = tra_scan;
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

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}

	public BaseDict getTra_result() {
		return tra_result;
	}

	public void setTra_result(BaseDict tra_result) {
		this.tra_result = tra_result;
	}
	
	
	
	
	
}
