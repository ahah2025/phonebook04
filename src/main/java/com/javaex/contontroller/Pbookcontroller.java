package com.javaex.contontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class Pbookcontroller {

	//필드
	//생성자
	//메소드gs	
	//메소드일반
	@RequestMapping(value="/user/list",method= {RequestMethod.GET, RequestMethod.POST })
	public String select() {
		System.out.println("phonebook4/list");
		
		return "";
	}
	
	@RequestMapping(value="/user/wform",method= {RequestMethod.GET, RequestMethod.POST })
	public String wform() {
		System.out.println("phonebook4/wform");
		
		return "/WEB-INF/views/phonebook.jsp";
	}
	
	@RequestMapping(value="/user/mform",method= {RequestMethod.GET, RequestMethod.POST })
	public String mform() {
		System.out.println("phoebook4/mform");
		
		return "/WEB-INF/views/phonebook.jsp";
	}
	
	
}
