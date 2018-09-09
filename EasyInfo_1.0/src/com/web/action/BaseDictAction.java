package com.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.domain.BaseDict;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseDictService;

public class BaseDictAction extends ActionSupport {

	private String dict_type_code;//数据字典类别代码
	private BaseDictService baseDictService;
	
	@Override
	public String execute() throws Exception {
		//根据类别查找BaseDict的集合list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//将list转换为json
		String Json = JSONArray.fromObject(list).toString();
		//发送到页面
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(Json);
		return null;
	}
	
	
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	
	
}
