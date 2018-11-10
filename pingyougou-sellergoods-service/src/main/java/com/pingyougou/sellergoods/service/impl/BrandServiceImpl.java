package com.pingyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

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

}
