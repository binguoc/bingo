package com.ztkj.controller.statisController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.PurchaseStatis;
import com.ztkj.service.statisService.PurchaseStatisService;

@Controller
@RequestMapping({"/statis/purchase"})
public class PurchaseStatisController {
	
	@Resource(name="purchaseStatisService")
	private PurchaseStatisService purchaseStatisService;
	/**
	 * 厂商采购统计
	 */
	@RequestMapping("/purchaseStatis.action")
	@ResponseBody
	public PageInfo<PurchaseStatis> queryPurchase(Integer pageNum,PurchaseStatis purchaseStatis){
		try {
			PageInfo<PurchaseStatis> pageInfo = purchaseStatisService.queryPurchase(pageNum, purchaseStatis);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
