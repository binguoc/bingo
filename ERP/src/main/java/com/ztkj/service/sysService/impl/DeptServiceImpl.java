package com.ztkj.service.sysService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Dept;
import com.ztkj.mapper.sysMapper.DeptMapper;
import com.ztkj.service.sysService.DeptService;

@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<Dept> queryByPage(Integer pageNow,Dept dept) throws Exception {
		Integer pageSize = 5;
		PageHelper.startPage(pageNow, pageSize);
		List<Dept> list = deptMapper.queryAllDept(dept);
		PageInfo<Dept> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer addDept(Dept dept) throws Exception {
		Integer xInteger = deptMapper.addDept(dept);
		return xInteger;
	}

	@Override
	public Integer recoverDeptStatus(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = deptMapper.recoverDeptStatus(dept);
		return xInteger;
	}

	@Override
	public Integer cancelDeptStatus(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = deptMapper.cancelDeptStatus(dept);
		return xInteger;
	}

	@Override
	@Transactional(readOnly=true)
	public PageInfo<Dept> queryOne(Dept dept) {
		PageHelper.startPage(1, 3);
		List<Dept> list = deptMapper.queryOne(dept);
		PageInfo<Dept> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer updateDept(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = deptMapper.updateDept(dept);
		return xInteger;
	}

}
