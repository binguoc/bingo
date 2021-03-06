package com.ztkj.controller.purchaseController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.sys.User;
import com.ztkj.service.purchaseService.BrandService;
@Controller()
public class BrandController{
	
	@Resource(name = "brandService")
	private BrandService brandService;
	
	@RequestMapping("/purchase/brand/queryBrandByPage.action")
	@ResponseBody
	public PageInfo<Brand> queryBrandByPage(Brand brand,Integer pageNum) {
		int pageNow=1;
		pageNum=pageNum==null?pageNow:pageNum;
		PageInfo<Brand> pageInfo= null;
		if (null!=brand.getBrStatus()) {
			Integer brStatus=brand.getBrStatus()==-1?null:brand.getBrStatus();
			brand.setBrStatus(brStatus);
		}
		try {
			pageInfo= brandService.queryBrandByPage(brand, pageNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageInfo;
	}
	
	@RequestMapping("/purchase/brand/queryBrandById.action")
	@ResponseBody
	public Brand queryBrandById(Brand brand) {
		try {
			Brand brand2 = brandService.queryBrandById(brand);
			return brand2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/purchase/brand/updateBrand.action")
	@ResponseBody
	public Map<String, String> updateBrand(Brand brand) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			brandService.updateBrand(brand);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping("/purchase/brand/cancelBrand.action")
	@ResponseBody
	public Map<String, String> cancelBrand(Brand brand) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			brand.setBrStatus(0);
			brandService.updateBrand(brand);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping("/purchase/brand/recoverBrand.action")
	@ResponseBody
	public Map<String, String> recoverBrand(Brand brand) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			brand.setBrStatus(1);
			brandService.updateBrand(brand);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping("/purchase/brand/addBrand.action")
	@ResponseBody
	public Map<String, String> addBrand(Brand brand,HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			User user = (User) request.getSession().getAttribute("loginUser");
			brand.setBrEmpid(user.getF_id());
			brandService.addBrand(brand);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			map.put("flat", "false");
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping("/purchase/brand/loginUser.action")
	@ResponseBody
	public User loginUser(HttpServletRequest request) {
		User user =(User)request.getSession().getAttribute("loginUser");
		return user;
	}
}
