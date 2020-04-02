package com.ztkj.controller.purchaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Wares;
import com.ztkj.entity.purchase.Warestype;
import com.ztkj.entity.sys.User;
import com.ztkj.service.purchaseService.WaresService;

@Controller
public class WaresController {
	@Resource(name = "waresService")
	private  WaresService waresService;
	
	@RequestMapping("/purchase/product/queryAllBrands.action")
	@ResponseBody
	public List<Brand> queryAllBrands(){
		try {
			List<Brand> list = waresService.queryAllBrands();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/purchase/product/queryWarestypeByBrId.action")
	@ResponseBody
	public List<Warestype> queryWarestypeByBrId(Warestype warestype){
		try {
			List<Warestype> list = waresService.queryWarestypeByBrId(warestype);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/purchase/product/queryWaresByPage.action")
	@ResponseBody
	public PageInfo<Wares> queryWaresByPage(Wares wares,Integer pageNum){
		int pageNow=1;
		pageNum=pageNum==null?pageNow:pageNum;
		try {
			PageInfo<Wares> pageInfo = waresService.queryWaresByPage(wares,pageNum);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/purchase/product/queryWaresById.action")
	@ResponseBody
	public Wares queryWaresById(Wares wares) {
		try {
			Wares wares2=waresService.queryWaresById(wares);
			return wares2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/purchase/product/updateWares.action")
	@ResponseBody
	public Map<String, String> updateWares(Wares wares) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			waresService.updateWares(wares);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping("/purchase/product/cancelWares.action")
	@ResponseBody
	public Map<String, String> cancelWares(Wares wares) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			wares.setWaStatus(0);
			waresService.updateWares(wares);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/purchase/product/recoverWares.action")
	@ResponseBody
	public Map<String, String> recoverWares(Wares wares) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			wares.setWaStatus(1);
			waresService.updateWares(wares);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/purchase/product/addWares.action")
	@ResponseBody
	public Map<String, String> addWares(Wares wares,HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			User user =(User)request.getSession().getAttribute("loginUser");
			wares.setWaEmpid(user.getF_id());
			waresService.addWares(wares);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/purchase/product/loginUser.action")
	@ResponseBody
	public User loginUser(HttpServletRequest request) {
		User user =(User)request.getSession().getAttribute("loginUser");
		return user;
	}
}
