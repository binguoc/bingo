package com.ztkj.service.purchaseService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.mapper.purchaseMapper.BrandMapper;
import com.ztkj.service.purchaseService.BrandService;
@Service("brandService")
public class BrandServiceImpl implements BrandService{
	
	@Autowired()
	private BrandMapper brandMapper;

	@Override
	public PageInfo<Brand> queryBrandByPage(Brand brand,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 3;
		PageHelper.startPage(pageNum, pageSize);
		List<Brand> list = brandMapper.queryBrandByPage(brand);
		PageInfo<Brand> pageInfo = new PageInfo<Brand>(list);
		return pageInfo;
	}

	@Override
	public void cancelBrand(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		brandMapper.cancelBrand(brand);
	}

	@Override
	public void recoverBrand(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		brandMapper.recoverBrand(brand);
	}

	@Override
	public void updateBrand(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		brandMapper.updateBrand(brand);
	}

	@Override
	public Brand queryBrandById(Brand brand) {
		// TODO Auto-generated method stub
		Brand brand2 = brandMapper.queryBrandById(brand);
		return brand2;
	}

	@Override
	public void addBrand(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		brandMapper.addBrand(brand);
	}
	
}
