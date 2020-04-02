package com.ztkj.mapper.purchaseMapper;

import java.util.List;

import com.ztkj.entity.purchase.Brand;
import com.ztkj.entity.purchase.Warestype;

public interface WarestypeMapper {
	public List<Brand> queryAllBrands() throws Exception;
	public List<Warestype> queryWarestypeByPage(Warestype warestype) throws Exception;
	public Warestype queryWarestypeById(Warestype warestype) throws Exception;
	public void updateWarestype(Warestype warestype) throws Exception;
	public void addWarestype(Warestype warestype)throws Exception;
}
