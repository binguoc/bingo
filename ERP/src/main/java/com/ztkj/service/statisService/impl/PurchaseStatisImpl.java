package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.PurchaseStatis;
import com.ztkj.mapper.statisMapper.PurchaseStatisMapper;
import com.ztkj.service.statisService.PurchaseStatisService;

@Service("purchaseStatisService")
@Transactional
public class PurchaseStatisImpl implements PurchaseStatisService {

	@Autowired
	private PurchaseStatisMapper purchaseStatisMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<PurchaseStatis> queryPurchase(Integer pageNum, PurchaseStatis purchaseStatis) throws Exception {
		// TODO Auto-generated method stub
		pageNum = pageNum==null ? 1:pageNum;
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<PurchaseStatis> list = purchaseStatisMapper.queryPurchase(purchaseStatis);
		PageInfo<PurchaseStatis> pageInfo = new PageInfo<PurchaseStatis>(list);
		return pageInfo;
	}

}
