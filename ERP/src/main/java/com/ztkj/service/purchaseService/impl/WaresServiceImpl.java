package com.ztkj.service.purchaseService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Wares;
import com.ztkj.entity.purchase.Warestype;
import com.ztkj.mapper.purchaseMapper.WaresMapper;
import com.ztkj.mapper.purchaseMapper.WarestypeMapper;
import com.ztkj.service.purchaseService.WaresService;
import com.ztkj.service.purchaseService.WarestypeService;

@Service("waresService")
public class WaresServiceImpl implements WaresService {

	@Autowired
	private WaresMapper waresMapper;
	
	@Override
	public List<Brand> queryAllBrands() throws Exception {
		// TODO Auto-generated method stub
		return waresMapper.queryAllBrandsWares();
	}

	@Override
	public PageInfo<Wares> queryWaresByPage(Wares wares,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 3;
		PageHelper.startPage(pageNum, pageSize);
		List<Wares> list = waresMapper.queryWaresByPage(wares);
		PageInfo<Wares> pageInfo = new PageInfo<Wares>(list);
		return pageInfo;
	}

	@Override
	public Wares queryWaresById(Wares wares) throws Exception {
		// TODO Auto-generated method stub
		return waresMapper.queryWaresById(wares);
	}

	@Override
	public void updateWares(Wares wares) throws Exception {
		// TODO Auto-generated method stub
		waresMapper.updateWares(wares);
	}

	@Override
	public void addWares(Wares wares) throws Exception {
		// TODO Auto-generated method stub
		waresMapper.addWares(wares);
	}

	@Override
	public List<Warestype> queryWarestypeByBrId(Warestype warestype) throws Exception {
		// TODO Auto-generated method stub
		
		return waresMapper.queryWarestypeByBrId(warestype);
	}
}
