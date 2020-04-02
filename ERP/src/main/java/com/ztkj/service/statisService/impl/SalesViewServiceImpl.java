package com.ztkj.service.statisService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.SalesView;
import com.ztkj.mapper.statisMapper.SalesViewMapper;
import com.ztkj.service.statisService.SalesViewService;

@Service("salesViewService")
@Transactional
public class SalesViewServiceImpl implements SalesViewService {

	@Autowired
	private SalesViewMapper salesViewMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<SalesView> querySalesView(Integer pageNum,SalesView salesView) throws Exception {
		// TODO Auto-generated method stub
		
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<SalesView> list = salesViewMapper.querySalesView(salesView);
		PageInfo<SalesView> pageInfo = new PageInfo<SalesView>(list);
		return pageInfo;
	}

}
