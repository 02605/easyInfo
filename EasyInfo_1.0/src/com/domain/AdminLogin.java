package com.domain;

/**
 * admin用戶登陸表
 * @author DELL
 *
 */
public class AdminLogin {
/*
 * CREATE TABLE `adminlogin` (
  `tea_id` varchar(100) NOT NULL DEFAULT '' COMMENT '职工号 ',
  `admin_password` varchar(50) NOT NULL COMMENT '密码',
  `admin_state` char(1) NOT NULL COMMENT '状态1/0',
 */
	private String tea_id;//职工号
	private String admin_password;//密码
	private BaseDict admin_state;//状态
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public BaseDict getAdmin_state() {
		return admin_state;
	}
	public void setAdmin_state(BaseDict admin_state) {
		this.admin_state = admin_state;
	}
	@Override
	public String toString() {
		return "AdminLogin [tea_id=" + tea_id + ", admin_password="
				+ admin_password + ", admin_state=" + admin_state+ "]";
	}
	
}
