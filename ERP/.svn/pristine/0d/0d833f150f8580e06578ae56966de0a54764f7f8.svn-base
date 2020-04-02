package com.ztkj.service.purchaseService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.purchase.Firm;

public interface FirmService {

	public List<Province> queryAllProvince() throws Exception;

	public List<City> queryAllCityByProId(Province province) throws Exception;

	public PageInfo<Firm> queryAllFirmByPage(Firm firm,Integer pageNum) throws Exception;

	public Firm queryFirmById(Firm firm) throws Exception;

	public void updateFirm(Firm firm) throws Exception;

	public void addFirm(Firm firm) throws Exception;
}
