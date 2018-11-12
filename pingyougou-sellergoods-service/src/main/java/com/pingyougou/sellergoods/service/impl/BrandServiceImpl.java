package com.pingyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
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
	public PageResult findPage(	TbBrand tbBrand,int currentPage, int rows) {
		//根据这两个从页面获得的参数使用PageHapler进行分页处理
		PageHelper.startPage(currentPage,rows);
		
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		
		//如果对象不为空，说明页面有值传递过来，必定是执行搜索的功能
		if(tbBrand != null) {
			if(tbBrand.getName() != null && tbBrand.getName().length() > 0) {
				criteria.andNameLike(tbBrand.getName());
			}
			//首字母采用的是equalsTo，因为每个手机品牌的首字母都只有一位，所以不存在 模糊查询
			if(tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() >0) {
				criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
			}
		}
		
		Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
		long total = page.getTotal();   //获得总页数
		List<TbBrand> list = page.getResult();   //获得的当前页面显示的集合
	
		return new PageResult(total,list);
	}

	/**
	 * 添加品牌
	 */
	@Override
	public void addBrand(TbBrand tbBrand) {
		tbBrandMapper.insert(tbBrand);
	}

	/**
	 * 根据Id查询品牌，实现页面回显功能
	 */
	@Override
	public TbBrand findById(Long id) {
		TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
		return tbBrand;
	}

	/**
	 * 更新tbBrand
	 */
	@Override
	public void updateBrand(TbBrand tbBrand) {
		//根据id更新brand
		tbBrandMapper.updateByPrimaryKey(tbBrand);
	}

	/**
	 * 多选删除
	 */
	@Override
	public void delBrandBySel(Long ids[]) {
		//遍历ids数组，遍历删除
		for (Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
	}


}
