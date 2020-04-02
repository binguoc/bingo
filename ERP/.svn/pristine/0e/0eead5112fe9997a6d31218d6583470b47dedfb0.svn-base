package com.ztkj.service.marketService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztkj.entity.market.TestBean;
import com.ztkj.mapper.marketMapper.TestMapper;
import com.ztkj.service.marketService.TestService;



@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<TestBean> selectTest()throws Exception {
		return testMapper.selectTest();
	};
	
}
