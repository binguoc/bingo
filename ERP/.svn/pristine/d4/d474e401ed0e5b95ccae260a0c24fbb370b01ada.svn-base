package com.ztkj.service.sysService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Auth;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;
import com.ztkj.mapper.sysMapper.LeftMapper;
import com.ztkj.mapper.sysMapper.PositionMapper;
import com.ztkj.service.sysService.LeftService;
import com.ztkj.service.sysService.PositionService;

@Service("leftService")
@Transactional
public class LeftServiceImpl implements LeftService {

	@Autowired
	private LeftMapper leftMapper;
	

	@Override
	@Transactional(readOnly=true)
	public PageInfo<Auth> selectOneModuleLeft(User user) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Auth> list = leftMapper.selectOneModuleLeft(user);
		PageInfo<Auth> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}


	@Override
	public PageInfo<Module> queryAllModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Module> list = leftMapper.queryAllModule(module);
		PageInfo<Module> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}


}
