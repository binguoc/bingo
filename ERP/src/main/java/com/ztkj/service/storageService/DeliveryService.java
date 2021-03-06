package com.ztkj.service.storageService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.Order;
import com.ztkj.entity.storage.Delivery;
import com.ztkj.entity.storage.Storage;

public interface DeliveryService {

	PageInfo<Delivery> queryAllDelivery(Integer pageNum,Delivery delivery) throws Exception;

	boolean updateDeliveryDeStatic(Delivery delivery) throws Exception;

	List<Order> queryOrderIDStatic()throws Exception;

	List<Storage> queryAllStorage(Storage storage)throws Exception;

	Integer addDelivery(Delivery delivery)throws Exception;

	List<Delivery> queryByDid(Order order)throws Exception;

	
	//public Integer queryDelivery(Integer deId);
	
	//public List<Order> queryProductdetail(Integer deOrderId);


}
