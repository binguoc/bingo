package com.ztkj.service.storageService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.User;
import com.ztkj.mapper.storageMapper.StorageMapper;
import com.ztkj.service.storageService.StorageService;

@Service("storageService")
public class StorageServiceImpl implements StorageService {
	
	@Autowired
	private StorageMapper storageMapper; //注入StorageMapper 对象
	

	@Override
	public PageInfo<Storage> queryAllStorage(Integer pageNum,Storage storage) throws Exception {
		Integer pageSize = 5;
		PageHelper.startPage(pageNum, pageSize);//分页插件，专门用于myBatis分页
		List<Storage> list = storageMapper.queryAllStorage(storage);
		PageInfo<Storage> pageInfo = new PageInfo<Storage>(list);
		return pageInfo;
	}


	@Override
	public Integer cancelStorage(Storage storage) throws Exception {
		Integer flag = storageMapper.cancelStorage(storage);
		return flag;
	}


	@Override
	public Integer recoverStorage(Storage storage) throws Exception {
		Integer flag = storageMapper.recoverStorage(storage);
		return flag;
	}


	@Override
	public List<Storage> queryStorageById(Storage storage) throws Exception {
		List<Storage> list = storageMapper.queryStorageById(storage);
		return list;
	}


	@Override
	public List<Province> selectByProvince(Province province) throws Exception {
		List<Province> list = storageMapper.selectByProvince(province);
		return list;
	}


	@Override
	public List<City> selectByCity(City city) throws Exception {
		List<City> list = storageMapper.selectByCity(city);
		return list;
	}


	@Override
	public List<User> queryUserPosition() throws Exception {
		List<User> list = storageMapper.queryUserPosition();
		return list;
	}


	@Override
	public Integer addStorage(Storage storage) throws Exception {
		Integer flag = storageMapper.addStorage(storage);
		return flag;
	}


	@Override
	public List<Storage> queryByStId(Storage storage) throws Exception {
		List<Storage> list = storageMapper.queryByStId(storage);
		return list;
	}


	@Override
	public Integer updateStorage(Storage storage) throws Exception {
		Integer flag = storageMapper.updateStorage(storage);
		return flag;
	}

	

}
