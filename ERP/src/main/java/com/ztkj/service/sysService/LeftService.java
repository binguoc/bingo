package com.ztkj.service.sysService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Auth;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.User;

public interface LeftService {

	PageInfo<Auth> selectOneModuleLeft(User user) throws Exception;

	PageInfo<Module> queryAllModule(Module module) throws Exception;
}
