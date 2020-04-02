package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.DeliveryView;
import com.ztkj.mapper.statisMapper.DeliveryViewMapper;
import com.ztkj.service.statisService.DeliveryViewService;


@Service("deliveryViewService")
@Transactional
public class DeliveryViewServiceImpl implements DeliveryViewService {

	@Autowired
	private DeliveryViewMapper deliveryViewMapper;
	
	@Override
	public PageInfo<DeliveryView> queryDeliveryView(Integer pageNum, DeliveryView deliveryView) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<DeliveryView> list = deliveryViewMapper.queryDeliveryView(deliveryView);
		PageInfo<DeliveryView> pageInfo = new PageInfo<DeliveryView>(list);
		return pageInfo;
	}

}
