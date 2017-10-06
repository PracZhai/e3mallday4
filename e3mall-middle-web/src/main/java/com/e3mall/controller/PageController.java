package com.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/**
	 * 跳转页面
	 */
	@RequestMapping("/")
	public String showPage(){
		return "index";
	}
	/**
	 * 跳转页面
	 */
	@RequestMapping("/{page}")
	public String showPages(@PathVariable String page){
		return page;
	}
}
