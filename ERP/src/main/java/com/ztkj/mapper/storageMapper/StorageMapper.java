package com.ztkj.mapper.storageMapper;

import java.util.List;

import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.User;

public interface StorageMapper {

	public List<Storage> queryAllStorage(Storage storage) throws Exception;

	public Integer cancelStorage(Storage storage);
	
	public Integer recoverStorage(Storage storage);

	public List<Storage> queryStorageById(Storage storage);

	public List<Province> selectByProvince(Province province);

	public List<City> selectByCity(City city);

	public List<User>  queryUserPosition();

	public Integer addStorage(Storage storage);

	public List<Storage> queryByStId(Storage storage);

	public Integer updateStorage(Storage storage);
}
