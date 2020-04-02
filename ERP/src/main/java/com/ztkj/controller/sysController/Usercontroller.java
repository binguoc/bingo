package com.ztkj.controller.sysController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;
import com.ztkj.service.sysService.PositionService;
import com.ztkj.service.sysService.UserService;

@Controller
@RequestMapping("/sys/users")
public class Usercontroller {

	@Resource(name="userService")
	private UserService userService;
	
	//模糊查询
	@RequestMapping("/queryByPage.action")
	@ResponseBody
	public PageInfo<User> queryByPage(Integer pageNum,User user) {
		try {
			if ("".equals(user.getF_status()) || "-1".equals(user.getF_status())) {
				user.setF_status(null);
			}
			if ("".equals(user.getF_positionid().getDept().getF_id()) || "-1".equals(user.getF_positionid().getDept().getF_id())) {
				user.setF_positionid(null);
			}
			pageNum = pageNum==null?1:pageNum;
			PageInfo<User> pageInfo = userService.queryByPage(pageNum, user);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//重置密码
	@RequestMapping("/updateUserPwd.action")
	@ResponseBody
	public Integer updateUserPwd(User user) {
		try {
			Integer x = userService.updateUserPwd(user);
			return x;
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
			PageInfo<Dept> pageInfo = userService.queryAllDept();
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
	public PageInfo<User> queryPosition(User user) {
		try {
			if ("".equals(user.getF_positionid().getDept().getF_id()) || "-1".equals(user.getF_positionid().getDept().getF_id())) {
				user.setF_positionid(null);
			}
			PageInfo<User> pageInfo = userService.queryPosition(user);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//修改
	@RequestMapping("/updateUser.action")
	@ResponseBody
	public Integer updateUser(User user) {
		try {
			Integer x = userService.updateUser(user);
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
	public Integer recoverStatus(User user) {
		try {
			Integer x = userService.recoverUserStatus(user);
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
	public Integer cancelStatus(User user) {
		try {
			Integer x = userService.cancelUserStatus(user);
			return x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	@RequestMapping("/addUser.action")
	@ResponseBody
	public Integer addUser(User user) {
		try {
			Integer x = userService.addUser(user);
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
	public PageInfo<User> queryOne(User user) {
		try {
			PageInfo<User> pageInfo = userService.queryOne(user);
			return pageInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}