package com.ztkj.mapper.login;

import com.ztkj.entity.sys.User;

public interface LoginMapper {

	public User LoginUser(User user);

	public User LoginUserF_id(User user);

}
