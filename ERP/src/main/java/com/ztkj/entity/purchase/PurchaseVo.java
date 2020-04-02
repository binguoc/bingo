package com.ztkj.entity.purchase;

import java.util.Date;

public class PurchaseVo {
	private String id;//采购单编号
	private Date startTime;//初始时间
	private Date endTime;//结束时间
	private Integer startMoney;//开始金额
	private Integer endMoney;//结束金额
	private Integer status;//状态
	private Integer pageNum;//当前页
	public Integer getPageNum() {
		return pageNum = pageNum==null?1:pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getStartMoney() {
		return startMoney;
	}
	public void setStartMoney(Integer startMoney) {
		this.startMoney = startMoney;
	}
	public Integer getEndMoney() {
		return endMoney;
	}
	public void setEndMoney(Integer endMoney) {
		this.endMoney = endMoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PurchaseVo [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", startMoney="
				+ startMoney + ", endMoney=" + endMoney + ", status=" + status + ", pageNum=" + pageNum + "]";
	}
	
	
}
