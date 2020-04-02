package com.ztkj.controller.sysController;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.service.sysService.CityService;

@Controller
@RequestMapping("/sys/area")
public class CityController {
	
	@Resource(name="cityService")
	private CityService cityService;

	@RequestMapping("/city.action")//映射请求路径
	@ResponseBody
	public PageInfo<City> selectAllCity(City city,Integer pageNum){
		pageNum = pageNum==null ? 1:pageNum;
		if("".equals(city.getProvince().getPro_name())) {
			city.setProvince(null);
		}
		
		try {
			PageInfo<City> pageInfo = cityService.selectAllCity(pageNum,city);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
