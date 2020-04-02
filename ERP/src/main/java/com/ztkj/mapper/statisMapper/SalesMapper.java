package com.ztkj.mapper.statisMapper;

import java.util.List;

import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.statis.Sales;

public interface SalesMapper {
	
	public List<Province> selectProvince();
	
	public List<City> selectCity(String pro_id);
	
	public List<Sales> selectSales(Sales sales);

}
