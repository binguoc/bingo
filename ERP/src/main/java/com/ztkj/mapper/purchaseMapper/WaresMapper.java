package com.ztkj.mapper.purchaseMapper;

import java.util.List;

import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Wares;
import com.ztkj.entity.purchase.Warestype;

public interface WaresMapper {
	public List<Brand> queryAllBrandsWares() throws Exception;
	public List<Wares> queryWaresByPage(Wares wares) throws Exception;
	public Wares queryWaresById(Wares wares) throws Exception;
	public void updateWares(Wares wares) throws Exception;
	public void addWares(Wares wares)throws Exception;
	public List<Warestype> queryWarestypeByBrId(Warestype warestype);
}
