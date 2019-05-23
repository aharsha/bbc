package com.harsha.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("home controller is loading");
	}
	@RequestMapping("/home")
	public String goToHome()
	{
		return "home";
	}
}
