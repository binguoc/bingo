package com.ztkj.service.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztkj.entity.sys.User;
import com.ztkj.mapper.login.LoginMapper;
import com.ztkj.service.login.LoginService;


@Service("loginService")
public class LoginServicelmpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User LoginUser(User user)throws Exception {
		return loginMapper.LoginUser(user);
	}

	@Override
	public User LoginUserF_id(User user) throws Exception {
		// TODO 自动生成的方法存根
		return loginMapper.LoginUserF_id(user);
	}

}
