package com.ztkj.entity.purchase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Warestype {
	private Integer waId;
	private Integer brandid;
	private String brName;
	private String waName;
	private Date waCreatetime;
	private Integer waStatus;
	private Integer empId;
	private String empName;
	
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName.trim();
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getWaId() {
		return waId;
	}
	public void setWaId(Integer waId) {
		this.waId = waId;
	}
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	public String getWaName() {
		return waName;
	}
	public void setWaName(String waName) {
		this.waName = waName.trim();
	}
	public Date getWaCreatetime() {
		return waCreatetime;
	}
	public void setWaCreatetime(Date waCreatetime) {
		this.waCreatetime = waCreatetime;
	}
	public Integer getWaStatus() {
		return waStatus;
	}
	public void setWaStatus(Integer waStatus) {
		this.waStatus = waStatus;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getTime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return waCreatetime==null?"":format.format(waCreatetime);
	}
	@Override
	public String toString() {
		return "Warestype [waId=" + waId + ", brandid=" + brandid + ", brName=" + brName + ", waName=" + waName
				+ ", waCreatetime=" + waCreatetime + ", waStatus=" + waStatus + ", empId=" + empId + ", empName="
				+ empName + "]";
	}
	
}
