package com.ztkj.service.storageService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.purchase.Purchase;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.InventoryVo;
import com.ztkj.entity.storage.Stock;
import com.ztkj.entity.storage.Storage;
import com.ztkj.mapper.storageMapper.InventoryMapper;
import com.ztkj.mapper.storageMapper.StockMapper;
import com.ztkj.service.storageService.StockService;

@Service("stockService")
public class StockServiceImpl implements StockService {


	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private InventoryMapper inventoryMapper;
/**
 * 分页查询所有的入库信息
 * @return
 */	
	@Override 
	public PageInfo<Stock> queryAllStock(Integer pageNum,Stock stock) throws Exception {
		pageNum = pageNum==null ? 1 : pageNum;
		Integer pageSize = 5;
		PageHelper.startPage(pageNum, pageSize);//分页插件，专门用于myBatis分页
		List<Stock> list = stockMapper.queryAllStock(stock);
		PageInfo<Stock> pageInfo = new PageInfo<Stock>(list);
		return pageInfo;
	}

	@Override
	public void cancelStatic(Stock stock)throws Exception{
		String puRealid = stockMapper.queryPurchase(stock.getStoId());  
		 Integer stId = stockMapper.queryStorage(stock.getStoId());
		 List<Inventory> listInventorys = stockMapper.queryInventoryAndStorage();//库存表
		 List<Detailed> listDetaileds = stockMapper.queryDetailed(puRealid);
		 for (Detailed detailed : listDetaileds) {//遍历明细表的相关
				for (Inventory inventory : listInventorys) {//遍历库存表的相关
					if(inventory!=null) {
						if(inventory.getStorage().getStId()==stId  && String.valueOf(inventory.getWares().getWaId()).equals(detailed.getWaresid())
								&& String.valueOf(inventory.getFirm().getFiId()).equals(detailed.getFirmid())) {
							InventoryVo inventoryVo =new InventoryVo();
							Integer inId = inventory.getInId();
							Integer deCount = detailed.getDeCount();
							inventoryVo.setDeCount(deCount);
							inventoryVo.setInId(inId);
							stockMapper.cancelStock(inventoryVo);
							break;
						}
				    }
			    } 
		 }
		 stockMapper.cancelStatic(stock);
	}
	@Override
	public void recoverStatic(Stock stock)throws Exception{
		
		if(stock.getStoStatic()==0) {
			 int i=0;
			 String puRealid = stockMapper.queryPurchase(stock.getStoId());  
			 Integer stId = stockMapper.queryStorage(stock.getStoId());
			 List<Inventory> listInventorys = stockMapper.queryInventoryAndStorage();//库存表
			 List<Detailed> listDetaileds = stockMapper.queryDetailed(puRealid);
			
			 for (Detailed detailed : listDetaileds) {//遍历明细表的相关
				 
					for (Inventory inventory : listInventorys) {//遍历库存表的相关
						if(inventory!=null) {
							if(inventory.getStorage().getStId()==stId  && String.valueOf(inventory.getWares().getWaId()).equals(detailed.getWaresid())
									&& String.valueOf(inventory.getFirm().getFiId()).equals(detailed.getFirmid())) {
								InventoryVo inventoryVo =new InventoryVo();
								Integer inId = inventory.getInId();
								Integer deCount = detailed.getDeCount();
								inventoryVo.setDeCount(deCount);
								inventoryVo.setInId(inId);
								stockMapper.updateInventory( inventoryVo);
								i=0;
								break;
							}else {
								i++;
							}
							if(i==listInventorys.size()|| listInventorys.size()==0) {
								i=0;
								inventory.setFirmId(new Integer(detailed.getFirmid()));
								inventory.setStoId(stId);
								inventory.setWaseId(new Integer(detailed.getWaresid()));
								inventory.setInNum(detailed.getDeCount());
								stockMapper.addInventory(inventory);
							
							}
					}
				}
			}
		}
		stockMapper.recoverStatic(stock);
	}

	
	
	
	@Override
	public List<Storage> queryAllStorage(Storage storage) throws Exception {
		 List<Storage> list = stockMapper.queryAllStorage(storage);
		return list;
	}

	@Override
	public List<Purchase> queryAllPurchase() throws Exception {
		 List<Purchase> list = stockMapper.queryAllPurchase();
		return list;
	}
	
	@Override
	public Integer addStock(Stock stock) throws Exception {
		Integer addStock = stockMapper.addStock(stock);
		  return addStock;
	}

	@Override
	public List<Stock> queryByPuRealid(Purchase purchase) throws Exception {
		List<Stock> list = stockMapper.queryByPuRealid(purchase);
		return list;
	}

	

	
}
