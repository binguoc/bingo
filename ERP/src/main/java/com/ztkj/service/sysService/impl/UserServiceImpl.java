package com.ztkj.service.sysService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;
import com.ztkj.mapper.sysMapper.PositionMapper;
import com.ztkj.mapper.sysMapper.UserMapper;
import com.ztkj.service.sysService.PositionService;
import com.ztkj.service.sysService.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<User> queryByPage(Integer pageNow, User user) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 5;
		PageHelper.startPage(pageNow, pageSize);
		List<User> list = userMapper.queryAllUser(user);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer updateUserPwd(User user) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = userMapper.updateUserPwd(user);
		return xInteger;
	}

	@Override
	public PageInfo<Dept> queryAllDept() throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Dept> list = userMapper.queryAllDept();
		PageInfo<Dept> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer recoverUserStatus(User user) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = userMapper.recoverUserStatus(user);
		return xInteger;
	}

	@Override
	public Integer cancelUserStatus(User user) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = userMapper.cancelUserStatus(user);
		return xInteger;
	}

	@Override
	public PageInfo<User> queryPosition(User user) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<User> list = userMapper.queryPosition(user);
		if (list.size()==1) {
			list=null;
		}
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = userMapper.addUser(user);
		return xInteger;
	}

	@Override
	public PageInfo<User> queryOne(User user) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<User> list = userMapper.queryOne(user);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = userMapper.updateUser(user);
		return xInteger;
	}


}
