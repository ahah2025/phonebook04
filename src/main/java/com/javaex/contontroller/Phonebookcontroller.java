package com.javaex.contontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Phonebookcontroller {

	//필드
	//생성자
	//메소드gs
	//메소드일반
	@RequestMapping(value="/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String list() {
		System.out.println("2025-06-23 오후 5:50");
		
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/wform",method = {RequestMethod.GET,RequestMethod.POST})
	public String wform() {
		System.out.println("수정폼 입니다 " +"\t" + "wform");
		
		return "/WEB-INF/views/wform.jsp";
	}
	
	@RequestMapping(value="/mform",method = {RequestMethod.GET,RequestMethod.POST})
	public String mform() {
		System.out.println("등록폼 입니다");
		
		return "/WEB-INF/views/mform.jsp";
	}
}
