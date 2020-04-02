package com.ztkj.service.sysService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.mapper.sysMapper.CityMapper;
import com.ztkj.service.sysService.CityService;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityMapper cityMapper;

	@Override
	@Transactional(readOnly=true)
	public PageInfo<City> selectAllCity(Integer pageNum,City city) throws Exception {
		// TODO Auto-generated method stub
		pageNum = pageNum==null ? 1:pageNum;
		Integer pageSize = 5;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<City> list = cityMapper.selectAllCity(city);
		PageInfo<City> pageInfo = new PageInfo<City>(list);
		return pageInfo;
	}

}
