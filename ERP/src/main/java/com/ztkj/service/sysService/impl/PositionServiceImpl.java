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
import com.ztkj.mapper.sysMapper.PositionMapper;
import com.ztkj.service.sysService.PositionService;

@Service("positionService")
@Transactional
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<Position> queryByPage(Integer pageNow, Position position) throws Exception {
		// TODO Auto-generated method stub
		Integer pageSize = 5;
		PageHelper.startPage(pageNow, pageSize);
		List<Position> list = positionMapper.queryAllPosition(position);
		PageInfo<Position> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Dept> queryAllDept() throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Dept> list = positionMapper.queryAllDept();
		PageInfo<Dept> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer recoverPositionStatus(Position position) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = positionMapper.recoverPositionStatus(position);
		return xInteger;
	}

	@Override
	public Integer cancelPositionStatus(Position position) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = positionMapper.cancelPositionStatus(position);
		return xInteger;
	}

	@Override
	public PageInfo<Position> queryPosition(Position position) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Position> list = positionMapper.queryPosition(position);
		if (list.size()==1) {
			list=null;
		}
		PageInfo<Position> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer addPosition(Position position) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = positionMapper.addPosition(position);
		return xInteger;
	}

	@Override
	public PageInfo<Position> queryOne(Position position) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Position> list = positionMapper.queryOne(position);
		PageInfo<Position> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer updatePosition(Position position) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = positionMapper.updatePosition(position);
		return xInteger;
	}

	@Override
	public PageInfo<Module> queryAllModule(Module module) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Module> list = positionMapper.queryAllModule();
		PageInfo<Module> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Auth> selectOneModule(Position position) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(1, 100);
		List<Auth> list = positionMapper.selectOneModule(position);
		PageInfo<Auth> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer addAuth(Auth auth) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = positionMapper.addAuth(auth);
		return xInteger;
	}

	@Override
	public Integer removeAuth(Auth auth) throws Exception {
		// TODO Auto-generated method stub
		Integer xInteger = positionMapper.removeAuth(auth);
		return xInteger;
	}


}
