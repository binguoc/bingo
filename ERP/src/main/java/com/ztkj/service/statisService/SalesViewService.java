package com.ztkj.service.statisService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.SalesView;

public interface SalesViewService {
	
	public PageInfo<SalesView> querySalesView(Integer pageNum,SalesView salesView) throws Exception;

}
