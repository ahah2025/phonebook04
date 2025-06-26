package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVO;


@Repository
public class PhonebookDAO {

	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//전체데이타 가져오기
	public List<PersonVO> personSelect() {
		System.out.println("PhonebookDAO.personSelect()");
		
		List<PersonVO> personList = sqlSession.selectList("phonebook.selectList");
		
		return personList;
	}
	
	//--1명데이터 가져오기
	public PersonVO personSelectOne(int personId) {
		System.out.println("PhonebookDAO.personSelectOne()");
	
		PersonVO personVO = sqlSession.selectOne("phonebook.selectOne", personId);
	
		return personVO;
	}
	
	
}
