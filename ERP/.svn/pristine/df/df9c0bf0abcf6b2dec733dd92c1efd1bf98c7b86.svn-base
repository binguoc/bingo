package com.ztkj.controller.sysController;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Module;
import com.ztkj.service.sysService.ModuleService;

@Controller
@RequestMapping("/sys/modules")
public class Modulecontroller {

	@Resource(name="moduleService")
	private ModuleService moduleService;
	
	//模糊查询
	@RequestMapping("/queryByPage.action")
	@ResponseBody
	public PageInfo<Module> queryByPage(Integer pageNum,Module module) {
		try {
			pageNum = pageNum==null?1:pageNum;
			PageInfo<Module> pageInfo = moduleService.queryByPage(pageNum,module);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//模块信息查询回显
	@RequestMapping("/querypageOne.action")
	@ResponseBody
	public PageInfo<Module> querypageOne(Integer pageNum,Module module) {
		try {
			pageNum = pageNum==null?1:pageNum;
			PageInfo<Module> pageInfo = moduleService.queryByPage(pageNum,module);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询所有父模块
	@RequestMapping("/queryAllFmodule.action")
	@ResponseBody
	public PageInfo<Module> queryAllFmodule() {
		try {
			PageInfo<Module> pageInfo = moduleService.queryAllFmodule();
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//恢复
	@RequestMapping("/recoverStatus.action")
	@ResponseBody
	public Integer recoverStatus(Module module) {
		try {
			Integer x = moduleService.recoverModuleStatus(module);
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
	public Integer cancelStatus(Module module) {
		try {
			Integer x = moduleService.cancelModuleStatus(module);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	@RequestMapping("/addModule.action")
	@ResponseBody
	public Integer addModule(Module module) {
		try {
			Integer x = moduleService.addModule(module);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询单条
	@RequestMapping("/queryOne.action")
	@ResponseBody
	public PageInfo<Module> queryOne(Module module) {
		try {
			PageInfo<Module> pageInfo = moduleService.queryOne(module);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//修改
	@RequestMapping("/updateModule.action")
	@ResponseBody
	public Integer updateModule(Module module) {
		try {
			if (module.getF_authId().equals("-1")) {
				module.setF_authId("无");
			}
			Integer x = moduleService.updateModule(module);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}