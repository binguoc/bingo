package com.ztkj.service.login;

import com.ztkj.entity.sys.User;

public interface LoginService {

	User LoginUser(User user) throws Exception;

	User LoginUserF_id(User user)throws Exception;

}
