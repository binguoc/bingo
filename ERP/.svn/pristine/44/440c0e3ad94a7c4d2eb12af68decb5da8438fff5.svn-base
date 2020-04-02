package com.ztkj.service.storageService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.Stock;
import com.ztkj.entity.storage.Storage;
import com.ztkj.mapper.storageMapper.InventoryMapper;
import com.ztkj.service.storageService.InventoryService;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryMapper inventoryMapper;

	@Override
	public PageInfo<Inventory> queryAllInventory(Integer pageNum,Inventory inventory) throws Exception {
		Integer pageSize = 5;
		PageHelper.startPage(pageNum, pageSize);//分页插件，专门用于myBatis分页
		List<Inventory> list = inventoryMapper.queryAllInventory(inventory);
		PageInfo<Inventory> pageInfo = new PageInfo<Inventory>(list);
		return pageInfo;
	}

	
   @Override 
   public Detailed queryByStoId(Integer stoId) throws Exception {
	   Detailed detailed = inventoryMapper.queryByStoId(stoId); 
	   return detailed;
	  }


	@Override
	public Storage queryStorageByStoId(Integer stoId) throws Exception {
		Storage storage = inventoryMapper.queryStorageByStoId(stoId);
		return storage;
	}
	 
}
