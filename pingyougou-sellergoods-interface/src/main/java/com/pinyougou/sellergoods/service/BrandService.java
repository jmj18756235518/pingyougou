package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/***
 * 品牌类接口
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 展示所有的品牌
	 * 此接口提供给controller
	 * @return  所有品牌的集合
	 */
	List<TbBrand> findAll();
	
	/**
	 * 分页显示品牌列表
	 * @param currentPage  当前页
	 * @param rows 每页所显示的记录的条数
	 * @return
	 */
	PageResult findPage(int currentPage,int rows);
}
