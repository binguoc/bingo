package com.ztkj.controller.storageController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.market.City;
import com.ztkj.entity.market.Province;
import com.ztkj.entity.storage.Storage;
import com.ztkj.entity.sys.User;
import com.ztkj.service.storageService.StorageService;

/**
 * 查询所有的仓库
 * 
 * @author binguo 2019年12月2日下午7:12:34
 */
@Controller
@RequestMapping({ "/storage/storage", "/storage/storageBrowse" })
public class StorageController {

	@Resource(name = "storageService")
	private StorageService storageService;

	/**
	 * 查询所有的仓库
	 * 
	 * @param storage
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryAllStorage.action")
	@ResponseBody
	public PageInfo<Storage> queryAllStorage(Storage storage, Integer pageNum) {
		pageNum = pageNum == null ? 1 : pageNum;
		try {
			PageInfo<Storage> pageInfo = storageService.queryAllStorage(pageNum, storage);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	/**
	 * 查询所有的仓库的浏览    storageBrowse.html   仓库浏览模块
	 * 
	 * @param storage
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryStorageBrowse.action")
	@ResponseBody
	public PageInfo<Storage> queryStorageBrowse(Storage storage, Integer pageNum) {
		pageNum = pageNum == null ? 1 : pageNum;
		try {
			PageInfo<Storage> pageInfo = storageService.queryAllStorage(pageNum, storage);
			return pageInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	

	/**
	 * 注销仓库
	 * 
	 * @param storage
	 * @return
	 */
	@RequestMapping("/cancelStorage.action")
	@ResponseBody
	public Integer cancelStorage(Storage storage) {
		try {
			Integer flag = storageService.cancelStorage(storage);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 恢复Storage仓库
	 * 
	 * @param storage
	 * @return
	 */
	@RequestMapping("/recoverStorage.action")
	@ResponseBody
	public Integer recoverStorage(Storage storage) {
		try {
			Integer flag = storageService.recoverStorage(storage);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 详情回选
	 * 
	 * @param storage
	 * @return
	 */
	@RequestMapping("/queryStorageById.action")
	@ResponseBody
	public List<Storage> queryStorageById(Storage storage) {
		try {
			List<Storage> list = storageService.queryStorageById(storage);
			return list;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 省的查询
	 * 
	 * @return
	 */
	@RequestMapping("/selectByProvince.action")
	@ResponseBody
	public List<Province> selectByProvince(Province province) {
		try {
			List<Province> list = storageService.selectByProvince(province);
			return list;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 市的查询
	 * 
	 * @param ssid
	 * @return
	 */
	@RequestMapping("/selectByCity.action")
	@ResponseBody
	public List<City> selectByCity(City city) {
		try {
			List<City> list = storageService.selectByCity(city);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 只能是财务部仓库管理员职位
	 * @param storage
	 * @return
	 */
	@RequestMapping("/queryUserPosition.action")
	@ResponseBody
	public List<User>  queryUserPosition() {
		try {
			List<User> list = storageService.queryUserPosition();
			return list;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加仓库
	 * @param storage
	 * @return
	 */
	@RequestMapping("/addStorage.action")
	@ResponseBody
	public Integer addStorage(Storage storage) {
		 try {
			 Integer flag  = storageService.addStorage(storage);
			 return flag;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 修改仓库的回选
	 * @param storage
	 * @return
	 */
	@RequestMapping("/queryByStId.action")
	@ResponseBody
	public List<Storage> queryByStId(Storage storage) {
		try {
			List<Storage> list = storageService.queryByStId(storage);
			return list;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改仓库
	 * @param storage
	 * @return
	 */
	@RequestMapping("/updateStorage.action")
	@ResponseBody
	public Integer updateStorage(Storage storage) {
		 try {
			 Integer flag  = storageService.updateStorage(storage);
			 return flag;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
