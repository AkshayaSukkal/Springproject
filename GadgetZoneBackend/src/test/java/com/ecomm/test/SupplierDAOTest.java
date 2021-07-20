package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;

import com.ecomm.entity.Supplier;

public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier = new Supplier();
		
		supplier.setSupplierId("S1002");
		supplier.setSupplierName("Sudhir pvt Ltd");
		supplier.setSupplierAddress("Hyderabad");
		
		assertTrue("Problem occured while adding Supplier:",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier("S1001");
		supplier.setSupplierName("ABC Incorporation");
		supplier.setSupplierAddress("Kolkata");
		assertTrue("Problem occured while updating Supplier:",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplier()
	{
		Supplier supplier = supplierDAO.getSupplier("S1001");
		assertTrue("Problem occured while deleting Supplier:",supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void getSuppliers()
	{
		List<Supplier> supplierList = supplierDAO.getSuppliers();
		assertTrue("Problem occured while Retrieving Suppliers:",supplierList.size()>0);
		
		for(Supplier supplier : supplierList)
		{
			System.out.println("Supplier ID   : "+supplier.getSupplierId());
			System.out.println("Supplier Name : "+supplier.getSupplierName());
			System.out.println("Supplier Address : "+supplier.getSupplierAddress());
		}
	}
	@Test
	public void getSupplier()
	{
		Supplier supplier = supplierDAO.getSupplier("S1001");
		System.out.println("Supplier Id       : "+supplier.getSupplierId());
		System.out.println("Supplier Name     :  "+supplier.getSupplierName());
		System.out.println("Supplier Address  :  "+supplier.getSupplierAddress());
	}
}
