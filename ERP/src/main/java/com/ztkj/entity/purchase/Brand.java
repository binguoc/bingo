package com.ztkj.entity.purchase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Brand {
	private Integer brId;
	private String brName;
	private Date brCreatetime;
	private Integer brStatus;
	private Integer brEmpid;
	private String empName;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getBrId() {
		return brId;
	}
	public void setBrId(Integer brId) {
		this.brId = brId;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName.trim();
	}
	public Date getBrCreatetime() {
		return brCreatetime;
	}
	public void setBrCreatetime(Date brCreatetime) {
		this.brCreatetime = brCreatetime;
	}
	public Integer getBrStatus() {
		return brStatus;
	}
	public void setBrStatus(Integer brStatus) {
		this.brStatus = brStatus;
	}
	public Integer getBrEmpid() {
		return brEmpid;
	}
	public void setBrEmpid(Integer brEmpid) {
		this.brEmpid = brEmpid;
	}
	public String getTime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return brCreatetime==null?"":format.format(brCreatetime);
	}
	@Override
	public String toString() {
		return "Brand [brId=" + brId + ", brName=" + brName + ", brCreatetime=" + brCreatetime + ", brStatus="
				+ brStatus + ", brEmpid=" + brEmpid + ", empName=" + empName + "]";
	}
	
	
}
