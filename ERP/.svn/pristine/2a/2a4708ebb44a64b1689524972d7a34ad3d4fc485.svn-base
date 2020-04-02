package com.ztkj.controller.statisController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.statis.Sales;
import com.ztkj.service.statisService.SalesService;
@Controller
@RequestMapping({"/statis/sales","/statis/purchase","/statis/delivery","/statis/stock"})
public class SalesStatisController {
	@Resource(name="salesService")
	private SalesService SalesService;
	/**
	 * 省的查询
	 */
	@RequestMapping("/statisProvince.action")
	@ResponseBody
	public List<Province> selectProvince(){
		try {
			List<Province> list = SalesService.selectProvince();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 市的查询
	 */
	@RequestMapping("/statisCity.action")
	@ResponseBody
	public List<City> selectCity(String pro_id){
		try {
			List<City> list = SalesService.selectCity(pro_id);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 客户销量
	 */
	@RequestMapping("/sales.action")
	@ResponseBody
	public PageInfo<Sales> selectCity(Integer pageNum,Sales sales){
		try {
			PageInfo<Sales> pageInfo = SalesService.selectSales(pageNum,sales);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
