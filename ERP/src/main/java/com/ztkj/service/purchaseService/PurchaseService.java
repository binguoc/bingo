package com.ztkj.service.purchaseService;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.purchase.Firm;
import com.ztkj.entity.purchase.PuAndDeVo;
import com.ztkj.entity.purchase.Purchase;
import com.ztkj.entity.purchase.PurchaseAudutVo;
import com.ztkj.entity.purchase.PurchaseVo;
import com.ztkj.entity.purchase.Wares;
import com.ztkj.entity.purchase.Warestype;
import com.ztkj.entity.sys.Dept;
import com.ztkj.entity.sys.User;

public interface PurchaseService {
	PageInfo<PurchaseVo> queryByPurchase(PurchaseVo purchaseVo) throws Exception;
	Purchase queryByOnePurchase(String puRealid) throws Exception;
	List<Detailed> queryByOneDetailed(String puRealid) throws Exception;
	void deletePurchase(String puRealid) throws Exception;
	List<Brand> queryAllBrname() throws Exception;
	int queryMaxId(String dateTime) throws Exception;
	List<Warestype> queryByAllTypename(Integer brId) throws Exception;
	List<Wares> queryByAllWaname(Integer waWarestypeid) throws Exception;
	List<Firm> queryByAllFiname() throws Exception;
	void addPurchase(Purchase purchase) throws Exception;
	void addDetailed(List<Detailed> list) throws Exception;
	User queryNameid(String userName) throws Exception;
	void updateDetailed(List<Detailed> list) throws Exception;
	PageInfo<PurchaseVo> queryStatus(PurchaseVo purchaseVo, String userName) throws Exception;
	void updateStatus(Purchase purchase) throws Exception;
	List<PurchaseAudutVo> queryAllAudut() throws Exception;
	void updateStatusAndUser(Purchase purchase) throws Exception;
	void deleteDetailed(Purchase purchase) throws Exception;
	void updatePurchase(Purchase purchase) throws Exception;
	List<PurchaseAudutVo> queryAllUser(PurchaseAudutVo userVo) throws Exception;
}
