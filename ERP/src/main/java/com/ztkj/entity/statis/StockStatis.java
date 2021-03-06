package com.ztkj.entity.statis;

public class StockStatis {
	
	private String f_kName;
	private String f_fzName;
	private String pro_name;
	private String city_name;
	private Double f_count;
	private Double f_money;
	private String startTime;
	private String endTime;
	private String pro_id;
	private String city_id;
	public String getF_kName() {
		return f_kName;
	}
	public void setF_kName(String f_kName) {
		this.f_kName = f_kName.trim();
	}
	public String getF_fzName() {
		return f_fzName;
	}
	public void setF_fzName(String f_fzName) {
		this.f_fzName = f_fzName;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Double getF_count() {
		return f_count;
	}
	public void setF_count(Double f_count) {
		this.f_count = f_count;
	}
	
	public Double getF_money() {
		return f_money;
	}
	public void setF_money(Double f_money) {
		this.f_money = f_money;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	@Override
	public String toString() {
		return "StockStatis [f_kName=" + f_kName + ", f_fzName=" + f_fzName + ", pro_name=" + pro_name + ", city_name="
				+ city_name + ", f_count=" + f_count + ", f_money=" + f_money + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", pro_id=" + pro_id + ", city_id=" + city_id + "]";
	}
	
	

}
