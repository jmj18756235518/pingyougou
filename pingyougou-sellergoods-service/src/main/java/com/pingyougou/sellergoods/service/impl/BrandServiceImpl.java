package com.pingyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@Service
public class BrandServiceImpl implements BrandService {

	//注入dao，品牌接口依赖于品牌的dao
	@Autowired
	TbBrandMapper tbBrandMapper;
	
	/**
	 * 查询所有的品牌
	 */
	@Override
	public List<TbBrand> findAll() {
		
		return tbBrandMapper.selectByExample(null);
	}

	/***
	 * 分页展示品牌列表
	 * currentPage 当前页
	 * rows 每页显示的条数
	 */
	@Override
	public PageResult findPage(int currentPage, int rows) {
		//根据这两个从页面获得的参数使用PageHapler进行分页处理
		PageHelper.startPage(currentPage,rows);
		Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
		long total = page.getTotal();   //获得总页数
		List<TbBrand> list = page.getResult();   //获得的当前页面显示的集合
	
		return new PageResult(total,list);
	}


}
