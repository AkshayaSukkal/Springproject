package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.ProductDAO;
import com.ecomm.entity.Product;

@Controller
public class ProductController 
{

	@Autowired
	ProductDAO ProductDAO;
	@RequestMapping("/product")
	public String showProductpage(Model m)
	{
		List<Product> productList=ProductDAO.getProducts();
		m.addAttribute("productList",productList);
		return"Product";
	}
@RequestMapping(value="/insertProduct",method=RequestMethod.POST)
public String insertProduct(@RequestParam("proId")int proId,@RequestParam("proName")String proName,@RequestParam("proDesc")String proDesc,Model m)
{
	System.out.println("ProductId:"+proId);
	System.out.println("Product Name:"+proName);
	System.out.println("Product Desc:"+proDesc);
	
	Product product=new Product();
	product.setProductId(proId);
	product.setProductName(proName);
	product.setProductDesc(proDesc);
	
	ProductDAO.addProduct(product);
	System.out.println("Product Object Added");
	List<Product> productList=ProductDAO.getProducts();
	m.addAttribute("productList",productList);
	return"Product";
}

@RequestMapping("/deleteProduct/{productId}")
public String deleteProduct(@PathVariable("ProductId")int productId,Model m)
{
	Product product = ProductDAO.getProduct(productId);
	ProductDAO.deleteProduct(product);
	List<Product> productList =ProductDAO.getProducts();
	m.addAttribute("productList", productList);
	
	return "Product";
}
@RequestMapping("/editProduct/{productId}")
public String editProduct(@PathVariable("productId")int productId,Model m)
{
	Product product = ProductDAO.getProduct(productId);
	m.addAttribute("product",product);
	return "UpdateProduct";
}
@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
public String updateCategory(@RequestParam("proId")int proId,@RequestParam("proName")String proName,@RequestParam("proDesc")String proDesc,Model m)
{
	System.out.println("Product Id:"+proId);
	System.out.println("Product Name:"+proName);
	System.out.println("Product Desc:"+proDesc);
	
	
	Product product = ProductDAO.getProduct(proId);
	product.setProductName(proName);
    product.setProductDesc(proDesc);
	ProductDAO.updateProduct(product);

	List<Product> productList = ProductDAO.getProducts();
	m.addAttribute("productList", productList);
	
	return "Prodcut";
}

}