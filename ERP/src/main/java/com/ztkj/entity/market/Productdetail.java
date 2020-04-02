package com.ztkj.entity.market;

import com.ztkj.entity.purchase.Firm;
import com.ztkj.entity.purchase.Wares;

public class Productdetail {
	private Integer f_id;
	private Order order;
	private Wares wares;
	private Firm firm;
	private String f_status;
	private Double f_auditor;
	private Double f_count;
	private Double f_Money;
	private String logo;
	private Integer logoid;
	private String type;
	private Integer typeid;
	
	
	
	private Integer stId;
	
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	
	public Integer getLogoid() {
		return logoid;
	}
	public void setLogoid(Integer logoid) {
		this.logoid = logoid;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Wares getWares() {
		return wares;
	}
	public void setWares(Wares wares) {
		this.wares = wares;
	}
	public Firm getFirm() {
		return firm;
	}
	public void setFirm(Firm firm) {
		this.firm = firm;
	}
	
	public String getF_status() {
		return f_status;
	}
	public void setF_status(String f_status) {
		this.f_status = f_status;
	}
	public Double getF_auditor() {
		return f_auditor;
	}
	public void setF_auditor(Double f_auditor) {
		this.f_auditor = f_auditor;
	}
	public Double getF_count() {
		return f_count;
	}
	public void setF_count(Double f_count) {
		this.f_count = f_count;
	}
	public Double getF_Money() {
		return f_Money;
	}
	public void setF_Money(Double f_Money) {
		this.f_Money = f_Money;
	}
	@Override
	public String toString() {
		return "Productdetail [f_id=" + f_id + ", order=" + order + ", wares=" + wares + ", firm=" + firm
				+ ", f_status=" + f_status + ", f_auditor=" + f_auditor + ", f_count=" + f_count + ", f_Money="
				+ f_Money + ", logo=" + logo + ", logoid=" + logoid + ", type=" + type + ", typeid=" + typeid + "]";
	}
	
	
	
	
}
