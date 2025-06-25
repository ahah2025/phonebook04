package com.javaex.contontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.Personservice;
import com.javaex.vo.PhonebookVO;

@Controller
public class Personcontroller {

	//필드
	@Autowired
	private Personservice personService;
	
	//생성자
	//메소드gs	
	//메소드일반
	//-방명록 전체 리스트 가져오기
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("Personcontroller.list()");
		
		List<PhonebookVO> phonebooklist = personService.exeGetPhonebookList();
		System.out.println(phonebooklist);
		
		//*Model개념
		//DispatcherServlet 야!!
		//request의 어트리뷰트영역에
		//"pList" 이름으로 0x333(phonebookList) 을 넣어줘
		model.addAttribute("plist",phonebooklist);
		
		//*views 개념
		//DispatcherServlet 야!!
		// "/WEB-INF/views/addlist.jsp" 에 포워드해
		return "modifyForm";
	}
	
	//-방명록 글 저장
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@ModelAttribute PhonebookVO phonebookVO) {
					  //DispatcherServlet 야!!  Request 파라미터 값을 꺼내서
					  //phonebookVO로 묶어줘	
	
		//Service 한테 시키는 일
		personService.exePhonebookAdd(phonebookVO);
		
		return "redirect:/list";
		
	}	
	
	//삭제폼(삭제랑 헷갈리지 말것) 폼만 보여주면 됨
	@RequestMapping(value="/wform",method = {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("Personcontroller.writeForm()");

		return "wform";
	}
	
	//삭제
	@RequestMapping(value="/mform",method = {RequestMethod.GET,RequestMethod.POST})
	public String remove(@ModelAttribute PhonebookVO phonebookVO) {
		System.out.println("Personcontroller.mform()");
		System.out.println(phonebookVO);
		
		personService.exePhonebookRemove(phonebookVO);
		
		return "redirect:/add";
	}	
}
