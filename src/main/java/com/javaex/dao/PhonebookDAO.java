package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhonebookVO;

@Repository
public class PhonebookDAO {

	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//전체데이타 가져오기
	public List<PhonebookVO> phonebookSelect() {
		
		List<PhonebookVO> phonebookList = sqlSession.selectList("phonebook.selectList");
		
		return phonebookList;
	}
	
	//저장하기
	public int phonebookInsert(PhonebookVO phonebookVO) {
		System.out.println("PhonebookDAO.phonebookInsert()");
		
		int count = sqlSession.insert("phonebook.insert",phonebookVO); 
		
		return count;
	}
	
	//삭제하기
	public int phonebookDelete(PhonebookVO phonebookVO) {
		System.out.println("PhonebookDAO.phonebookDelete()");
		
		int count = sqlSession.delete("phonebook.delete", phonebookVO);
			
		return count;
	}		
	
}
