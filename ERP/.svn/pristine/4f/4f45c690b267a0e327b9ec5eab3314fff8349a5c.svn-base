package com.ztkj.mapper.marketMapper;

import java.util.List;

import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Client;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;

public interface CustMapper {
	List<Client> cust_selectByPage(Client client);

	List<Province> selectBySid();

	List<City> selectBySSid(Integer ssid);

	void addClient(Client client);

	Client selectById(Client client);

	void updateClient(Client client);

	void updateStatusClient(Client client);

	List<Client> selectAllpageBrowse(Client client);

	List<Position> selectPosition();

	List<User> selectUserById(User user);

	void updateClientF_isallot(Client client);
	
}
