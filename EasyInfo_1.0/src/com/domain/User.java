package com.domain;

/** 用于存储用户的查询信息
 * Users entity. @author MyEclipse Persistence Tools
 */

public class User {
	private String tea_id;
	private String user_password;
	private BaseDict user_state;
	private BaseDict tea_role;

	public User() {
	}
	/**
	 * @param tea_id
	 * @param user_password
	 * @param user_state
	 * @param tea_role
	 */
	public User(String tea_id, String user_password, BaseDict user_state,
			BaseDict tea_role) {
		super();
		this.tea_id = tea_id;
		this.user_password = user_password;
		this.user_state = user_state;
		this.tea_role = tea_role;
	}
	public String getTea_id() {
		return this.tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	/**
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}
	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/**
	 * @return the user_state
	 */
	public BaseDict getUser_state() {
		return user_state;
	}
	/**
	 * @param user_state the user_state to set
	 */
	public void setUser_state(BaseDict user_state) {
		this.user_state = user_state;
	}
	/**
	 * @return the tea_role
	 */
	public BaseDict getTea_role() {
		return tea_role;
	}
	/**
	 * @param tea_role the tea_role to set
	 */
	public void setTea_role(BaseDict tea_role) {
		this.tea_role = tea_role;
	}

}