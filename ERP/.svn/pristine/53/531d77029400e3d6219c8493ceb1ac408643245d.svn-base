package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.StockView;
import com.ztkj.mapper.statisMapper.StockViewMapper;
import com.ztkj.service.statisService.StockViewService;

@Service("stockViewService")
@Transactional
public class StockViewServiceImpl implements StockViewService {

	@Autowired
	private StockViewMapper stockViewMapper;
	
	@Override
	public PageInfo<StockView> queryStockView(Integer pageNum, StockView stockView) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<StockView> list = stockViewMapper.queryStockView(stockView);
		PageInfo<StockView> pageInfo = new PageInfo<StockView>(list);
		return pageInfo;
	}

}
