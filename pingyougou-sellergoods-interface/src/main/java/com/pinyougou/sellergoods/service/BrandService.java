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
	PageResult findPage(TbBrand tbBrand,int currentPage,int rows);
	

	/**
	 * 添加品牌
	 * @param tbBrand 页面提交过来的封装的品牌对象
	 */
	void addBrand(TbBrand tbBrand);
	
	/**
	 * 根据Id查询品牌，实现页面的回显功能
	 * @param id
	 * @return
	 */
	TbBrand findById(Long id);
	
	
	/***
	 * 更新品牌
	 * @param tbBrand  页面传递递交过来的品牌对象
	 */
	void updateBrand(TbBrand tbBrand);
	
	/***
	 * 多选删除
	 * @param ids 删除的id数组
	 */
	void delBrandBySel(Long ids[]);
}
