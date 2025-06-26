package com.javaex.contontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hellocontroller {

	//메소드일반
	@RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
	public String hello() {
		System.out.println("HelloController.hello()");
		
		
		return "hello";   
	}
	
}
