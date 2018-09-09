package com.domain;
/**
 * 年终考核表
* @author DELL
* @authorEmail lamadiemofly@163.com 
* @ClassName: AnnualReview 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date 2018年8月31日 下午4:53:39 
*
 */
public class AnnualReview {

	private Integer ann_rev_id;//id
	private Teacher tea_id;//职工号
	private Integer ann_rev_year;//年份
	private BaseDict ann_rev_grade;//考核结果
	public Integer getAnn_rev_id() {
		return ann_rev_id;
	}
	public void setAnn_rev_id(Integer ann_rev_id) {
		this.ann_rev_id = ann_rev_id;
	}
	public Teacher getTea_id() {
		return tea_id;
	}
	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}
	public Integer getAnn_rev_year() {
		return ann_rev_year;
	}
	public void setAnn_rev_year(Integer ann_rev_year) {
		this.ann_rev_year = ann_rev_year;
	}
	public BaseDict getAnn_rev_grade() {
		return ann_rev_grade;
	}
	public void setAnn_rev_grade(BaseDict ann_rev_grade) {
		this.ann_rev_grade = ann_rev_grade;
	}
	@Override
	public String toString() {
		return "AnnualReview [ann_rev_id=" + ann_rev_id + ", tea_id=" + tea_id
				+ ", ann_rev_year=" + ann_rev_year + ", ann_rev_grade="
				+ ann_rev_grade + "]";
	}
	
	
	
}
