package com.ztkj.service.marketService;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Client;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;

public interface CustService {

	PageInfo<Client> cust_selectByPage(Client client, Integer PageNum) throws Exception;
	List<Province> selectBySid() throws Exception;
	List<City> selectBySSid(Integer ssid) throws Exception;
	void addClient(Client client) throws Exception;
	Client selectById(Client client) throws Exception;
	void updateClient(Client client) throws Exception;
	void updateStatusClient(Client client) throws Exception;
	PageInfo<Client> selectAllpageBrowse(Client client, Integer pageNum)throws Exception;
	List<Position> selectPosition()throws Exception;
	List<User> selectUserById(User user)throws Exception;
	void updateClientF_isallot(Client client)throws Exception;

}
