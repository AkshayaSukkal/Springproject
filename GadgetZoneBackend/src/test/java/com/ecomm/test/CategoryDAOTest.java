package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.entity.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category = new Category();
		
		category.setCategoryId("C1004");
		category.setCategoryName("NokiaMobile");
		category.setCategoryDesc("All 4G Mobiles of Nokia");
		
		assertTrue("Problem occured while adding Category:",categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory("C1001");
		category.setCategoryName("XiomiMobile");
		category.setCategoryDesc("All Xiomi Mobiles");
		assertTrue("Problem occured while adding Category:",categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategory()
	{
		Category category = categoryDAO.getCategory("C1002");
		assertTrue("Problem occured while deleting Category:",categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void getCategories()
	{
		List<Category> categoryList = categoryDAO.getCategories();
		assertTrue("Problem occured while Retrieving Categories:",categoryList.size()>0);
		
		for(Category category : categoryList)
		{
			System.out.println("Category ID   : "+category.getCategoryId());
			System.out.println("Category Name : "+category.getCategoryName());
			System.out.println("Category Desc : "+category.getCategoryDesc());
		}
	}
	@Ignore
	@Test
	public void getCategory()
	{
		Category category = categoryDAO.getCategory("C1001");
		System.out.println("Category Id    : "+category.getCategoryId());
		System.out.println("Category Name  :  "+category.getCategoryName());
		System.out.println("Category Dest  :  "+category.getCategoryDesc());
	}
}
