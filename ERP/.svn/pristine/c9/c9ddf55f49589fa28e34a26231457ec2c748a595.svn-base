package com.ztkj.service.sysService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.User;

public interface UserService {
	PageInfo<User> queryByPage(Integer pageNow,User user) throws Exception;

	Integer updateUserPwd(User user) throws Exception;

	PageInfo<Dept> queryAllDept() throws Exception;

	Integer recoverUserStatus(User user) throws Exception;

	Integer cancelUserStatus(User user) throws Exception;

	PageInfo<User> queryPosition(User user) throws Exception;

	Integer addUser(User user) throws Exception;

	PageInfo<User> queryOne(User user) throws Exception;

	Integer updateUser(User user) throws Exception;
}
