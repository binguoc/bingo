package com.ztkj.service.storageService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.Storage;

public interface InventoryService {
	
	public PageInfo<Inventory>queryAllInventory(Integer pageNum,Inventory inventory)throws Exception;
	 public Detailed queryByStoId( Integer stoId)throws Exception; 
	 public Storage queryStorageByStoId( Integer stoId)throws Exception; 

}
