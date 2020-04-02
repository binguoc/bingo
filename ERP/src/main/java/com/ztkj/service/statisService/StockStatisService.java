package com.ztkj.service.statisService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.StockStatis;

public interface StockStatisService {
	
	public PageInfo<StockStatis> queryStockStatis(Integer pageNum,StockStatis stockStatis) throws Exception;

}
