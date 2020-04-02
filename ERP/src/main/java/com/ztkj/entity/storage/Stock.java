package com.ztkj.entity.storage;

import java.util.Date;

import com.ztkj.entity.purchase.Purchase;

/**
 * Stock 入库表
 * @author binguo
 * 2019年11月30日下午2:53:29
 */
public class Stock {

	private Integer stoId;
	private Date stoTime;
	private String stoMan;
	private Integer stoStatic;
	
	private Storage storage;  //入库表 与 仓库表   1:1
	private Purchase purchase;  //入库表 与 采购表  1：N
	
	private String stCreateMan;//仓库创建人
	public String getStCreateMan() {
		return stCreateMan;
	}
	public void setStCreateMan(String stCreateMan) {
		this.stCreateMan = stCreateMan;
	}
	
	
	
	
	public Integer getStoId() {
		return stoId;
	}
	public void setStoId(Integer stoId) {
		this.stoId = stoId;
	}
	public Date getStoTime() {
		return stoTime;
	}
	public void setStoTime(Date stoTime) {
		this.stoTime = stoTime;
	}
	public String getStoMan() {
		return stoMan;
	}
	public void setStoMan(String stoMan) {
		this.stoMan = stoMan;
	}
	public Integer getStoStatic() {
		return stoStatic;
	}
	public void setStoStatic(Integer stoStatic) {
		this.stoStatic = stoStatic;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	@Override
	public String toString() {
		return "Stock [stoId=" + stoId + ", stoTime=" + stoTime + ", stoMan=" + stoMan + ", stoStatic=" + stoStatic
				+ ", storage=" + storage + ", purchase=" + purchase + "]";
	}

	

}
