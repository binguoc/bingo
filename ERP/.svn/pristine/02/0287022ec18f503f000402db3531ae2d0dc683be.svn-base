package com.ztkj.controller.marketController;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Client;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;
import com.ztkj.service.marketService.CustService;

@Controller
@RequestMapping({"/market/customer","/market/customerBrowse","/storage/stock","/storage/storage","/storage/delivery","/storage/inventory"})
public class CustController {
	
	@Resource(name="custService")
	private CustService custService;
	
	
	@RequestMapping("/cust_selectByPage.action")
	@ResponseBody
	public PageInfo<Client> cust_selectByPage(Client client,Integer pageNum){
		try {
			pageNum=pageNum==null?1:pageNum;
			PageInfo<Client> pageInfo = custService.cust_selectByPage(client, pageNum);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	@RequestMapping("/cust_selectAllpageBrowse.action")
	@ResponseBody
	public PageInfo<Client> cust_selectAllpageBrowse(Client client,Integer pageNum){
		try {
			pageNum=pageNum==null?1:pageNum;
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			User user = (User) request.getSession().getAttribute("loginUser");
			client.setF_service(user);
			PageInfo<Client> pageInfo = custService.selectAllpageBrowse(client, pageNum);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	@RequestMapping("/cust_addClient.action")
	@ResponseBody
	public String cust_addClient(Client client){
		try {
			custService.addClient(client);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	};
	@RequestMapping("/cust_updateClient.action")
	@ResponseBody
	public String cust_updateClient(Client client){
		try {
			custService.updateClient(client);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	};
	@RequestMapping("/cust_selectById.action")
	@ResponseBody
	public Client cust_selectById(Client client){
		try {
			Client client1=custService.selectById(client);
			return client1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	@RequestMapping("/cust_cancelStatusClient.action")
	@ResponseBody
	public String cust_cancelStatusClient(Client client){
		try {
			custService.updateStatusClient(client);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	};
	@RequestMapping("/cust_recoverStatusClient.action")
	@ResponseBody
	public String cust_recoverStatusClient(Client client){
		try {
			custService.updateStatusClient(client);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	};
	@RequestMapping("/cust_updateClientF_isallot.action")
	@ResponseBody
	public String updateClientF_isallot(Client client){
		try {
			custService.updateClientF_isallot(client);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	};
	
	
	@RequestMapping("/cust_selectPosition.action")
	@ResponseBody
	public List<Position> selectPosition(){
		try {
			List<Position> list= custService.selectPosition();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	@RequestMapping("/cust_selectUserById.action")
	@ResponseBody
	public List<User> selectUserById(User user){
		try {
			List<User> list= custService.selectUserById(user);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	
	@RequestMapping("/index_selectBySid.action")
	@ResponseBody
	public List<Province> index_selectBySid(){
		try {
			List<Province> list = custService.selectBySid();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	@RequestMapping("/index_selectBySSid.action")
	@ResponseBody
	public List<City> index_selectBySSid(Integer ssid){
		try {
			List<City> list = custService.selectBySSid(ssid);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	@RequestMapping("/queryUser.action")
	@ResponseBody
	public User queryUserBean() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			User user = (User) request.getSession().getAttribute("loginUser");
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
