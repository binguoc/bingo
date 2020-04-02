package com.ztkj.controller.sysController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Dept;
import com.ztkj.service.sysService.DeptService;

@Controller
@RequestMapping("/sys/dept")
public class Deptcontroller {

	@Resource(name="deptService")
	private DeptService deptService;
	
	//模糊查询
	@RequestMapping("/queryByPage.action")
	@ResponseBody
	public PageInfo<Dept> queryByPage(Integer pageNum,Dept dept) {
		try {
			pageNum = pageNum==null?1:pageNum;
			PageInfo<Dept> pageInfo = deptService.queryByPage(pageNum,dept);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询一条
	@RequestMapping("/queryOne.action")
	@ResponseBody
	public PageInfo<Dept> queryOne(Dept dept) {
		try {
			PageInfo<Dept> pageInfo = deptService.queryOne(dept);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	@RequestMapping("/addDept.action")
	@ResponseBody
	public Integer addDept(Dept dept) {
		try {
			Integer x = deptService.addDept(dept);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//恢复
	@RequestMapping("/recoverStatus.action")
	@ResponseBody
	public Integer recoverStatus(Dept dept) {
		try {
			Integer x = deptService.recoverDeptStatus(dept);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//注销
	@RequestMapping("/cancelStatus.action")
	@ResponseBody
	public Integer cancelStatus(Dept dept) {
		try {
			Integer x = deptService.cancelDeptStatus(dept);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//修改
	@RequestMapping("/updateDept.action")
	@ResponseBody
	public Integer updateDept(Dept dept) {
		try {
			Integer x = deptService.updateDept(dept);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
