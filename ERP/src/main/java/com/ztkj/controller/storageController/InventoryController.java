package com.ztkj.controller.storageController;
/**
 * 
 * @author binguo
 * 2019年12月6日上午9:09:10
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.service.storageService.InventoryService;

@Controller
@RequestMapping("/storage/inventory")
public class InventoryController {
	
	@Resource(name="inventoryService")
	private InventoryService inventoryService;

	/**
	 * 查询所有的库存信息
	 * @return
	 */
	@RequestMapping("/queryAllInventory.action")
	@ResponseBody
	public PageInfo<Inventory> queryAllInventory(Integer pageNum,Inventory inventory){
		pageNum = pageNum==null ? 1 : pageNum;
		try {
			PageInfo<Inventory> pageInfo = inventoryService.queryAllInventory(pageNum,inventory);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
