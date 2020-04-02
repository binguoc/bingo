package com.ztkj.service.sysService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Log;

public interface LogService {
	
	public void addLog(Log log)throws Exception;
	
	public PageInfo<Log> queryLog(Integer pageNum,Log log) throws Exception;

	public Log queryLogView(Log log) throws Exception;
}
