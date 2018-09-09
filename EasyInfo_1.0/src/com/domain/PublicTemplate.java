package com.domain;

public class PublicTemplate {
	private Integer pub_tem_id;
	private String pub_tem_name;
	private String pub_tem_describe;
	private String pub_tem_url;
	private String pub_tem_img;

	public Integer getPub_tem_id() {
		return pub_tem_id;
	}

	public void setPub_tem_id(Integer pub_tem_id) {
		this.pub_tem_id = pub_tem_id;
	}

	public String getPub_tem_name() {
		return pub_tem_name;
	}

	@Override
	public String toString() {
		return "PublicTemplate [pub_tem_id=" + pub_tem_id + ", pub_tem_name="
				+ pub_tem_name + ", pub_tem_describe=" + pub_tem_describe
				+ ", pub_tem_url=" + pub_tem_url + ", pub_tem_img="
				+ pub_tem_img + "]";
	}

	public void setPub_tem_name(String pub_tem_name) {
		this.pub_tem_name = pub_tem_name;
	}

	public String getPub_tem_describe() {
		return pub_tem_describe;
	}

	public void setPub_tem_describe(String pub_tem_describe) {
		this.pub_tem_describe = pub_tem_describe;
	}

	public String getPub_tem_url() {
		return pub_tem_url;
	}

	public void setPub_tem_url(String pub_tem_url) {
		this.pub_tem_url = pub_tem_url;
	}

	public String getPub_tem_img() {
		return pub_tem_img;
	}

	public void setPub_tem_img(String pub_tem_img) {
		this.pub_tem_img = pub_tem_img;
	}

}
