package com.ztkj.controller.storageController;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Detailed;
import com.ztkj.entity.purchase.PuAndDeVo;
import com.ztkj.entity.purchase.Purchase;
import com.ztkj.entity.storage.Stock;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.User;
import com.ztkj.service.purchaseService.PurchaseService;
import com.ztkj.service.storageService.StockService;

/**
 * 
 * @author binguo
 * 2019年12月1日下午2:45:34
 */
@Controller
@RequestMapping("/storage/stock")    //窄化请求路径
public class StockController {

	@Resource(name="stockService")    //注入StockService 
	private StockService stockService;
	@Resource(name="purchaseService")    //注入purchaseService
	private PurchaseService purchaseService;
	/**
	 * 分页查询所有的Stock 入库信息
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryAllStock.action")   //映射请求路径
	@ResponseBody
	public PageInfo<Stock>  queryAllStorage(Integer pageNum,Stock stock) {
		pageNum = pageNum==null ? 1 : pageNum;
		try {
			PageInfo<Stock> pageInfo = stockService.queryAllStock(pageNum,stock);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/recoverStatic.action")
	@ResponseBody
	public Integer recoverStatic(Stock stock){
		try {
			stockService.recoverStatic(stock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 取消入库
	 * @param stock
	 * @return
	 */
	@RequestMapping("/cancelStatic.action")
	@ResponseBody
	public Integer cancelStatic(Stock stock){
		try {
			 stockService.cancelStatic(stock);
			
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
			List<Storage> list = stockService.queryAllStorage(storage);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 查询所有审核通过的采购单
	 * @return
	 */
	@RequestMapping("/queryAllPurchase.action")
	@ResponseBody
	public List<Purchase> queryAllPurchase(){
		try {
			List<Purchase> list = stockService.queryAllPurchase();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

/**
 * 添加入库信息
 * @param stock
 * @return
 */
	@RequestMapping("/addStock.action")
	@ResponseBody
	public Integer addStock(Stock stock) {
		 try {
			 System.out.println(stock);
			 Integer flag=stockService.addStock(stock);
			 return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 采购详情+入库信息
	 * @return
	 */
	@RequestMapping("/queryByPuRealid.action")
	@ResponseBody
	public List<Stock>queryByPuRealid(Purchase purchase){
		try {
			List<Stock> list = stockService.queryByPuRealid(purchase);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/queryByOnePuAndDeVo.action")
	@ResponseBody
	public PuAndDeVo queryByOnePuAndDeVo(String puRealid) {
		PuAndDeVo vo=new PuAndDeVo();
		try {
			Purchase purchase = purchaseService.queryByOnePurchase(puRealid);
			List<Detailed> list = purchaseService.queryByOneDetailed(puRealid);
			vo.setPurchase(purchase);
			vo.setDeList(list);
		} catch (Exception e) { 
			// TODO Auto-generated catch block e.printStackTrace();
		}
		return vo;
	}
	
	
}
