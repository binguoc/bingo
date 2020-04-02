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
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.purchase.Firm;
import com.ztkj.entity.sys.User;
import com.ztkj.service.purchaseService.FirmService;

@Controller
public class FirmController {
	@Resource(name = "firmService")
	private FirmService firmService;
	
	
	//查询所有省
	@RequestMapping("/purchase/manufacturer/queryAllProvince.action")
	@ResponseBody
	public List<Province> queryAllProvince(){
		try {
			List<Province> list = firmService.queryAllProvince();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//查询所有市
	@RequestMapping("/purchase/manufacturer/queryAllCityByProId.action")
	@ResponseBody
	public List<City> queryAllCityByProId(Province province){
		try {
			List<City> list = firmService.queryAllCityByProId(province);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//查询所有厂商
	@RequestMapping("/purchase/manufacturer/queryAllFirmByPage.action")
	@ResponseBody
	public PageInfo<Firm> queryAllFirmByPage(Firm firm,Integer pageNum){
		try {
			pageNum=pageNum==null?1:pageNum;
			PageInfo<Firm> pageInfo = firmService.queryAllFirmByPage(firm,pageNum);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//查询单个厂商
	@RequestMapping("/purchase/manufacturer/queryFirmById.action")
	@ResponseBody
	public Firm queryFirmById(Firm firm){
		try {
			Firm firm2=firmService.queryFirmById(firm);
			return firm2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//修改厂商信息
	@RequestMapping("/purchase/manufacturer/updateFirm.action")
	@ResponseBody
	public Map<String, String> updateFirm(Firm firm){
		Map<String, String> map=new HashMap<String, String>();
		try {
			firmService.updateFirm(firm);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("flag", "false");
		}
		return map;
	}
	//注销
	@RequestMapping("/purchase/manufacturer/cancelFirm.action")
	@ResponseBody
	public Map<String, String> cancelFirm(Firm firm){
		Map<String, String> map=new HashMap<String, String>();
		try {
			firm.setFiStatus(0);
			firmService.updateFirm(firm);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("flag", "false");
		}
		return map;
	}
	//恢复
	@RequestMapping("/purchase/manufacturer/recoverFirm.action")
	@ResponseBody
	public Map<String, String> recoverFirm(Firm firm){
		Map<String, String> map=new HashMap<String, String>();
		try {
			firm.setFiStatus(1);
			firmService.updateFirm(firm);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("flag", "false");
		}
		return map;
	}
	//添加厂商
	@RequestMapping("/purchase/manufacturer/addFirm.action")
	@ResponseBody
	public Map<String, String> addFirm(Firm firm,HttpServletRequest request){
		Map<String, String> map=new HashMap<String, String>();
		try {
			User user =(User)request.getSession().getAttribute("loginUser");
			firm.setFiCreateUserid(user.getF_id());
			firmService.addFirm(firm);
			map.put("flag", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("flag", "false");
		}
		return map;
	}
	
	@RequestMapping("/purchase/manufacturer/loginUser.action")
	@ResponseBody
	public User loginUser(HttpServletRequest request) {
		User user =(User)request.getSession().getAttribute("loginUser");
		return user;
	}
	
}
