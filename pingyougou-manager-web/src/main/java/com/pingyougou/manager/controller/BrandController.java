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
	 * 分页展示品牌
	 * @param currentPage   当前页面
	 * @param rows   每页显示的行数
	 * @return  每页应显示的记录数
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int currentPage,int rows){
		
		PageResult pageResult = brandService.findPage(currentPage, rows);
		System.out.println("controller获取到的页面展示数据:"+pageResult);
		
		return pageResult;
	}
	
	
}
