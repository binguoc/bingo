package com.ztkj.controller.statisController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.StockView;
import com.ztkj.service.statisService.StockViewService;

@Controller
@RequestMapping("/statis/stock")
public class StockViewController {
	
	@Resource(name = "stockViewService")
	private StockViewService stockViewService;
	/**
	 * 入库查看详情
	 */
	@RequestMapping("/stockView.action")
	@ResponseBody
	public PageInfo<StockView> queryStockView(Integer pageNum, StockView stockView) {
		
		pageNum = pageNum == null ? 1 : pageNum;
		try {
			PageInfo<StockView> pageInfo = stockViewService.queryStockView(pageNum, stockView);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
