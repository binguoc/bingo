package com.ztkj.mapper.storageMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.purchase.Purchase;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.InventoryVo;
import com.ztkj.entity.storage.Stock;
import com.ztkj.entity.storage.Storage;

public interface StockMapper {
/**
 * 分页查询所有的入库信息
 * @return
 */
	public List<Stock> queryAllStock(Stock stock);
/**
 * 入库与取消操作
 * @param stock
 * @return
 */
    
    public Integer cancelStatic(Stock stock);
    public Integer recoverStatic(Stock stock);
/**
 * 查询所有启用的仓库    
 * @return
 */
    public List<Storage> queryAllStorage(Storage storage);
/**
 * 查询所有审核通过的采购单    
 * @return
 */
	public List<Purchase> queryAllPurchase();
/**
 * 添加入库	
 * @param stock
 * @return
 */
   public Integer addStock(Stock stock);
   
   public List<Stock> queryByPuRealid(Purchase purchase);
   
 
   public Integer queryStorage(@Param("stoId") Integer stoId);
   
   public String queryPurchase(@Param("stoId") Integer stoId);
   
   
   public List<Detailed> queryDetailed(@Param("puRealid") String puRealid);
   
   public void updateInventory(InventoryVo inventoryVo);
   
   public void addInventory(Inventory inventory);
   
   public void cancelStock(InventoryVo inventoryVo);
   
   public List<Inventory> queryInventoryAndStorage();
}
