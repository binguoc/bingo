package com.ztkj.entity.sys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private Integer f_z;
	private Integer f_id;
	private String f_name;
	private String f_password;
	private String f_tel;
	private Position f_positionid;
	private Date f_birthday;
	private String f_status;
	private Date f_jointime;
	private Date f_leavetime;
	private String f_sex;
	
	
	
	public Position getF_positionid() {
		return f_positionid;
	}
	public void setF_positionid(Position f_positionid) {
		this.f_positionid = f_positionid;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name.trim();
	}
	public String getF_password() {
		return f_password;
	}
	public void setF_password(String f_password) {
		this.f_password = f_password;
	}
	public String getF_tel() {
		return f_tel;
	}
	public void setF_tel(String f_tel) {
		this.f_tel = f_tel;
	}
	
	public Date getF_birthday() {
		return f_birthday;
	}
	public void setF_birthday(Date f_birthday) {
		this.f_birthday = f_birthday;
	}
	public String getBirthdaytime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f_birthday==null?"":format.format(f_birthday);
	}
	public String getF_status() {
		return f_status;
	}
	public void setF_status(String f_status) {
		this.f_status = f_status;
	}
	public Date getF_jointime() {
		return f_jointime;
	}
	public void setF_jointime(Date f_jointime) {
		this.f_jointime = f_jointime;
	}
	public String getjointimetime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f_jointime==null?"":format.format(f_jointime);
	}
	public Date getF_leavetime() {
		return f_leavetime;
	}
	public void setF_leavetime(Date f_leavetime) {
		this.f_leavetime = f_leavetime;
	}
	public String getleavetimetime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f_leavetime==null?"":format.format(f_leavetime);
	}
	public String getF_sex() {
		return f_sex;
	}
	public void setF_sex(String f_sex) {
		this.f_sex = f_sex;
	}
	public Integer getF_z() {
		return f_z;
	}
	public void setF_z(Integer f_z) {
		this.f_z = f_z;
	}
	@Override
	public String toString() {
		return "User [f_id=" + f_id + ", f_name=" + f_name + ", f_password=" + f_password + ", f_tel=" + f_tel
				+ ", f_positionid=" + f_positionid + ", f_birthday=" + f_birthday + ", f_status=" + f_status
				+ ", f_jointime=" + f_jointime + ", f_leavetime=" + f_leavetime + ", f_sex=" + f_sex + ", f_z=" + f_z
				+ "]";
	}

	
}
