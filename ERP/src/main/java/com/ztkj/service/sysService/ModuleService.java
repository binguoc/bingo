package com.ztkj.service.sysService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Module;

public interface ModuleService {
	PageInfo<Module> queryByPage(Integer pageNow,Module module) throws Exception;

	Integer recoverModuleStatus(Module module) throws Exception;
	
	Integer cancelModuleStatus(Module module) throws Exception;

	PageInfo<Module> queryAllFmodule() throws Exception;

	Integer addModule(Module module) throws Exception;

	PageInfo<Module> queryOne(Module module) throws Exception;

	Integer updateModule(Module module) throws Exception;

	PageInfo<Module> queryAllModule(Module module) throws Exception;
}
