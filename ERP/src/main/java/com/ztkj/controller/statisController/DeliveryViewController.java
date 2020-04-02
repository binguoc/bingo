package com.ztkj.controller.statisController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.DeliveryView;
import com.ztkj.service.statisService.DeliveryViewService;

@Controller
@RequestMapping("/statis/delivery")
public class DeliveryViewController {
	
	@Resource(name="deliveryViewService")
	private DeliveryViewService deliveryViewService;
	/**
	 * 厂商采购统计
	 */
	@RequestMapping("/deliveryView.action")
	@ResponseBody
	public PageInfo<DeliveryView> queryDeliveryStatis(Integer pageNum,DeliveryView deliveryView){
		pageNum = pageNum == null ? 1 : pageNum;
		try {
			PageInfo<DeliveryView> pageInfo = deliveryViewService.queryDeliveryView(pageNum, deliveryView);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
