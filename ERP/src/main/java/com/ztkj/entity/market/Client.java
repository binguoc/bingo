package com.ztkj.entity.market;

import java.sql.Date;

import com.ztkj.entity.sys.User;

public class Client {
	private int f_id;
	private String f_name;
	private char F_sex;
	private String f_tel;
	private String F_address;
	private String F_view;
	private String F_company;
	private City F_city;
	private char F_status;
	private char F_isallot;
	private Date F_credate;
	private String F_creater;
	private Date F_allotdate;
	private User F_service;
	private String ss;
	private String ssid;
	
	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name.trim();
	}

	public char getF_sex() {
		return F_sex;
	}

	public void setF_sex(char f_sex) {
		F_sex = f_sex;
	}

	public String getF_tel() {
		return f_tel;
	}

	public void setF_tel(String f_tel) {
		this.f_tel = f_tel;
	}

	public String getF_address() {
		return F_address;
	}

	public void setF_address(String f_address) {
		F_address = f_address;
	}

	public String getF_view() {
		return F_view;
	}

	public void setF_view(String f_view) {
		F_view = f_view;
	}

	public String getF_company() {
		return F_company;
	}

	public void setF_company(String f_company) {
		F_company = f_company.trim();
	}

	public City getF_city() {
		return F_city;
	}

	public void setF_city(City f_city) {
		F_city = f_city;
	}

	public char getF_status() {
		return F_status;
	}

	public void setF_status(char f_status) {
		F_status = f_status;
	}

	public char getF_isallot() {
		return F_isallot;
	}

	public void setF_isallot(char f_isallot) {
		F_isallot = f_isallot;
	}

	public Date getF_credate() {
		return F_credate;
	}

	public void setF_credate(Date f_credate) {
		F_credate = f_credate;
	}

	public String getF_creater() {
		return F_creater;
	}

	public void setF_creater(String f_creater) {
		F_creater = f_creater;
	}

	public Date getF_allotdate() {
		return F_allotdate;
	}

	public void setF_allotdate(Date f_allotdate) {
		F_allotdate = f_allotdate;
	}

	public User getF_service() {
		return F_service;
	}

	public void setF_service(User f_service) {
		F_service = f_service;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}
	
	
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	@Override
	public String toString() {
		return "Client [f_id=" + f_id + ", f_name=" + f_name + ", F_sex=" + F_sex + ", f_tel=" + f_tel + ", F_address="
				+ F_address + ", F_view=" + F_view + ", F_company=" + F_company + ", F_city=" + F_city + ", F_status="
				+ F_status + ", F_isallot=" + F_isallot + ", F_credate=" + F_credate + ", F_creater=" + F_creater
				+ ", F_allotdate=" + F_allotdate + ", F_service=" + F_service + ", ss=" + ss + ", ssid=" + ssid + "]";
	}
	

	
}
