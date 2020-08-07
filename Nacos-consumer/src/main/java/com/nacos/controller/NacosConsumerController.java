package com.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.dao.NacosDao;
import com.nacos.exception.SentinelFallbackException;
import com.nacos.exception.SentinelHandlerException;
import com.nacos.service.NacosConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class NacosConsumerController {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private   NacosConsumerService nacosConsumerService;
	
	@Autowired
	private NacosDao nacosDao;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String test1() {
    	System.out.println("xx");
        return restTemplate.getForObject("http://nacos-provide/helloNacos",String.class);
    }
     
    @GetMapping(value = "/payment/nacos/myhandler")
    @SentinelResource(value = "myhandler",
            blockHandlerClass = SentinelHandlerException.class,
            blockHandler = "handlerExceptionGeneral",
            fallbackClass = SentinelFallbackException.class,
            fallback = "fallbackExceptionGeneral",
            exceptionsToIgnore = IllegalAccessException.class)
            public String test3(String ss) {
            return nacosDao.helloFengif();
         }
    
    
    @GetMapping("/get")
    @HystrixCommand(fallbackMethod = "Histrix")
    public String test2() {
     return nacosDao.helloFengif();
    }
    
    
    @SuppressWarnings("unused")
    public String Histrix() {
    	String shaonianString = "少年阿冰机器宕机了";
    	nacosConsumerService.textToSpeech(shaonianString);
    	return shaonianString;
    }
}
