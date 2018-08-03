package com.ssm.adminlte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {
	 @RequestMapping("indexUI")
	 public String indexUI(){
		 return "index";
	 }
	@RequestMapping("welcome")
	public String welcome(){
		return "common/welcome";
	}	 
}
