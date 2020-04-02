package com.ztkj.entity.purchase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Wares {
	private Integer waId;
	private Integer  waBrandid;
	private String brName;
	private Integer waWarestypeid;
	private String warestypeName;
	private String waName;
	private Date waCreatetime;
	private String waUnit;
	private Integer waStatus;
	private Integer waEmpid;
	private String empName;
	
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName.trim();
	}
	public String getWarestypeName() {
		return warestypeName;
	}
	public void setWarestypeName(String warestypeName) {
		this.warestypeName = warestypeName.trim();
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
	public Integer getWaBrandid() {
		return waBrandid;
	}
	public void setWaBrandid(Integer waBrandid) {
		this.waBrandid = waBrandid;
	}
	public Integer getWaWarestypeid() {
		return waWarestypeid;
	}
	public void setWaWarestypeid(Integer waWarestypeid) {
		this.waWarestypeid = waWarestypeid;
	}
	public String getWaName() {
		return waName;
	}
	public void setWaName(String waName) {
		this.waName = waName;
	}
	public Date getWaCreatetime() {
		return waCreatetime;
	}
	public void setWaCreatetime(Date waCreatetime) {
		this.waCreatetime = waCreatetime;
	}
	public String getWaUnit() {
		return waUnit;
	}
	public void setWaUnit(String waUnit) {
		this.waUnit = waUnit.trim();
	}
	public Integer getWaStatus() {
		return waStatus;
	}
	public void setWaStatus(Integer waStatus) {
		this.waStatus = waStatus;
	}
	public Integer getWaEmpid() {
		return waEmpid;
	}
	public void setWaEmpid(Integer waEmpid) {
		this.waEmpid = waEmpid;
	}
	
	public String getTime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return waCreatetime==null?"":format.format(waCreatetime);
	}
	
	@Override
	public String toString() {
		return "Wares [waId=" + waId + ", waBrandid=" + waBrandid + ", waWarestypeid=" + waWarestypeid + ", waName="
				+ waName + ", waCreatetime=" + waCreatetime + ", waUnit=" + waUnit + ", waStatus=" + waStatus
				+ ", waEmpid=" + waEmpid + "]";
	}
}
