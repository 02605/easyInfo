package com.domain;

import java.sql.Date;

/**
 * 奖励
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: Reward 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年9月2日 下午2:58:43 
*
 */
public class Reward {
	
	private Integer rew_id            ;//索引id
	                                  
	private String rew_name           ;//奖励名称
	private String rew_department     ;//奖励部门
	private String rew_levelDetail    ;//获奖等级或奖项名称
	private String rew_scan           ;//扫描件
	                                  
	private Date rew_time             ;//奖励时间
	                                  
	private Teacher tea_id            ;//职工号 
	                                  
	private BaseDict rew_level        ;//奖励级别
	private BaseDict rew_family       ;//奖励类别
	private BaseDict rew_ascription   ;//集体或个人
	
	public Integer getRew_id() {
		return rew_id;
	}
	public void setRew_id(Integer rew_id) {
		this.rew_id = rew_id;
	}
	public String getRew_name() {
		return rew_name;
	}
	public void setRew_name(String rew_name) {
		this.rew_name = rew_name;
	}
	public String getRew_department() {
		return rew_department;
	}
	public void setRew_department(String rew_department) {
		this.rew_department = rew_department;
	}
	public String getRew_levelDetail() {
		return rew_levelDetail;
	}
	public void setRew_levelDetail(String rew_levelDetail) {
		this.rew_levelDetail = rew_levelDetail;
	}
	public String getRew_scan() {
		return rew_scan;
	}
	public void setRew_scan(String rew_scan) {
		this.rew_scan = rew_scan;
	}
	public Date getRew_time() {
		return rew_time;
	}
	public void setRew_time(Date rew_time) {
		this.rew_time = rew_time;
	}
	public Teacher getTea_id() {
		return tea_id;
	}
	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	public BaseDict getRew_level() {
		return rew_level;
	}
	public void setRew_level(BaseDict rew_level) {
		this.rew_level = rew_level;
	}
	public BaseDict getRew_family() {
		return rew_family;
	}
	public void setRew_family(BaseDict rew_family) {
		this.rew_family = rew_family;
	}
	public BaseDict getRew_ascription() {
		return rew_ascription;
	}
	public void setRew_ascription(BaseDict rew_ascription) {
		this.rew_ascription = rew_ascription;
	}
	
	

}
