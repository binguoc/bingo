package com.ztkj.service.sysService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Dept;

public interface DeptService {
	PageInfo<Dept> queryByPage(Integer pageNow,Dept dept) throws Exception;
	Integer addDept(Dept dept) throws Exception;
	Integer recoverDeptStatus(Dept dept) throws Exception;
	Integer cancelDeptStatus(Dept dept) throws Exception;
	PageInfo<Dept> queryOne(Dept dept) throws Exception;
	Integer updateDept(Dept dept) throws Exception;
}
