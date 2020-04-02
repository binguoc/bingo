package com.ztkj.service.purchaseService.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Firm;
import com.ztkj.mapper.purchaseMapper.FirmMapper;
import com.ztkj.service.purchaseService.FirmService;


@Service("firmService")
public class FirmServiceImpl implements FirmService{

	@Autowired
	private FirmMapper firmMapper;
	
	@Override
	public List<Province> queryAllProvince() throws Exception {
		// TODO Auto-generated method stub
		return firmMapper.queryAllProvince();
	}

	@Override
	public List<City> queryAllCityByProId(Province province) throws Exception {
		// TODO Auto-generated method stub
		return firmMapper.queryAllCityByProId(province);
	}

	@Override
	public PageInfo<Firm> queryAllFirmByPage(Firm firm,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize=3;
		PageHelper.startPage(pageNum, pageSize);
		List<Firm> list = firmMapper.queryAllFirmByPage(firm);
		PageInfo<Firm> pageInfo = new PageInfo<Firm>(list);
		return pageInfo;
	}

	@Override
	public Firm queryFirmById(Firm firm) throws Exception {
		// TODO Auto-generated method stub
		return firmMapper.queryFirmById(firm);
	}

	@Override
	public void updateFirm(Firm firm) throws Exception {
		// TODO Auto-generated method stub
		firmMapper.updateFirm(firm);
	}

	@Override
	public void addFirm(Firm firm) throws Exception {
		// TODO Auto-generated method stub
		firmMapper.addFirm(firm);
	}
	
}
