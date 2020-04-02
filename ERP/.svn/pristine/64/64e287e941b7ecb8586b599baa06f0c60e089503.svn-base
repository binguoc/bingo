package com.ztkj.service.purchaseService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Wares;
import com.ztkj.entity.purchase.Warestype;

public interface WaresService {
	public List<Brand> queryAllBrands() throws Exception;

	public PageInfo<Wares> queryWaresByPage(Wares wares,Integer pageNum) throws Exception;

	public Wares queryWaresById(Wares wares) throws Exception;

	public void updateWares(Wares wares) throws Exception;

	public void addWares(Wares wares) throws Exception;

	public List<Warestype> queryWarestypeByBrId(Warestype warestype) throws Exception;

}
