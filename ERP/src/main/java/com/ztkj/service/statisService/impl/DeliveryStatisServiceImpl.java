package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.DeliveryStatis;
import com.ztkj.mapper.statisMapper.DeliveryStatisMapper;
import com.ztkj.service.statisService.DeliveryStatisService;

@Service("deliveryStatisService")
@Transactional
public class DeliveryStatisServiceImpl implements DeliveryStatisService {

	@Autowired
	private DeliveryStatisMapper deliveryStatisMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<DeliveryStatis> queryDeliveryStatis(Integer pageNum, DeliveryStatis deliveryStatis)
			throws Exception {
		// TODO Auto-generated method stub
		pageNum = pageNum==null ? 1:pageNum;
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<DeliveryStatis> list = deliveryStatisMapper.queryDeliveryStatis(deliveryStatis);
		PageInfo<DeliveryStatis> pageInfo = new PageInfo<DeliveryStatis>(list);
		return pageInfo;
	}

}
