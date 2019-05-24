package com.harsha.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.harsha.daoimpl.CartDaoImpl;
import com.harsha.daoimpl.ProductDaoImpl;
import com.harsha.model.Cart;
import com.harsha.model.Product;

@Controller
public class CartController {

	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	
	@RequestMapping("/addtocart")
	public String addToCart(HttpServletRequest request )
	{
		int productId=Integer.parseInt(request.getParameter("proId"));
		int productQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		
		Product  product=productDaoImpl.getProduct(productId);
		cartDaoImpl.saveCart(product,productQuantity);
		
		return "userhome";
	}
	
	@RequestMapping("/showcart")
	public ModelAndView showCart()
	{
		List<Cart> cartList=cartDaoImpl.getAllCartItems();
	
		ModelAndView mv=new ModelAndView("showcart");
		mv.addObject("cartData",cartList);
		
		return mv;
		
	}
}
