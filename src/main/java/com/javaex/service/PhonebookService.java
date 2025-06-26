package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;


@Service
public class PhonebookService {

	//필드
	@Autowired
	private PhonebookDAO phonebookDAO;

	//메소드일반
	//-전체 리스트 가져오기
	public List<PersonVO> exeList() {
			
		//dao를 통해서 일한다
		List<PersonVO> personList = phonebookDAO.personSelect();
		
		return personList;
	}
	
	
	//--한명데이터 가져오기
	public PersonVO exeModifyForm(int personId) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		PersonVO personVO =phonebookDAO.personSelectOne(personId);
		return personVO;
	}
	
	//등록
	public String exePhonebookAdd(PersonVO personVO) {
		System.out.println("PhonebookService.exePhonebookAdd(등록)");
		return "";
	}
	
}
