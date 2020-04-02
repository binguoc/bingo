package com.ztkj.service.statisService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.statis.Sales;

public interface SalesService {
	
	public List<Province> selectProvince() throws Exception;
	
	public List<City> selectCity(String pro_id) throws Exception;
	
	public PageInfo<Sales> selectSales(Integer pageNum,Sales sales) throws Exception;

}
