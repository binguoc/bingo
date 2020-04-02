package com.ztkj.entity.statis;

import java.util.Date;

public class StockView {
	
	private String f_kName;
	private String f_did;
	private Double f_count;
	private Double f_money;
	private Date f_time;
	private String f_rkName;
	public String getF_kName() {
		return f_kName;
	}
	public void setF_kName(String f_kName) {
		this.f_kName = f_kName;
	}
	public String getF_did() {
		return f_did;
	}
	public void setF_did(String f_did) {
		this.f_did = f_did;
	}
	public Double getF_count() {
		return f_count;
	}
	public void setF_count(Double f_count) {
		this.f_count = f_count;
	}
	public Date getF_time() {
		return f_time;
	}
	public void setF_time(Date f_time) {
		this.f_time = f_time;
	}
	public Double getF_money() {
		return f_money;
	}
	public void setF_money(Double f_money) {
		this.f_money = f_money;
	}
	public String getF_rkName() {
		return f_rkName;
	}
	public void setF_rkName(String f_rkName) {
		this.f_rkName = f_rkName;
	}
	@Override
	public String toString() {
		return "StockView [f_kName=" + f_kName + ", f_did=" + f_did + ", f_count=" + f_count + ", f_money=" + f_money
				+ ", f_time=" + f_time + ", f_rkName=" + f_rkName + "]";
	}
	

}
