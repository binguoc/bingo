package com.ztkj.controller.statisController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.StockStatis;
import com.ztkj.service.statisService.StockStatisService;

@Controller
@RequestMapping({"/statis/stock"})
public class StockStatisController {
	
	@Resource(name="stockStatisService")
	private StockStatisService stockStatisService;	
	/**
	 * 入库统计
	 */
	@RequestMapping("/stockStatis.action")
	@ResponseBody
	public PageInfo<StockStatis> queryPurchase(Integer pageNum,StockStatis stockStatis){
		try {
			PageInfo<StockStatis> pageInfo = stockStatisService.queryStockStatis(pageNum, stockStatis);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
