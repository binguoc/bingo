package com.ztkj.service.marketService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Client;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;
import com.ztkj.mapper.marketMapper.CustMapper;
import com.ztkj.service.marketService.CustService;



@Service("custService")
public class CustServiceImpl implements CustService {
	
	private Integer pageSize = 5;
	
	@Autowired
	private CustMapper custMapper;
	
	@Override
	@Transactional(readOnly=true)
	public PageInfo<Client> cust_selectByPage(Client client,Integer PageNum) throws Exception {
		PageHelper.startPage(PageNum, pageSize);
		List<Client> list = custMapper.cust_selectByPage(client);
		PageInfo<Client> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Province> selectBySid() throws Exception {
		return custMapper.selectBySid();
	}

	@Override
	public List<City> selectBySSid(Integer ssid) throws Exception {
		// TODO 自动生成的方法存根
		return custMapper.selectBySSid(ssid);
	}

	@Override
	public void addClient(Client client) throws Exception {
		custMapper.addClient(client);
		
	}

	@Override
	public Client selectById(Client client) throws Exception {
		return custMapper.selectById(client);
	}

	@Override
	public void updateClient(Client client) throws Exception {
		custMapper.updateClient(client);
	}

	@Override
	public void updateStatusClient(Client client) throws Exception {
		custMapper.updateStatusClient(client);
		
	}

	@Override
	public PageInfo<Client> selectAllpageBrowse(Client client, Integer pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Client> list = custMapper.selectAllpageBrowse(client);
		PageInfo<Client> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Position> selectPosition() throws Exception {
		// TODO 自动生成的方法存根
		return custMapper.selectPosition();
	}

	@Override
	public List<User> selectUserById(User user) throws Exception {
		// TODO 自动生成的方法存根
		return custMapper.selectUserById(user);
	}

	@Override
	public void updateClientF_isallot(Client client) throws Exception {
		custMapper.updateClientF_isallot(client);
		
	};
	
}
