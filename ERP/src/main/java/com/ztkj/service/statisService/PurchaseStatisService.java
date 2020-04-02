package com.ztkj.service.statisService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.PurchaseStatis;

public interface PurchaseStatisService {
	
	public PageInfo<PurchaseStatis> queryPurchase(Integer pageNum,PurchaseStatis purchaseStatis) throws Exception;

}
