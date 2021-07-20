package com.ecomm.dao;

import java.util.List;

import com.ecomm.entity.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> getCategories();
	public Category getCategory(String categoryId);	
}
