package com.web.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.ExcelService;
import com.utils.showExcel.POIReadExcelToHtml;

public class ExcelAction extends ActionSupport {
	private ExcelService es;// Spring注入

	public String usePrivate() throws Exception {
		// 思路
		// 1. 在页面中选取模板，选择套用（传递其教师id，模板名，是否为私人模板->到此action中）
		// 2. 通过tea_id读取privateTemplate表，获取该教师下的对应模板
		// 3.
		// 使用ServletActionContext.getServletContext().getRealPath("/upload");获取到上传后文件的绝对地址
		// 4. 地址与模版名进行拼接，进而调用表格填充操作
		// 5. 获得返回的新文件地址(用以下载)，png文件地址(用以展示表格内容)，html代码(备用展示方法)。
		//
		// ---------------以下为调用ExcelService的方法
		// 此时仅使用私人模板，所以tea_id只有一个，如果需要批量导出，请传入一个String[]
		// ----------------------------至关重要的获取文件的代码-------------------------------------------
		String fromPath = ServletActionContext.getServletContext().getRealPath(
				"/methods/privateMethods")
				+ "\\";
		String toPath = ServletActionContext.getServletContext().getRealPath(
				"/methods/autoCreateExcel")
				+ "\\";
		// -------------------------------------------------------------------------
		ArrayList<String> teaList = new ArrayList<String>();
		teaList.add("101");// (此处tea_id为传参而来)
		// 新建resultList，存储处理后的数据
		ArrayList<String[]> resultList = new ArrayList<String[]>();
		// 遍历teaList，用于批量处理
		for (String tea : teaList) {
			// 填充Excel文件，并且返回excel文件地址
			String toFile = es.autoFillData(tea, fromPath, toPath,
					"简洁个人信息-back-pub.xlsx");
			System.out.println(toFile);
			// 生成html代码
			String htmlExcel = new POIReadExcelToHtml().main(toFile);// 生成html
			// // 处理png文件，返回png文件地址 // 此处暂时存在错误，等待修复
			// String pngFile = new excel2Picture().createPng(toFile);
			// 第一项为生成的excel文件地址，第二项为html代码，第三项为png文件地址
			String[] result = { toFile, htmlExcel };
			// 加入到结果集合里
			resultList.add(result);
		}
		// 哪个部分需要使用就直接调用resultList中对应的String[]，再获取相应的内容即可。
		return SUCCESS;
	}

	// 用于Spring注入
	public void setEs(ExcelService es) {
		this.es = es;
	}
}
