package com.ztkj.service.purchaseService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Warestype;
import com.ztkj.mapper.purchaseMapper.WarestypeMapper;
import com.ztkj.service.purchaseService.WarestypeService;

@Service("warestypeService")
public class WarestypeServiceImpl implements WarestypeService {

	@Autowired
	private WarestypeMapper warestypeMapper;
	
	@Override
	public List<Brand> queryAllBrands() throws Exception {
		// TODO Auto-generated method stub
		return warestypeMapper.queryAllBrands();
	}

	@Override
	public PageInfo<Warestype> queryWarestypeByPage(Warestype warestype,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 3;
		PageHelper.startPage(pageNum, pageSize);
		List<Warestype> list = warestypeMapper.queryWarestypeByPage(warestype);
		PageInfo<Warestype> pageInfo = new PageInfo<Warestype>(list);
		return pageInfo;
	}

	@Override
	public Warestype queryWarestypeById(Warestype warestype) throws Exception {
		// TODO Auto-generated method stub
		return warestypeMapper.queryWarestypeById(warestype);
	}

	@Override
	public void updateWarestype(Warestype warestype) throws Exception {
		// TODO Auto-generated method stub
		warestypeMapper.updateWarestype(warestype);
	}

	@Override
	public void addWarestype(Warestype warestype) throws Exception {
		// TODO Auto-generated method stub
		warestypeMapper.addWarestype(warestype);
	}
}
