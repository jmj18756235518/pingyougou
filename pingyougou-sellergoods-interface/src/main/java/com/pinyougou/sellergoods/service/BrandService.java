package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

/***
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 展示所有的品牌
	 * @return
	 */
	List<TbBrand> findAll();
}
