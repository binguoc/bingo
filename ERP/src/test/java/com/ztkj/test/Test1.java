package com.ztkj.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.TestBean;
import com.ztkj.entity.storage.Delivery;
import com.ztkj.entity.storage.Inventory;
import com.ztkj.entity.storage.Stock;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.User;
import com.ztkj.service.marketService.TestService;

import com.ztkj.service.storageService.DeliveryService;
import com.ztkj.service.storageService.InventoryService;
import com.ztkj.service.storageService.StockService;
import com.ztkj.service.storageService.StorageService;

import com.ztkj.tools.MyDateConvert;

public class Test1 {
	@Test
	public void Test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-service.xml","applicationContext-dao.xml");
		TestService testService =(TestService) context.getBean("testService");
		try {
			List<TestBean> selectTest = testService.selectTest();
			for (TestBean testBean : selectTest) {
				System.out.println(testBean);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	
	@Test
	public void Test2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-service.xml","applicationContext-dao.xml");
		StorageService bean = context.getBean(StorageService.class);
		try {
			List<User> list = bean.queryUserPosition();
			for (User user : list) {
				System.out.println(user);
				
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	
	
	

	@Test
	public void Test21() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(date);
	}

}
