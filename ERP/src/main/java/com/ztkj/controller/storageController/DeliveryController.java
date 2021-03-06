package com.ztkj.controller.storageController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.Order;
import com.ztkj.entity.market.Productdetail;
import com.ztkj.entity.storage.Delivery;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.Position;
import com.ztkj.service.marketService.OrderService;
import com.ztkj.service.storageService.DeliveryService;

import oracle.net.aso.d;


/**
 * 
 * @author binguo
 * 2019年12月4日下午9:18:27
 */
@Controller
@RequestMapping("/storage/delivery")
public class DeliveryController {
	

	@Resource(name = "deliveryService")
	private DeliveryService deliveryService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	

	/**
	 * 查询所有的出库表
	 * 
	 * @param delivery
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryAllDelivery.action")
	@ResponseBody
	public PageInfo<Delivery> queryAllDelivery(Integer pageNum,Delivery delivery) {
		pageNum = pageNum==null ? 1 : pageNum;
		try {
			PageInfo<Delivery> pageInfo = deliveryService.queryAllDelivery(pageNum, delivery);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 操作修改状态方法
	 * @param delivery
	 * @return
	 */
	@RequestMapping("/updateDeliveryDeStatic.action")
	@ResponseBody
	public boolean updateDeliveryDeStatic(Delivery delivery) {
		try {
			boolean flag = deliveryService.updateDeliveryDeStatic(delivery);
			return flag;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	
/**
 * 查询通过审核的
 * @return
 */
	@RequestMapping("/queryOrderIDStatic.action")
	@ResponseBody
	public List<Order> queryOrderIDStatic(Order order){
		try {
			List<Order> list = deliveryService.queryOrderIDStatic();
			return list;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 查询所有的仓库	
	 * @return
	 */
		@RequestMapping("/queryAllStorage.action")
		@ResponseBody
		public List<Storage> queryAllStorage(Storage storage) {
			try {
				List<Storage> list = deliveryService.queryAllStorage(storage);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		/**
		 * 添加出库记录
		 * @param delivery
		 * @return
		 */
		@RequestMapping("/addDelivery.action")
		@ResponseBody
		public Integer addDelivery(Delivery delivery) {
			 try {
				 Integer flag  = deliveryService.addDelivery(delivery);
				 return flag;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return null;
			
		}

		/**
		 * 查看详情+出库信息
		 * @return
		 */
		@RequestMapping("/queryByDid.action")
		@ResponseBody
		public List<Delivery> queryByDid(Order order){
			try {
				List<Delivery> list = deliveryService.queryByDid(order);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * 查看详情
		 * @param order
		 * @return
		 */
		
		@RequestMapping("/order_selectById.action")
		@ResponseBody
		public Order selectById(Order order){
			try {
				Order order2 = orderService.selectById(order);
				return order2;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		};
		/**
		 * 查看订单细节
		 * @param productdetail
		 * @return
		 */
		@RequestMapping("/order_selectDalByDId.action")
		@ResponseBody
		public List<Productdetail> selectDalByDId(Productdetail productdetail){
			try {
				List<Productdetail> list = orderService.selectDalByDId(productdetail);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		

}
