package com.ztkj.mapper.sysMapper;

import java.util.List;

import com.ztkj.entity.sys.Module;



public interface ModuleMapper {
	List<Module> queryAllModule(Module module) throws Exception;
	List<Module> queryAllFmodule() throws Exception;
	Integer recoverModuleStatus(Module module) throws Exception;
	Integer cancelModuleStatus(Module module) throws Exception;
	Integer addModule(Module module) throws Exception;
	List<Module> queryOne(Module module) throws Exception;
	Integer updateModule(Module module) throws Exception;
}
