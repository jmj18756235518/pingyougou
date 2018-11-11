package com.pingyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	//远程依赖service
	@Reference
	BrandService brandService;
	
	/***
	 * 展示所有的品牌
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		
		return brandService.findAll();
	}
	
	/***
	 * 分页显示品牌列表
	 * 使用mybatis中的分页插件PageHelper
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int currentPage,int rows) {
		
		PageResult pageResult = brandService.findPage(currentPage, rows);
		System.out.println("controller :  "+pageResult);
		return pageResult;
	}

}
