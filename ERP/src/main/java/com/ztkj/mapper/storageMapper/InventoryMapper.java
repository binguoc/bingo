package com.ztkj.mapper.storageMapper;

import java.util.List;

import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.Storage;

public interface InventoryMapper {

	public List<Inventory>queryAllInventory( Inventory inventory);
	
	 public Detailed queryByStoId( Integer stoId); 
	 public Storage queryStorageByStoId( Integer stoId);

	public Integer queryInventoryByStoId(Integer stoId); 
}
