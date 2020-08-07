package com.nacos.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient("nacos-provide")
public interface NacosDao {
	
	@GetMapping("/helloNacos")
	public String helloNacos();
	
	 @GetMapping("shaonian")
	 public String helloFengif();
	 
	 
}
