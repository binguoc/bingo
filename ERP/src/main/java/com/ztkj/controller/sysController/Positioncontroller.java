package com.ztkj.controller.sysController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Auth;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.Position;
import com.ztkj.service.sysService.PositionService;

@Controller
@RequestMapping("/sys/position")
public class Positioncontroller {

	@Resource(name="positionService")
	private PositionService positionService;
	
	//模糊查询
	@RequestMapping("/queryByPage.action")
	@ResponseBody
	public PageInfo<Position> queryByPage(Integer pageNum,Position position) {
		try {
			pageNum = pageNum==null?1:pageNum;
			if("".equals(position.getDept().getF_id()) || "-1".equals(position.getDept().getF_id())) {
				position.setDept(null);
			}
			if("".equals(position.getF_name())) {
				position.setF_name(null);
			}
			PageInfo<Position> pageInfo = positionService.queryByPage(pageNum,position);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询所有部门
	@RequestMapping("/queryAllDept.action")
	@ResponseBody
	public PageInfo<Dept> queryAllDept() {
		try {
			PageInfo<Dept> pageInfo = positionService.queryAllDept();
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询部门对应的职位
	@RequestMapping("/queryPosition.action")
	@ResponseBody
	public PageInfo<Position> queryPosition(Position position) {
		try {
			PageInfo<Position> pageInfo = positionService.queryPosition(position);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//修改
	@RequestMapping("/updatePosition.action")
	@ResponseBody
	public Integer updatePosition(Position position) {
		try {
			Integer x = positionService.updatePosition(position);
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
	public Integer recoverStatus(Position position) {
		try {
			Integer x = positionService.recoverPositionStatus(position);
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
	public Integer cancelStatus(Position position) {
		try {
			Integer x = positionService.cancelPositionStatus(position);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	@RequestMapping("/addPosition.action")
	@ResponseBody
	public Integer addPosition(Position position) {
		try {
			Integer x = positionService.addPosition(position);
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
	public PageInfo<Position> queryOne(Position Position) {
		try {
			PageInfo<Position> pageInfo = positionService.queryOne(Position);
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
	public PageInfo<Module> queryAllModule(Module module) {
		try {
			PageInfo<Module> pageInfo = positionService.queryAllModule(module);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询所有模块
	@RequestMapping("/selectOneModule.action")
	@ResponseBody
	public PageInfo<Auth> selectOneModule(Position position) {
		try {
			PageInfo<Auth> pageInfo = positionService.selectOneModule(position);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//添加模块权限
	@RequestMapping("/addAuth.action")
	@ResponseBody
	public Integer addAuth(Auth auth) {
		try {
			Integer xInteger = positionService.addAuth(auth);
			return xInteger;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//移除模块权限
	@RequestMapping("/removeAuth.action")
	@ResponseBody
	public Integer removeAuth(Auth auth) {
		try {
			Integer xInteger = positionService.removeAuth(auth);
			return xInteger;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}