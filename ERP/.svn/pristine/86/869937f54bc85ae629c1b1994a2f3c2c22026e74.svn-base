package com.ztkj.service.sysService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.statis.Sales;
import com.ztkj.entity.sys.Log;
import com.ztkj.mapper.sysMapper.LogMapper;
import com.ztkj.service.sysService.LogService;

import sun.util.logging.resources.logging;

@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logMapper;
	
	@Override
	public void addLog(Log log) throws Exception {
		// TODO Auto-generated method stub
		logMapper.addLog(log);
		
	}

	@Override
	@Transactional(readOnly=true)
	public PageInfo<Log> queryLog(Integer pageNum, Log log) throws Exception {
		// TODO Auto-generated method stub
		pageNum = pageNum==null ? 1:pageNum;
		Integer pageSize = 8;
		//分页的插件，专门用于MyBatis的分页插件
		PageHelper.startPage(pageNum, pageSize);
		List<Log> list = logMapper.queryLog(log);
		PageInfo<Log> pageInfo = new PageInfo<Log>(list);
		return pageInfo;
	}

	@Override
	public Log queryLogView(Log log) throws Exception {
		return logMapper.queryLogView(log);
		
		
	}
	

}
