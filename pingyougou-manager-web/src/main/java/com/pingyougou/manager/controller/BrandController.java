package com.pingyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	//远程调用interface
	@Reference
	BrandService brandService;
	
	/***
	 * 查询所有的品牌
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		
		return brandService.findAll();
	}

}
