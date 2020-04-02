package com.ztkj.service.sysService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Module;
import com.ztkj.mapper.sysMapper.ModuleMapper;
import com.ztkj.service.sysService.ModuleService;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<Module> queryByPage(Integer pageNow, Module module) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 5;
		PageHelper.startPage(pageNow, pageSize);
		List<Module> list = moduleMapper.queryAllModule(module);
		PageInfo<Module> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer recoverModuleStatus(Module module) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = moduleMapper.recoverModuleStatus(module);
		return xInteger;
	}

	@Override
	public Integer cancelModuleStatus(Module module) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = moduleMapper.cancelModuleStatus(module);
		return xInteger;
	}

	@Override
	public PageInfo<Module> queryAllFmodule() throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Module> list = moduleMapper.queryAllFmodule();
		PageInfo<Module> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer addModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = moduleMapper.addModule(module);
		return xInteger;
	}

	@Override
	public PageInfo<Module> queryOne(Module module) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 3);
		List<Module> list = moduleMapper.queryOne(module);
		PageInfo<Module> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer updateModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = moduleMapper.updateModule(module);
		return xInteger;
	}

	@Override
	public PageInfo<Module> queryAllModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 1000);
		List<Module> list = moduleMapper.queryAllModule(module);
		PageInfo<Module> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
