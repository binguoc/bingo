package com.ztkj.service.marketService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.Client;
import com.ztkj.entity.market.Order;
import com.ztkj.entity.market.Productdetail;
import com.ztkj.entity.market.ProductdetailVO;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Firm;
import com.ztkj.entity.purchase.Wares;
import com.ztkj.entity.purchase.Warestype;
import com.ztkj.entity.sys.Position;
import com.ztkj.entity.sys.User;

public interface OrderService {

	PageInfo<Order> selectByPage(Order order, Integer pageNum)throws Exception;

	List<Client> selectAllClient(User user)throws Exception;

	List<Brand> selectAllBrand()throws Exception;

	List<Warestype> selectAllWarestype(Integer brId)throws Exception;

	List<Wares> selectAllWares(Integer waId)throws Exception;

	List<Firm> selectAllFirm(Integer waId)throws Exception;

	void addOrder(Order order)throws Exception;

	void addProductdetail(ProductdetailVO pVo)throws Exception;

	Order selectById(Order order)throws Exception;

	List<Productdetail> selectDalByDId(Productdetail productdetail)throws Exception;

	void updateProductdetail(ProductdetailVO pVo)throws Exception;

	void deleteOrder(Order order)throws Exception;

	PageInfo<Order> selectAllOrderExaminee(Order order, Integer pageNum)throws Exception;

	void updateOrderExamine(Order order)throws Exception;

	List<Position> selectPosition()throws Exception;

	List<User> selectUserById(User user)throws Exception;

	void updateOrderStatus(Order order)throws Exception;
	

}
