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
import com.harsha.model.Category;

@Controller
public class CategoryController
{
	@Autowired
	CategoryDaoImpl  categoryDaoImpl;
	
//@RequestMapping("/category")
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public ModelAndView goToCategoryForm()
	{
		ModelAndView  mv=new ModelAndView("category");
		
		
		mv.addObject("cat",new Category());
		mv.addObject("bname","AddCategory");
		return  mv;
	}
	
	@RequestMapping(value="/addCat",method=RequestMethod.POST)
	public ModelAndView recieveCategoryFormData(@ModelAttribute ("cat") Category ca)
	{
		
		
		System.out.println(ca.getCategoryName());
		System.out.println(ca.getCategoryDiscription());
		ModelAndView  mv=new ModelAndView("home");
		//mv.addObject("cat",new Category());
		//mv.addObject("bname","AddCategory");
		categoryDaoImpl.saveCategory(ca);
		
		return mv;
	}
	
	@RequestMapping("/showcat")
	public ModelAndView retrieveCategory()
	{
		ModelAndView  modelAndView=new ModelAndView("showcategory");
	List<Category> categoryList = categoryDaoImpl.retrieveAllCategory();	
		modelAndView.addObject("catList",categoryList);
	return modelAndView;
	}
	
	@RequestMapping("/del")
	public ModelAndView deleterCategory(@RequestParam("catId") int categoryId)
	{
		System.out.println(categoryId);
		
		Category category=categoryDaoImpl.getCategory(categoryId);
		categoryDaoImpl.deleteCategory(category);
		
		ModelAndView modelAndView=new ModelAndView("showcategory");
		List<Category> categoryList=categoryDaoImpl.retrieveAllCategory();
		modelAndView.addObject("catList",categoryList);
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCategory(@RequestParam("catId") int categoryId)
	{
		System.out.println("---editing "+categoryId);
	Category  category=categoryDaoImpl.getCategory(categoryId);
	ModelAndView modelAndView=new ModelAndView("category");
	modelAndView.addObject("cat",category);
	modelAndView.addObject("bname","UpdateCategory");
	return modelAndView;
	}
	
}
