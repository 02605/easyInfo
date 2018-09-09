package com.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 普通用戶登陸表
 * @author DELL
 *
 */
public class UserLogin {

	private String tea_id;//职工号
	private String user_password;//密码
	private BaseDict user_state;//状态
	
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public BaseDict getUser_state() {
		return user_state;
	}
	public void setUser_state(BaseDict user_state) {
		this.user_state = user_state;
	}

	@Override
	public String toString() {
		return "UserLogin [tea_id=" + tea_id + ","
				+ " user_password="+ user_password +"]";
	}
	
	
}
