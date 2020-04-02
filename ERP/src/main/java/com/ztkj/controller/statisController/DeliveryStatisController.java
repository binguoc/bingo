package com.ztkj.controller.statisController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.DeliveryStatis;
import com.ztkj.service.statisService.DeliveryStatisService;

@Controller
@RequestMapping({"/statis/delivery"})
public class DeliveryStatisController {
	
	@Resource(name="deliveryStatisService")
	private DeliveryStatisService deliveryStatisService;
	/**
	 * 厂商采购统计
	 */
	@RequestMapping("/deliveryStatis.action")
	@ResponseBody
	public PageInfo<DeliveryStatis> queryDeliveryStatis(Integer pageNum,DeliveryStatis deliveryStatis){
		try {
			PageInfo<DeliveryStatis> pageInfo = deliveryStatisService.queryDeliveryStatis(pageNum, deliveryStatis);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
