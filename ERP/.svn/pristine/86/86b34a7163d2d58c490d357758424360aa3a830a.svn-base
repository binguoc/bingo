package com.ztkj.entity.market;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.ztkj.entity.sys.User;

public class Order {
	private int f_id;
	private String f_did;
	private Client client;
	private String f_company;
	private User f_dpeople;
	private char f_status;
	private User f_auditor;
	private Date f_date;
	private Double f_Moneysum;
	private String f_view;
	private String startDate;
	private String emdDate;
	private Double minMoney;
	private Double maxMoney;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_did() {
		return f_did;
	}
	public void setF_did(String f_did) {
		this.f_did = f_did.trim();
	}
	public String getF_company() {
		return f_company;
	}
	public void setF_company(String f_company) {
		this.f_company = f_company;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public User getF_dpeople() {
		return f_dpeople;
	}
	public void setF_dpeople(User f_dpeople) {
		this.f_dpeople = f_dpeople;
	}
	public char getF_status() {
		return f_status;
	}
	public void setF_status(char f_status) {
		this.f_status = f_status;
	}
	public User getF_auditor() {
		return f_auditor;
	}
	public void setF_auditor(User f_auditor) {
		this.f_auditor = f_auditor;
	}
	public Date getF_date() {
		return f_date;
	}
	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}
	public String getTime() {//time  定义方法获取对应格式的日期数据
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return f_date==null?"":format.format(f_date);
	}
	public Double getF_Moneysum() {
		return f_Moneysum;
	}
	public void setF_Moneysum(Double f_Moneysum) {
		this.f_Moneysum = f_Moneysum;
	}
	public String getF_view() {
		return f_view;
	}
	public void setF_view(String f_view) {
		this.f_view = f_view;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEmdDate() {
		return emdDate;
	}
	public void setEmdDate(String emdDate) {
		this.emdDate = emdDate;
	}
	public Double getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(Double minMoney) {
		this.minMoney = minMoney;
	}
	public Double getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(Double maxMoney) {
		this.maxMoney = maxMoney;
	}
	@Override
	public String toString() {
		return "Order [f_id=" + f_id + ", f_did=" + f_did + ", client=" + client + ", f_company=" + f_company
				+ ", f_dpeople=" + f_dpeople + ", f_status=" + f_status + ", f_auditor=" + f_auditor + ", f_date="
				+ f_date + ", f_Moneysum=" + f_Moneysum + ", f_view=" + f_view + ", startDate=" + startDate
				+ ", emdDate=" + emdDate + ", minMoney=" + minMoney + ", maxMoney=" + maxMoney + "]";
	}
	
}
