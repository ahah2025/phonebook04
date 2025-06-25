package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PhonebookVO;

@Service
public class Personservice {

	//필드
	@Autowired
	private PhonebookDAO phonebookDAO;
	
	//생성자
	//메소드gs
	
	//메소드일반
	//-전체 리스트 가져오기
	public List<PhonebookVO> exeGetPhonebookList() {
			
		//dao를 통해서 일한다
		List<PhonebookVO> phonebookList = phonebookDAO.phonebookSelect();
			
		return phonebookList;
	}
	
	//저장
	public int exePhonebookAdd(PhonebookVO phonebookVO) {
		System.out.println("PhonebookService.exePhonebookAdd");
		
		int count = phonebookDAO.phonebookInsert(phonebookVO);
		
		return count;
	}
	
	//삭제
	public int exePhonebookRemove(PhonebookVO phonebookVO) {
		System.out.println("PhonebookService.exePhonebookRemove");
		
		int count = phonebookDAO.phonebookDelete(phonebookVO);
		
		return count;
	}
	
}
