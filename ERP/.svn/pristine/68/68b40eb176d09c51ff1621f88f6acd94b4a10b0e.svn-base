package com.ztkj.entity.purchase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 厂商表
 * @author Brayden
 *
 */
public class Firm {
	private Integer fiId;
	private String fiName;
	private String fiDirectorUserName;//负责人
	private String fiPhone;
	private String fiRealAddress;
	private String fiAddressProvince;
	private String fiAddressCity;
	private String  fiProvinceCity;//省市
	private Integer fiStatus;
	private Date fiCreatetime;
	private String fiDescribe;
	private Integer fiCreateUserid;
	private String fiCreateUserName;//创建人
	public Integer getFiId() {
		return fiId;
	}
	public void setFiId(Integer fiId) {
		this.fiId = fiId;
	}


	public String getFiName() {
		return fiName;
	}


	public void setFiName(String fiName) {
		this.fiName = fiName.trim();
	}


	/*
	 * public Integer getFiDirectorUserid() { return fiDirectorUserid; }
	 * 
	 * 
	 * public void setFiDirectorUserid(Integer fiDirectorUserid) {
	 * this.fiDirectorUserid = fiDirectorUserid; }
	 */


	public String getFiDirectorUserName() {
		return fiDirectorUserName;
	}


	public void setFiDirectorUserName(String fiDirectorUserName) {
		this.fiDirectorUserName = fiDirectorUserName.trim();
	}


	public String getFiPhone() {
		return fiPhone;
	}


	public void setFiPhone(String fiPhone) {
		this.fiPhone = fiPhone.trim();
	}


	public String getFiRealAddress() {
		return fiRealAddress;
	}


	public void setFiRealAddress(String fiRealAddress) {
		this.fiRealAddress = fiRealAddress.trim();
	}


	public String getFiAddressProvince() {
		return fiAddressProvince;
	}


	public void setFiAddressProvince(String fiAddressProvince) {
		this.fiAddressProvince = fiAddressProvince;
	}


	public String getFiAddressCity() {
		return fiAddressCity;
	}


	public void setFiAddressCity(String fiAddressCity) {
		this.fiAddressCity = fiAddressCity;
	}


	public String getFiProvinceCity() {
		return fiProvinceCity;
	}


	public void setFiProvinceCity(String fiProvinceCity) {
		this.fiProvinceCity = fiProvinceCity;
	}


	public Integer getFiStatus() {
		return fiStatus;
	}


	public void setFiStatus(Integer fiStatus) {
		this.fiStatus = fiStatus;
	}


	public Date getFiCreatetime() {
		return fiCreatetime;
	}


	public void setFiCreatetime(Date fiCreatetime) {
		this.fiCreatetime = fiCreatetime;
	}


	public String getFiDescribe() {
		return fiDescribe;
	}


	public void setFiDescribe(String fiDescribe) {
		this.fiDescribe = fiDescribe;
	}


	public Integer getFiCreateUserid() {
		return fiCreateUserid;
	}


	public void setFiCreateUserid(Integer fiCreateUserid) {
		this.fiCreateUserid = fiCreateUserid;
	}


	public String getFiCreateUserName() {
		return fiCreateUserName;
	}


	public void setFiCreateUserName(String fiCreateUserName) {
		this.fiCreateUserName = fiCreateUserName;
	}


	public String getTime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return fiCreatetime==null?"":format.format(fiCreatetime);
	}
	@Override
	public String toString() {
		return "Firm [fiId=" + fiId + ", fiName=" + fiName + ", fiDirectorUserName=" + fiDirectorUserName + ", fiPhone="
				+ fiPhone + ", fiRealAddress=" + fiRealAddress + ", fiAddressProvince=" + fiAddressProvince
				+ ", fiAddressCity=" + fiAddressCity + ", fiProvinceCity=" + fiProvinceCity + ", fiStatus=" + fiStatus
				+ ", fiCreatetime=" + fiCreatetime + ", fiDescribe=" + fiDescribe + ", fiCreateUserid=" + fiCreateUserid
				+ ", fiCreateUserName=" + fiCreateUserName + "]";
	}
	
}
