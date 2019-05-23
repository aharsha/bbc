package com.harsha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.harsha.daoimpl.CategoryDaoImpl;
import com.harsha.daoimpl.SupplierDaoImpl;
import com.harsha.model.Category;
import com.harsha.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	

	@RequestMapping(value="/supplier", method=RequestMethod.GET)
	public ModelAndView goToSupplierForm()
	{
		ModelAndView  mv=new ModelAndView("supplier");
		
		
		mv.addObject("sup",new Supplier());
		mv.addObject("bname","AddSupplier");
		return  mv;
	}
	
	@RequestMapping(value="/addSup",method=RequestMethod.POST)
	public ModelAndView recieveSupplierFormData(@ModelAttribute ("sup") Supplier supplier)
	{
		ModelAndView  mv=new ModelAndView("home");
	    supplierDaoImpl.saveSupplier(supplier);
		return mv;
	}
	
	@RequestMapping("/showsupp")
	public ModelAndView retrieveCategory()
	{
	ModelAndView  modelAndView=new ModelAndView("showsupplier");
	List<Supplier> supplierList = supplierDaoImpl.retrieveAllSuppliers();	
	modelAndView.addObject("supList",supplierList);
	return modelAndView;
	}
	
	@RequestMapping("/delsupp")
	public ModelAndView deleteSupplier(@RequestParam("supId") int supplierId)
	{
		System.out.println(supplierId);
		
		Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
		supplierDaoImpl.deleteSupplier(supplier);
		
		ModelAndView modelAndView=new ModelAndView("showsupplier");
		List<Supplier> supplierList=supplierDaoImpl.retrieveAllSuppliers();
		modelAndView.addObject("supList",supplierList);
		return modelAndView;
	}
	
	@RequestMapping("/editsupp")
	public ModelAndView editCategory(@RequestParam("supId") int supplierId)
	{
		System.out.println("---editing "+supplierId);
	Supplier  supplier=supplierDaoImpl.getSupplier(supplierId);
	ModelAndView modelAndView=new ModelAndView("supplier");
	modelAndView.addObject("sup",supplier);
	modelAndView.addObject("bname","UpdateSupplier");
	return modelAndView;
	}
	
}
