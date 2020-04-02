package com.ztkj.controller.statisController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.SalesView;
import com.ztkj.service.statisService.SalesViewService;

@Controller
@RequestMapping("/statis/sales")
public class SalesViewController {

	@Resource(name = "salesViewService")
	private SalesViewService salesViewService;

	/**
	 * 客户销量查看详情
	 */
	@RequestMapping("/salesView.action")
	@ResponseBody
	public PageInfo<SalesView> querySalesView(Integer pageNum, SalesView salesView) {
		pageNum = pageNum == null ? 1 : pageNum;
		try {
			PageInfo<SalesView> pageInfo = salesViewService.querySalesView(pageNum, salesView);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
