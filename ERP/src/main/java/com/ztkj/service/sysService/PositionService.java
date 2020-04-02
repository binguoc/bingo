package com.ztkj.service.sysService;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.sys.Auth;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.Module;
import com.ztkj.entity.sys.Position;

public interface PositionService {
	PageInfo<Position> queryByPage(Integer pageNow,Position position) throws Exception;

	PageInfo<Dept> queryAllDept() throws Exception;

	Integer recoverPositionStatus(Position position) throws Exception;

	Integer cancelPositionStatus(Position position) throws Exception;

	PageInfo<Position> queryPosition(Position position) throws Exception;

	Integer addPosition(Position position) throws Exception;

	PageInfo<Position> queryOne(Position position) throws Exception;

	Integer updatePosition(Position position) throws Exception;

	PageInfo<Module> queryAllModule(Module module) throws Exception;

	PageInfo<Auth> selectOneModule(Position position) throws Exception;

	Integer addAuth(Auth auth) throws Exception;

	Integer removeAuth(Auth auth) throws Exception;
}
