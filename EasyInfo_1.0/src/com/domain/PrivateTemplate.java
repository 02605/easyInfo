package com.domain;

public class PrivateTemplate {
	private Integer pri_tem_id;
	private Teacher tea_id;
	private String pri_tem_name;
	private String pri_tem_describe;
	private String pri_tem_url;
	private String pri_tem_img;

	public String getPri_tem_url() {
		return pri_tem_url;
	}

	public void setPri_tem_url(String pri_tem_url) {
		this.pri_tem_url = pri_tem_url;
	}

	public Integer getPri_tem_id() {
		return pri_tem_id;
	}

	public void setPri_tem_id(Integer pri_tem_id) {
		this.pri_tem_id = pri_tem_id;
	}

	public Teacher getTea_id() {
		return tea_id;
	}

	public void setTea_id(Teacher tea_id) {
		this.tea_id = tea_id;
	}

	public String getPri_tem_name() {
		return pri_tem_name;
	}

	public void setPri_tem_name(String pri_tem_name) {
		this.pri_tem_name = pri_tem_name;
	}

	public String getPri_tem_describe() {
		return pri_tem_describe;
	}

	public void setPri_tem_describe(String pri_tem_describe) {
		this.pri_tem_describe = pri_tem_describe;
	}

	public String getPri_tem_img() {
		return pri_tem_img;
	}

	public void setPri_tem_img(String pri_tem_img) {
		this.pri_tem_img = pri_tem_img;
	}

	@Override
	public String toString() {
		return "privateTemplate [tea_id=" + tea_id + ", pri_tem_name="
				+ pri_tem_name + ", pri_tem_describe=" + pri_tem_describe
				+ ", pri_tem_url=" + pri_tem_url + ", pri_tem_img="
				+ pri_tem_img + ", pri_tem_id=" + pri_tem_id + "]";
	}

}
