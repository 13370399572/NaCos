package com.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProvideController {
	
	 @GetMapping("/helloNacos")
	    public String helloNacos(){
	        return "你好，nacos！";
	    }
	 
	   @GetMapping("shaonian")
	    public String helloFengif() {
	    	return "您好 少年阿冰";
	    }

}
