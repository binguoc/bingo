package com.ztkj.service.statisService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.DeliveryView;

public interface DeliveryViewService {
	
	public PageInfo<DeliveryView> queryDeliveryView(Integer pageNum,DeliveryView deliveryView) throws Exception;

}
