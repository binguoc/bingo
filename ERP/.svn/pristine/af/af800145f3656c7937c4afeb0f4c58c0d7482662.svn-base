package com.ztkj.service.marketService.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
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
import com.ztkj.mapper.marketMapper.OrderMapper;
import com.ztkj.service.marketService.OrderService;



@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private Integer pageSize = 5;
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public PageInfo<Order> selectByPage(Order order, Integer pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Order> list=orderMapper.selectByPage(order);
		PageInfo<Order> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Client> selectAllClient(User user) throws Exception {
		
		return orderMapper.selectAllClient(user);
	}

	@Override
	public List<Brand> selectAllBrand() throws Exception {
		return orderMapper.selectAllBrand();
	}

	@Override
	public List<Warestype> selectAllWarestype(Integer brId) throws Exception {
		// TODO 自动生成的方法存根
		return orderMapper.selectAllWarestype(brId);
	}

	@Override
	public List<Wares> selectAllWares(Integer waId) throws Exception {
		// TODO 自动生成的方法存根
		return orderMapper.selectAllWares(waId);
	}

	@Override
	public List<Firm> selectAllFirm(Integer waId) throws Exception {
		// TODO 自动生成的方法存根
		return orderMapper.selectAllFirm(waId);
	}

	@Override
	public void addOrder(Order order) throws Exception {
		orderMapper.addOrder(order);
		
	}

	@Override
	public void addProductdetail(ProductdetailVO pVo) throws Exception {
		orderMapper.addProductdetail(pVo);
		
	}

	@Override
	public Order selectById(Order order) throws Exception {
		
		return orderMapper.selectById(order);
	}

	@Override
	public List<Productdetail> selectDalByDId(Productdetail productdetail) throws Exception {
		// TODO 自动生成的方法存根
		return orderMapper.selectDalByDId(productdetail);
	}

	@Override
	public void updateProductdetail(ProductdetailVO pVo) throws Exception {
		orderMapper.updateProductdetail(pVo);
		int[] f_ids = pVo.getF_ids();
		if (f_ids!=null) {
			orderMapper.deleteProductdetail(pVo);
		}
		List<Productdetail> list = pVo.getList();
		int flag=0;
		for (Productdetail productdetail : list) {
			if (productdetail.getF_id()==null) {
				flag++;
			}
		}
		if (flag>0) {
			orderMapper.addProductdetail2(pVo);
		}
	}

	@Override
	public void deleteOrder(Order order) throws Exception {
		orderMapper.deleteProductdetailByDid(order);
		orderMapper.deleteOrder(order);
		
	}

	@Override
	public PageInfo<Order> selectAllOrderExaminee(Order order, Integer pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Order> list=orderMapper.selectAllOrderExaminee(order);
		PageInfo<Order> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public void updateOrderExamine(Order order) throws Exception {
		orderMapper.updateOrderExamine(order);
		
	}

	@Override
	public List<Position> selectPosition() throws Exception {
		return orderMapper.selectPosition();
	}

	@Override
	public List<User> selectUserById(User user) throws Exception {
		// TODO 自动生成的方法存根
		return orderMapper.selectUserById(user);
	}

	@Override
	public void updateOrderStatus(Order order) throws Exception {
		orderMapper.updateOrderStatus(order);
		
	};
	
}
