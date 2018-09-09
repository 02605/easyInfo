package com.domain;

import java.sql.Date;

/**
tea_eva_id	Integer		NO	yes	教学评估id	No[新增属性]
tea_id	varchar	100	No	No	职工号 	Yes
tea_eva_year	Date		No	no	学年	No
tea_eva_grade	varchar	32	No	No	评估成绩	Yes
 * @author DELL
 *	教学评估表
 */
public class TeachingEvaluation {

	private Integer tea_eva_id;
	private Teacher tea_id;
	private Date tea_eva_year;
	private BaseDict tea_eva_grade;
	
	
	public Integer getTea_eva_id() {
		return tea_eva_id;
	}
	public void setTea_eva_id(Integer tea_eva_id) {
		this.tea_eva_id = tea_eva_id;
	}
	public Teacher getTea_id() {
		return tea_id;
	}
	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	public Date getTea_eva_year() {
		return tea_eva_year;
	}
	public void setTea_eva_year(Date tea_eva_year) {
		this.tea_eva_year = tea_eva_year;
	}
	public BaseDict getTea_eva_grade() {
		return tea_eva_grade;
	}
	public void setTea_eva_grade(BaseDict tea_eva_grade) {
		this.tea_eva_grade = tea_eva_grade;
	}
	@Override
	public String toString() {
		return "TeachingEvaluation [tea_eva_id=" + tea_eva_id + ", tea_id="
				+ tea_id + ", tea_eva_year=" + tea_eva_year
				+ ", tea_eva_grade=" + tea_eva_grade + "]";
	}
	
}
