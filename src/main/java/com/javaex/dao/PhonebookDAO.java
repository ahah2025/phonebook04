package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.PhonebookVO;

public class PhonebookDAO {

	// 필드
	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/phonebook_db";
	private String id = "phonebook";
	private String pw = "phonebook";

	private void getConnection() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("접속성공");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
		public List<PhonebookVO> phonebookSelect() {
		List<PhonebookVO> phonebookList = new ArrayList<PhonebookVO>();
			this.getConnection();
			try {

			// 3. SQL문 준비 / 바인딩 / 실행

			// --SQL문 준비
			String query = "";
			query += " select person_id, ";
			query += "        name, ";
			query += "        hp, ";
			query += "        company ";
			query += " from person ";
			query += " order by person_id desc ";

			// --바인딩
			pstmt = conn.prepareStatement(query);	

			// --실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int personId = rs.getInt("personId");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");
				PhonebookVO phonebookVO = new PhonebookVO(personId, name, hp, company);
				phonebookList.add(phonebookVO);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

			this.close();

			return phonebookList;
	}
		
	public int phonebookInsert(PhonebookVO phonebookVO) {
		int count = -1;

		this.getConnection();

			try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " insert into person ";
			query += " values (null, ?, ?, ?) ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, phonebookVO.getName());
			pstmt.setString(2, phonebookVO.getHp());
			pstmt.setString(3, phonebookVO.getCompany());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리			
			System.out.println(count + "건 등록");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

			this.close();

			return count;
		}

	public int phonebookDelete(PhonebookVO phonebookVO) {
		int count = -1;

		this.getConnection();

		try {			

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " delete from person ";
			query += " where person_id= ?  ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			pstmt.setInt(1, phonebookVO.getPersonId());
			pstmt.setString(2, phonebookVO.getCompany());

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 삭제");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}			
			
		this.close();
			
		return count;
	}	
}
