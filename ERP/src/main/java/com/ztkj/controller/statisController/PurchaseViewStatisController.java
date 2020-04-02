package com.ztkj.controller.statisController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.PurchaseViewStatis;
import com.ztkj.service.statisService.PurchaseViewStatisService;

@Controller
@RequestMapping("/statis/purchase")
public class PurchaseViewStatisController {
	
	@Resource(name = "purchaseViewStatisService")
	private PurchaseViewStatisService purchaseViewStatisService;

	/**
	 * 客户销量查看详情
	 */
	@RequestMapping("/purchaseView.action")
	@ResponseBody
	public PageInfo<PurchaseViewStatis> queryPurchaseView(Integer pageNum, PurchaseViewStatis purchaseViewStatis) {
		pageNum = pageNum == null ? 1 : pageNum;
		try {
			PageInfo<PurchaseViewStatis>  pageInfo= purchaseViewStatisService.queryPurchaseView(pageNum, purchaseViewStatis);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
