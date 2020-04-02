package com.ztkj.service.statisService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.PurchaseViewStatis;

public interface PurchaseViewStatisService {
	
	public PageInfo<PurchaseViewStatis> queryPurchaseView(Integer pageNum,PurchaseViewStatis purchaseViewStatis) throws Exception;

}
