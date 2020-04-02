package com.ztkj.controller.sysController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Auth;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.User;
import com.ztkj.service.sysService.LeftService;

@Controller
public class Leftcontroller {

	@Resource(name="leftService")
	private LeftService leftService;
	
	
	//查询所有模块
	@RequestMapping("/selectOneModuleLeft.action")
	@ResponseBody
	public PageInfo<Auth> selectOneModuleLeft(User user,HttpServletRequest request) {
		try {
			PageInfo<Auth> pageInfo = leftService.selectOneModuleLeft(user);
			HttpSession session = request.getSession();
			session.setAttribute("Auth", pageInfo.getList());
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询所有模块
	@RequestMapping("/queryAllModule.action")
	@ResponseBody
	public PageInfo<Module> queryAllModule(Module module,HttpServletRequest request) {
		try {
			PageInfo<Module> pageInfo = leftService.queryAllModule(module);
			HttpSession session = request.getSession();
			session.setAttribute("Module", pageInfo.getList());
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询所有模块
	@RequestMapping("/queryUser.action")
	@ResponseBody
	public Integer queryUser() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			User user = (User) request.getSession().getAttribute("loginUser");
			Integer xInteger = user.getF_positionid().getF_id();
			return xInteger;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//查询所有模块
	@RequestMapping("/queryUserBean.action")
	@ResponseBody
	public User queryUserBean() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			User user = (User) request.getSession().getAttribute("loginUser");
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}