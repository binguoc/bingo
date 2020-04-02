package com.ztkj.service.storageService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.User;

public interface StorageService {

	public PageInfo<Storage> queryAllStorage(Integer pageNum,Storage storage)throws Exception;

	public Integer cancelStorage(Storage storage)throws Exception ;
	
	public Integer recoverStorage(Storage storage)throws Exception ;

	public List<Storage> queryStorageById(Storage storage)throws Exception;

	public List<Province> selectByProvince(Province province) throws Exception;

	public List<City> selectByCity(City city)throws Exception;

	public List<User>  queryUserPosition() throws Exception;

	public Integer addStorage(Storage storage) throws Exception;

	public List<Storage> queryByStId(Storage storage)throws Exception;

	public Integer updateStorage(Storage storage) throws Exception;
}
