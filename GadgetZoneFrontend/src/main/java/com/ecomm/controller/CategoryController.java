package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.entity.Category;

@Controller
public class CategoryController 
{
	
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/Category")
	public String showManageCategoryPage(Model m)
	{
		List<Category> categoryList = categoryDAO.getCategories();
		m.addAttribute("categoryList", categoryList);
		System.out.println("Manage Your Category");
		return "Category";
	}
	
	@RequestMapping(value="/insertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catId")String catId,@RequestParam("catName")String catName,@RequestParam("catDesc")String catDesc,Model m)
	{
		System.out.println("Category Id : "+catId);
		System.out.println("Category Name  :  "+catName);
		System.out.println("Category Desc  :  "+catDesc);
		
		Category category = new Category();
		category.setCategoryId(catId);
		category.setCategoryName(catName);
		category.setCategoryDesc(catDesc);
		
		categoryDAO.addCategory(category);
		
		System.out.println("Category Object is Added");
		List<Category> categoryList = categoryDAO.getCategories();
		m.addAttribute("categoryList", categoryList);
		System.out.println("Manage Your Category");
		return "Category";
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")String categoryId,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		List<Category> categoryList = categoryDAO.getCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")String categoryId,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		m.addAttribute("category", category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")String catId,@RequestParam("catName")String catName,@RequestParam("catDesc")String catDesc,Model m)
	{
		System.out.println("Category Id : "+catId);
		System.out.println("Category Name  :  "+catName);
		System.out.println("Category Desc  :  "+catDesc);
		
		Category category = categoryDAO.getCategory(catId);
		category.setCategoryName(catName);
		category.setCategoryDesc(catDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> categoryList = categoryDAO.getCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	

}
