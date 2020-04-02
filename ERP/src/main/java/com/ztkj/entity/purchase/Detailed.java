package com.ztkj.entity.purchase;

/**
 * 采购明细表
 * @author Brayden
 *
 */
public class Detailed {
	private Integer deId;//采购明细编号
	private Integer deMonovalent;//商品单价
	private Integer deCount;//采购数量
	private Integer deMoney;//单行采购金额
	private String deBrname;//品牌名称
	private String deTypename;//类型名称
	private String deWaname;//型号名称
	private String deFiname;//厂商名称
	private String deWaUnit;//商品单位
	private String puId;//采购单编号
	private Integer deBrid;
	private Integer deTypeid;
	private Integer deWaid;
	private Integer deFiid;
	
	public Integer getDeBrid() {
		return deBrid;
	}

	public void setDeBrid(Integer deBrid) {
		this.deBrid = deBrid;
	}

	public Integer getDeTypeid() {
		return deTypeid;
	}

	public void setDeTypeid(Integer deTypeid) {
		this.deTypeid = deTypeid;
	}

	public Integer getDeWaid() {
		return deWaid;
	}

	public void setDeWaid(Integer deWaid) {
		this.deWaid = deWaid;
	}

	public Integer getDeFiid() {
		return deFiid;
	}

	public void setDeFiid(Integer deFiid) {
		this.deFiid = deFiid;
	}

	private String firmid;
	private String waresid;

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid;
	}

	public String getWaresid() {
		return waresid;
	}

	public void setWaresid(String waresid) {
		this.waresid = waresid;
	}
	


	
	
	
	
	
	
	

	public String getPuId() {
		return puId;
	}

	public void setPuId(String puId) {
		this.puId = puId;
	}

	public String getDeBrname() {
		return deBrname;
	}

	public void setDeBrname(String deBrname) {
		this.deBrname = deBrname;
	}

	public String getDeTypename() {
		return deTypename;
	}

	public void setDeTypename(String deTypename) {
		this.deTypename = deTypename;
	}

	public String getDeWaname() {
		return deWaname;
	}

	public void setDeWaname(String deWaname) {
		this.deWaname = deWaname;
	}

	public String getDeFiname() {
		return deFiname;
	}

	public void setDeFiname(String deFiname) {
		this.deFiname = deFiname;
	}

	public String getDeWaUnit() {
		return deWaUnit;
	}

	public void setDeWaUnit(String deWaUnit) {
		this.deWaUnit = deWaUnit;
	}

	public Integer getDeId() {
		return deId;
	}

	public void setDeId(Integer deId) {
		this.deId = deId;
	}


	public Integer getDeMonovalent() {
		return deMonovalent;
	}


	public void setDeMonovalent(Integer deMonovalent) {
		this.deMonovalent = deMonovalent;
	}


	public Integer getDeCount() {
		return deCount;
	}


	public void setDeCount(Integer deCount) {
		this.deCount = deCount;
	}


	public Integer getDeMoney() {
		return deMoney;
	}


	public void setDeMoney(Integer deMoney) {
		this.deMoney = deMoney;
	}

	@Override
	public String toString() {
		return "Detailed [deId=" + deId + ", deMonovalent=" + deMonovalent + ", deCount=" + deCount + ", deMoney="
				+ deMoney + ", deBrname=" + deBrname + ", deTypename=" + deTypename + ", deWaname=" + deWaname
				+ ", deFiname=" + deFiname + ", deWaUnit=" + deWaUnit + ", puId=" + puId + ", deBrid=" + deBrid
				+ ", deTypeid=" + deTypeid + ", deWaid=" + deWaid + ", deFiid=" + deFiid + ", firmid=" + firmid
				+ ", waresid=" + waresid + "]";
	}

	

	
}
