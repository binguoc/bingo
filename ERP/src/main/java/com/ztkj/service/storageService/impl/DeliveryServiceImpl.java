package com.ztkj.service.storageService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.Order;
import com.ztkj.entity.market.Productdetail;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.storage.Delivery;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.InventoryVo;
import com.ztkj.entity.storage.Storage;
import com.ztkj.mapper.storageMapper.DeliveryMapper;
import com.ztkj.mapper.storageMapper.StockMapper;
import com.ztkj.service.storageService.DeliveryService;

import oracle.net.aso.p;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryMapper deliveryMapper;
	@Autowired
	private StockMapper stockMapper;

	@Override
	public PageInfo<Delivery> queryAllDelivery(Integer pageNum, Delivery delivery) throws Exception {

		Integer pageSize = 5;
		PageHelper.startPage(pageNum, pageSize);// 分页插件，专门用于myBatis分页
		List<Delivery> list = deliveryMapper.queryAllDelivery(delivery);
		PageInfo<Delivery> pageInfo = new PageInfo<Delivery>(list);
		return pageInfo;
	}

	@Override
	public boolean updateDeliveryDeStatic(Delivery delivery) throws Exception {
		
		Integer deId = delivery.getDeId();
		Integer deStatic = delivery.getDeStatic();
		String deMan = delivery.getDeMan();
		if (deStatic == 0 && "取消订单".equals(deMan)) {
			deliveryMapper. returnedGoods(delivery);
		}
		if (deStatic == 1 && "取消订单".equals(deMan)) {
			deliveryMapper. cancel(delivery);
		}
		if (deStatic == 2 && "取消订单".equals(deMan)) {
			deliveryMapper. cancel(delivery);
		}
		if (deStatic == 1 && "确认回款".equals(deMan)) {
			deliveryMapper. moneyBack(delivery);
		}
		
		boolean falg = true;
		int i = 0;
		if (deStatic == 0 && "发货".equals(deMan)) {
			List<Productdetail> productdetail = deliveryMapper.queryProductdetail(deId); // 查询订单详情信息 订单号f_did 类型 厂商
			List<Inventory> listInventorys = stockMapper.queryInventoryAndStorage();// 库存表
			for (Productdetail productdet : productdetail) {// 遍历明细表的相关
				for (Inventory inventory : listInventorys) {// 遍历库存表的相关
					if (inventory != null) {
						if (inventory.getStorage().getStId() == productdet.getStId()
								&& inventory.getFirm().getFiId() == productdet.getFirm().getFiId()
								&& inventory.getWares().getWaId() == productdet.getWares().getWaId()) {
							InventoryVo inventoryVo = new InventoryVo();
							Integer inId = inventory.getInId();
							Integer f_count = Integer.valueOf(productdet.getF_count().intValue());
							inventoryVo.setDeCount(f_count);
							inventoryVo.setInId(inId);
							
							if (inventory.getInNum() < f_count) {
								return false;
							}
							i = 0;
							break;
						} else {
							i++;
						}
					}
				}
				if (i == listInventorys.size() || listInventorys.size() == 0) {
					return false;
				}
			}
			if (falg) {
				
				for (Productdetail productdet : productdetail) {// 遍历明细表的相关
					for (Inventory inventory : listInventorys) {// 遍历库存表的相关
						if (inventory != null) {
							if (inventory.getStorage().getStId() == productdet.getStId()
									&& inventory.getFirm().getFiId() == productdet.getFirm().getFiId()
									&& inventory.getWares().getWaId() == productdet.getWares().getWaId()) {
								InventoryVo inventoryVo = new InventoryVo();
								Integer inId = inventory.getInId();
								Integer f_count = Integer.valueOf(productdet.getF_count().intValue());
								inventoryVo.setDeCount(f_count);
								inventoryVo.setInId(inId);
								deliveryMapper.sendGoods(inventoryVo);//修改库存
								deliveryMapper.send(delivery);//改变状态
								break;
							}
						}
					}
				}

			}
			
		}
		if (deStatic == 3 && "确认已退货".equals(deMan)) {
			List<Productdetail> productdetail = deliveryMapper.queryProductdetail(deId); // 查询订单详情信息 订单号f_did 类型 厂商
			List<Inventory> listInventorys = stockMapper.queryInventoryAndStorage();// 库存表
			for (Productdetail productdet : productdetail) {// 遍历明细表的相关
				for (Inventory inventory : listInventorys) {// 遍历库存表的相关
					if (inventory != null) {
						if (inventory.getStorage().getStId() == productdet.getStId()
								&& inventory.getFirm().getFiId() == productdet.getFirm().getFiId()
								&& inventory.getWares().getWaId() == productdet.getWares().getWaId()) {
							InventoryVo inventoryVo = new InventoryVo();
							Integer inId = inventory.getInId();
							Integer f_count = Integer.valueOf(productdet.getF_count().intValue());
							inventoryVo.setDeCount(f_count);
							inventoryVo.setInId(inId);
							deliveryMapper.revockGoods(inventoryVo);//修改库存
							deliveryMapper.returnedGoods(delivery);//改变状态
							break;
						}
					}
				}
			}
		}
		return falg;
	}

	@Override
	public List<Order> queryOrderIDStatic() throws Exception {
		List<Order> list = deliveryMapper.queryOrderIDStatic();
		return list;
	}

	@Override
	public List<Storage> queryAllStorage(Storage storage) throws Exception {
		List<Storage> list = deliveryMapper.queryAllStorage(storage);
		return list;
	}

	@Override
	public Integer addDelivery(Delivery delivery) throws Exception {
		Integer flag = deliveryMapper.addDelivery(delivery);
		return flag;
	}

	@Override
	public List<Delivery> queryByDid(Order order) throws Exception {
		List<Delivery> list = deliveryMapper.queryByDid(order);
		return list;
	}

	

}
