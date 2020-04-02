package com.ztkj.controller.purchaseController;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.purchase.PuAndDeVo;
import com.ztkj.entity.purchase.Purchase;
import com.ztkj.entity.purchase.PurchaseVo;
import com.ztkj.entity.sys.User;
import com.ztkj.service.purchaseService.PurchaseService;

@Controller
@RequestMapping("/purchase/purchaseExamine")
public class purchaseExiamineController {
		@Resource(name = "purchaseService")
		private PurchaseService purchaseService;

		public User queryUser(HttpServletRequest request) {
			User user=new User();
			try {
				HttpSession session = request.getSession();
				user = (User) session.getAttribute("loginUser");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
		
		@RequestMapping("/queryStatus.action")
		@ResponseBody
		public PageInfo<PurchaseVo> queryStatus(PurchaseVo vo,HttpServletRequest request) {
			PageInfo<PurchaseVo> pageInfo = null;
			User user = queryUser(request);
			try {
				pageInfo = purchaseService.queryStatus(vo,user.getF_name());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pageInfo;
		}
		
		@RequestMapping("queryByOnePuAndDeVo3.action")
		@ResponseBody
		public PuAndDeVo queryByOnePuAndDeVo3(String puRealid) {
			PuAndDeVo vo=new PuAndDeVo();
			try {
				Purchase purchase = purchaseService.queryByOnePurchase(puRealid);
				List<Detailed> list = purchaseService.queryByOneDetailed(puRealid);
				vo.setPurchase(purchase);
				vo.setDeList(list);
			} catch (Exception e) { 
				// TODO Auto-generated catch block e.printStackTrace();
			}
			return vo;
		}
		

		@RequestMapping("/updateStatus.action")
		@ResponseBody
		public void updateStatus(Purchase purchase) {
			try {
				purchaseService.updateStatus(purchase);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
