package com.harsha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.harsha.daoimpl.UserDaoImpl;
import com.harsha.model.User;

@Controller
public class UserController {

	@Autowired
	UserDaoImpl userDaoImpl;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView goToRegForm()
	{
	
		User user=new User();
		ModelAndView  modelAndView=new ModelAndView("register");
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView recieveRegFormData(@ModelAttribute("user") User user)
	{
	
		ModelAndView  modelAndView=new ModelAndView("userhome");
		userDaoImpl.addUser(user);
		return modelAndView;
	}
	
	//
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView goToLoginForm()
	{
	
		User  user=new User();
		
		ModelAndView  modelAndView=new ModelAndView("login");
		modelAndView.addObject("user",user);
		
		return modelAndView;
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView recieveLoginFormData(@ModelAttribute("user") User user)
	{
	boolean result=userDaoImpl.checkLogin(user);
	
	if(result==true)
	{
		ModelAndView  modelAndView=new ModelAndView("loginsuccess");
		return modelAndView;
	}
	else
	{
		ModelAndView  modelAndView=new ModelAndView("login");
		modelAndView.addObject("logininfo","wrong username/password");
		
		return modelAndView;
		
	}
	
		


	}
	
	
	
}
