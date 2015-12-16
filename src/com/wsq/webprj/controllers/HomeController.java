package com.wsq.webprj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home/index")
	public String index(){
		return "home/index";
	}
	
	@RequestMapping("/main")
	public String index2(){
		return "home/index";
	}
}
