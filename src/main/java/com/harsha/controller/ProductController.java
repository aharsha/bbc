package com.harsha.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.harsha.daoimpl.CategoryDaoImpl;
import com.harsha.daoimpl.ProductDaoImpl;
import com.harsha.daoimpl.SupplierDaoImpl;
import com.harsha.model.Category;
import com.harsha.model.Product;
import com.harsha.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	ProductDaoImpl ProductDaoImpl;
	
	@Autowired
	CategoryDaoImpl catgeoryDaoimp;
	
	@Autowired
	SupplierDaoImpl  supplierDaoImpl;
	
	
	

	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView goToProductForm()
	{
		ModelAndView  mv=new ModelAndView("product");
		
		Product  product=new Product();
	
		product.setProductId((int)(Math.random()*10000));
		
		mv.addObject("product",product);
		List<Category> catList=catgeoryDaoimp.retrieveAllCategory();
		mv.addObject("categoryList",catList);
		
		List<Supplier> supList=supplierDaoImpl.retrieveAllSuppliers();
		mv.addObject("supplierList",supList);
		
		mv.addObject("bname","AddProduct");
		return  mv;
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ModelAndView recieveProductFormData(@ModelAttribute ("product") Product product)
	{
		ModelAndView  mv=new ModelAndView("home");
	    ProductDaoImpl.saveProduct(product);
	MultipartFile image= product.getProImage();
	
	BufferedOutputStream bos=null;
	try {
		
		byte bytearry[]= image.getBytes();
		File file=new File("D://dt20project11/eshop/src/main/webapp/resources/product-imgs/"+product.getProductId()+".jpg");
		FileOutputStream fos=new FileOutputStream(file);
	bos =new BufferedOutputStream(fos);
	bos.write(bytearry);
	
		
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.println("---------- testing  image "+image);
	
	    List<Product> productList =	ProductDaoImpl.retrieveAllProducts();
	    mv.addObject("proList",productList);
	    return mv;
	}
	
	@RequestMapping("/showproducts")
	public ModelAndView retrieveCategory()
	{
	ModelAndView  modelAndView=new ModelAndView("showproduct");
	List<Product> ProductList = ProductDaoImpl.retrieveAllProducts();	
	modelAndView.addObject("proList",ProductList);
	return modelAndView;
	}
	
	@RequestMapping("/delproduct")
	public ModelAndView deleteProduct(@RequestParam("proId") int productId)
	{
		System.out.println(productId);
		
		Product product=ProductDaoImpl.getProduct(productId);
		ProductDaoImpl.deleteProduct(product);
		File file=new File("D://dt20projects/eshop/src/main/webapp/resources/product-imgs/"+product.getProductId()+".jpg");
		file.delete();
		ModelAndView modelAndView=new ModelAndView("showproduct");
		List<Product> ProductList=ProductDaoImpl.retrieveAllProducts();
		modelAndView.addObject("proList",ProductList);
		return modelAndView;
	}
	
	@RequestMapping("/editproduct")
	public ModelAndView editCategory(@RequestParam("proId") int ProductId)
	{
	System.out.println("---editing "+ProductId);
	Product  Product=ProductDaoImpl.getProduct(ProductId);
	ModelAndView modelAndView=new ModelAndView("product");
	modelAndView.addObject("product",Product);
	modelAndView.addObject("bname","UpdateProduct");
	List<Category> catList=catgeoryDaoimp.retrieveAllCategory();
	modelAndView.addObject("categoryList",catList);
	
	List<Supplier> supList=supplierDaoImpl.retrieveAllSuppliers();
	modelAndView.addObject("supplierList",supList);
	return modelAndView;
	}
	
	//========================================
	
	@RequestMapping("/userproducts")
	public ModelAndView retrieveProducts()
	{
	ModelAndView  modelAndView=new ModelAndView("userproducts");
	List<Product> ProductList = ProductDaoImpl.retrieveAllProducts();	
	modelAndView.addObject("proList",ProductList);
	return modelAndView;
	}
	
	
	@RequestMapping("/productdetails")
	public ModelAndView retrieveSingleProduct(@RequestParam("proId") int productId )
	{
	ModelAndView  modelAndView=new ModelAndView("oneproduct");
	Product product = ProductDaoImpl.getProduct(productId);	
	modelAndView.addObject("pro",product);
	return modelAndView;
	}
	
	
}
