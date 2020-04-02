package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.PurchaseViewStatis;
import com.ztkj.mapper.statisMapper.PurchaseViewStatisMapper;
import com.ztkj.service.statisService.PurchaseViewStatisService;

@Service("purchaseViewStatisService")
@Transactional
public class PurchaseViewStatisServiceImpl implements PurchaseViewStatisService {
	
	@Autowired
	private PurchaseViewStatisMapper purchaseViewStatisMapper;

	@Override
	public PageInfo<PurchaseViewStatis> queryPurchaseView(Integer pageNum, PurchaseViewStatis purchaseViewStatis)
			throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<PurchaseViewStatis> list = purchaseViewStatisMapper.queryPurchaseView(purchaseViewStatis);
		PageInfo<PurchaseViewStatis> pageInfo = new PageInfo<PurchaseViewStatis>(list);
		return pageInfo;
	}
	
}
