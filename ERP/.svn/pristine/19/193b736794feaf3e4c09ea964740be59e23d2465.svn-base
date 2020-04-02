package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.StockStatis;
import com.ztkj.mapper.statisMapper.StockStatisMapper;
import com.ztkj.service.statisService.StockStatisService;

@Service("stockStatisService")
@Transactional
public class StockStatisServiceImpl implements StockStatisService {

	@Autowired
	private StockStatisMapper stockStatisMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<StockStatis> queryStockStatis(Integer pageNum, StockStatis stockStatis) throws Exception {
		// TODO Auto-generated method stub
		pageNum = pageNum==null ? 1:pageNum;
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<StockStatis> list = stockStatisMapper.queryStockStatis(stockStatis);
		PageInfo<StockStatis> pageInfo = new PageInfo<StockStatis>(list);
		return pageInfo;
	}

}
