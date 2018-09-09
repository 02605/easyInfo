package com.service;

/**
 * 关于Excel的一些操作
 * 
 * @author 陶宇豪
 * @return url
 */
public interface ExcelService {
	public String autoFillData(String tea_id, String fromPath, String toPath,
			String fileName) throws Exception;

	// public String addMethod();
	//
	// public String deleteMethod();

}
