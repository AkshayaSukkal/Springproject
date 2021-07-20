
package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.entity.Category;
import com.ecomm.entity.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO SupplierDAO;
	
	@RequestMapping("/supplier")
	public String showManageSupplierPage(Model m)
	{
		List<Supplier> supplierList = SupplierDAO.getSuppliers();
		m.addAttribute("supplierList", supplierList);
		System.out.println("Manage Your Supplier");
		return "Supplier";
	}
	
	@RequestMapping(value="/insertSupplier",method=RequestMethod.POST)
	public String addSupplier(@RequestParam("suplId")String suplId,@RequestParam("suplName")String suplName,@RequestParam("suplAddr")String suplAddr,Model m)
	{
		
		Supplier supplier = new Supplier();
		
		supplier.setSupplierId(suplId);
		supplier.setSupplierName(suplName);
		supplier.setSupplierAddress(suplAddr);
		
		SupplierDAO.addSupplier(supplier);
		
		System.out.println("Supplier Object is Added");
		List<Supplier> supplierList = SupplierDAO.getSuppliers();
		m.addAttribute("supplierList", supplierList);
		System.out.println("Manage Your Supplier");
		return "Supplier";
	}
	
	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")String supplierId,Model m)
	{
		Supplier supplier = SupplierDAO.getSupplier(supplierId);
		SupplierDAO.deleteSupplier(supplier);
		List<Supplier> supplierList = SupplierDAO.getSuppliers();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
	
	@RequestMapping("/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")String supplierId,Model m)
	{
		Supplier supplier = SupplierDAO.getSupplier(supplierId);
		m.addAttribute("supplier", supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("suplId")String suplId,@RequestParam("suplName")String suplName,@RequestParam("suplAddr")String suplAddr,Model m)
	{
		System.out.println("Supplier Id       : "+suplId);
		System.out.println("Supplier Name     :  "+suplName);
		System.out.println("Supplier Address  :  "+suplAddr);
		
		Supplier supplier = SupplierDAO.getSupplier(suplId);
		supplier.setSupplierName(suplName);
		supplier.setSupplierAddress(suplAddr);
		
		SupplierDAO.updateSupplier(supplier);
		
		List<Supplier> supplierList = SupplierDAO.getSuppliers();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}
}