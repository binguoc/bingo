package com.ztkj.entity.storage;

import java.util.Date;

import com.ztkj.entity.market.Order;

/**
 * delivery 出库表的实体类
 * @author binguo
 * 2019年11月30日下午2:40:27
 */
public class Delivery {

	private Integer deId;   //出库id
	private Date deTime;	//出库时间
	private String deMan;	//出库人
	private Integer deStatic;	//出库状态
	
	private Order order;  //出库表与订单表    1：1
	private Storage storage;  //出库表 与 仓库表   N:1
	
	
	private String stCreateMan;//仓库创建人
	public String getStCreateMan() {
		return stCreateMan;
	}
	public void setStCreateMan(String stCreateMan) {
		this.stCreateMan = stCreateMan;
	}
	
	public Integer getDeId() {
		return deId;
	}
	public void setDeId(Integer deId) {
		this.deId = deId;
	}
	public Date getDeTime() {
		return deTime;
	}
	public void setDeTime(Date deTime) {
		this.deTime = deTime;
	}
	public String getDeMan() {
		return deMan;
	}
	public void setDeMan(String deMan) {
		this.deMan = deMan;
	}
	public Integer getDeStatic() {
		return deStatic;
	}
	public void setDeStatic(Integer deStatic) {
		this.deStatic = deStatic;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	@Override
	public String toString() {
		return "Delivery [deId=" + deId + ", deTime=" + deTime + ", deMan=" + deMan + ", deStatic=" + deStatic
				+ ", order=" + order + ", storage=" + storage + "]";
	}
	
	
	

}
