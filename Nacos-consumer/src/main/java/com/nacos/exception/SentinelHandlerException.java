package com.nacos.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelHandlerException {

	
	public static String handlerExceptionGeneral(String ss,BlockException exception) {
//		exception.printStackTrace();
         return "少年阿冰熔断";
	  }

}
