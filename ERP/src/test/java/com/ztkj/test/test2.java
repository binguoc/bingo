package com.ztkj.test;

import java.util.Date;

import org.junit.Test;

import com.ztkj.entity.purchase.Purchase;

public class test2 {
	@Test
	public void test333(){
		Purchase pu=new Purchase();
		pu.setPuTime(new Date());
		System.out.println(pu.getTime());
		
	}
}
