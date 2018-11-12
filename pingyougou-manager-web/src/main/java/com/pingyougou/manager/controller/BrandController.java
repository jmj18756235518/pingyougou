package com.pingyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.ExecuteResult;
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
/*	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody TbBrand tbBrand,int currentPage,int rows){
		
		PageResult pageResult = brandService.findPage(tbBrand,currentPage, rows);
		System.out.println("controller获取到的页面展示数据:"+pageResult);
		
		return pageResult;
	}*/
	/**
	 * 
	 * @param tbBrand
	 * @param currentPage
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int currentPage,int rows){
		
		PageResult pageResult = brandService.findPage(tbBrand,currentPage, rows);
		System.out.println("controller获取到的页面展示数据:"+pageResult);
		
		return pageResult;
	}
	
	/***
	 * 添加品牌
	 * @param tbBrand  页面封装的品牌对象
	 * @return
	 */
	@RequestMapping("/addBrand")
	public ExecuteResult addBrand(@RequestBody TbBrand tbBrand) {
		System.out.println(tbBrand);
		try {
			brandService.addBrand(tbBrand);
			return new ExecuteResult(true, "添加成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ExecuteResult(false,"添加失败");
		}
	}
	
	/**
	 * 根据Id查询到brand，实现页面回显功能
	 * @param id  品牌id
	 * @return 根据id查询到的品牌
	 */
	@RequestMapping("/findById")
	public TbBrand findById(Long id) {
		return brandService.findById(id);
	}
	
	/***
	 * 更新brand(需要加上@RequestBody注解，对页面提交的json数据进行解析)
	 * @param tbBrand 页面提交上来的品牌实体独对象
	 */
	@RequestMapping("/updateBrand")
	public ExecuteResult updataBrand(@RequestBody TbBrand tbBrand) {
		try {
			brandService.updateBrand(tbBrand);
			return new ExecuteResult(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ExecuteResult(false, "添加失败");
		}
	}
	

	/***
	 * 多选删除
	 * @param ids   删除的ids
	 * @return   删除的结果
	 */
	@RequestMapping("/delBrandBySel")
	public ExecuteResult delBrandBySel(Long ids[]) {
		
		try {
			brandService.delBrandBySel(ids);
			return new ExecuteResult(true,"删除成功");
		} catch (Exception e) {
		
			e.printStackTrace();
			return new ExecuteResult(false,"删除失败");
		}
	}
}
