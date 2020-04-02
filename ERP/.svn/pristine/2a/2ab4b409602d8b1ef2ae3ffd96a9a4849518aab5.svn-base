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
import com.ztkj.entity.purchase.Warestype;
import com.ztkj.entity.sys.User;
import com.ztkj.service.purchaseService.WarestypeService;

@Controller
public class WarestypeController {
	@Resource(name = "warestypeService")
	private  WarestypeService warestypeService;
	
	@RequestMapping("/purchase/productType/queryAllBrands.action")
	@ResponseBody
	public List<Brand> queryAllBrands(){
		try {
			List<Brand> list = warestypeService.queryAllBrands();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/purchase/productType/queryWarestypeByPage.action")
	@ResponseBody
	public PageInfo<Warestype> queryWarestypeByPage(Warestype warestype,Integer pageNum){
		int pageNow=1;
		pageNum=pageNum==null?pageNow:pageNum;
		try {
			PageInfo<Warestype> pageInfo = warestypeService.queryWarestypeByPage(warestype,pageNum);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/purchase/productType/queryWarestypeById.action")
	@ResponseBody
	public Warestype queryWarestypeById(Warestype warestype) {
		try {
			Warestype warestype2=warestypeService.queryWarestypeById(warestype);
			return warestype2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/purchase/productType/updateWarestype.action")
	@ResponseBody
	public Map<String, String> updateWarestype(Warestype warestype) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			warestypeService.updateWarestype(warestype);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping("/purchase/productType/cancelWarestype.action")
	@ResponseBody
	public Map<String, String> cancelWarestype(Warestype warestype) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			warestype.setWaStatus(0);
			warestypeService.updateWarestype(warestype);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/purchase/productType/recoverWarestype.action")
	@ResponseBody
	public Map<String, String> recoverWarestype(Warestype warestype) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			warestype.setWaStatus(1);
			warestypeService.updateWarestype(warestype);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/purchase/productType/addWarestype.action")
	@ResponseBody
	public Map<String, String> addWarestype(Warestype warestype,HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			User user =(User)request.getSession().getAttribute("loginUser");
			warestype.setEmpId(user.getF_id());
			warestypeService.addWarestype(warestype);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/purchase/productType/loginUser.action")
	@ResponseBody
	public User loginUser(HttpServletRequest request) {
		User user =(User)request.getSession().getAttribute("loginUser");
		return user;
	}
	
}
