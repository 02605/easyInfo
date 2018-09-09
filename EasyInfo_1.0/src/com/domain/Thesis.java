package com.domain;

import java.sql.Date;

/**
 * Thesis论文表
 * 
 * @author DELL
 * @authorEmail lamadiemofly@163.com
 * @ClassName: Thesis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年9月1日 下午12:03:54
 * 
 */
public class Thesis {
	private Integer the_id;// 论文论文id
	private Integer the_startNum;// 起始页码
	private Integer the_endNum;// 终止页码
	private Double the_wordNum;// 字数
	private String the_rank;// 排名
	private String the_firstAuthor;// 第一作者
	private String the_otherAuthor;// 其他作者
	private String the_title;// 论文题目
	private String the_periodical;// 刊物名称
	private String the_reelNum;// 卷号
	private String the_issue;// 期号
	private String the_scan;// 扫描件
	private Teacher tea_id;// 职工号
	private BaseDict the_level;// 论文层次
	private Date the_pubTime;// 出版时间
	private String the_merge;

	public String getThe_merge() {
		return the_merge;
	}

	// public void setThe_merge(String the_merge) {
	// this.the_merge = getThe_firstAuthor() + "," + getThe_otherAuthor()
	// + "," + getThe_title() + "," + getThe_periodical() + ","
	// + getThe_pubTime() + "," + getThe_reelNum() + "("
	// + getThe_issue() + ")" + ":" + getThe_startNum() + "-"
	// + getThe_endNum();
	// }

	public Integer getThe_id() {
		return the_id;
	}

	public void setThe_id(Integer the_id) {
		this.the_id = the_id;
	}

	public Integer getThe_startNum() {
		return the_startNum;
	}

	public void setThe_startNum(Integer the_startNum) {
		this.the_startNum = the_startNum;
	}

	public Integer getThe_endNum() {
		return the_endNum;
	}

	public void setThe_endNum(Integer the_endNum) {
		this.the_endNum = the_endNum;
	}

	public Double getThe_wordNum() {
		return the_wordNum;
	}

	public void setThe_wordNum(Double the_wordNum) {
		this.the_wordNum = the_wordNum;
	}

	public String getThe_rank() {
		return the_rank;
	}

	public void setThe_rank(String the_rank) {
		this.the_rank = the_rank;
	}

	public String getThe_firstAuthor() {
		return the_firstAuthor;
	}

	public void setThe_firstAuthor(String the_firstAuthor) {
		this.the_firstAuthor = the_firstAuthor;
	}

	public String getThe_otherAuthor() {
		return the_otherAuthor;
	}

	public void setThe_otherAuthor(String the_otherAuthor) {
		this.the_otherAuthor = the_otherAuthor;
	}

	public String getThe_title() {
		return the_title;
	}

	public void setThe_title(String the_title) {
		this.the_title = the_title;
	}

	public String getThe_periodical() {
		return the_periodical;
	}

	public void setThe_periodical(String the_periodical) {
		this.the_periodical = the_periodical;
	}

	public String getThe_reelNum() {
		return the_reelNum;
	}

	public void setThe_reelNum(String the_reelNum) {
		this.the_reelNum = the_reelNum;
	}

	public String getThe_issue() {
		return the_issue;
	}

	public void setThe_issue(String the_issue) {
		this.the_issue = the_issue;
	}

	public String getThe_scan() {
		return the_scan;
	}

	public void setThe_scan(String the_scan) {
		this.the_scan = the_scan;
	}

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}

	public BaseDict getThe_level() {
		return the_level;
	}

	public void setThe_level(BaseDict the_level) {
		this.the_level = the_level;
	}

	public Date getThe_pubTime() {
		return the_pubTime;
	}

	public void setThe_pubTime(Date the_pubTime) {
		this.the_pubTime = the_pubTime;
	}

	@Override
	public String toString() {
		return "Thesis [the_firstAuthor=" + the_firstAuthor + ", the_title="
				+ the_title + ", tea_id=" + tea_id + ", the_level=" + the_level
				+ "]";
	}

}
