package com.ztkj.mapper.purchaseMapper;

import java.util.List;

import com.ztkj.entity.purchase.Brand;

public interface BrandMapper {
	public List<Brand> queryBrandByPage(Brand brand) throws Exception;
	public void cancelBrand(Brand brand) throws Exception;
	public void recoverBrand(Brand brand) throws Exception;
	public void updateBrand(Brand brand) throws Exception;
	public Brand queryBrandById(Brand brand);
	public void addBrand(Brand brand) throws Exception;
}
