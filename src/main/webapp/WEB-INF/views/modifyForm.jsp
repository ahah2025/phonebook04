<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>주소록</h1>
		<h2>전화번호 등록폼</h2>
		<p>전화번호를 등록하는 폼 입니다.</p>
	
		<form action="${pageContext.request.contextPath}/pbc"  method="get">
			<label>이름(name)</label>
			<input type="text" name="name" value="">
			<br>
		
			<label>핸드폰(hp)</label>
			<input type="text" name="hp" value="">
			<br>
	
			<label>회사(company)</label>
			<input type="text" name="company" value="">
			<br>
			

			
			<button>등록</button>
		</form>
		
		<br><br>
		
		<c:forEach items="${requestScope.plist}" var="phonebookVO">
			<table border="1" width="540px">
				<tr>
					<td>[${phonebookVO.personId}]</td>
					<td>${phonebookVO.name}</td>
					<td>${phonebookVO.hp}</td>
					<td>${phonebookVO.company}</td>

					
					<td>
						<a href="${pageContext.request.contextPath}/rform?no=${phonebookVO.personId}">삭제</a>
					</td>
				</tr>
				
			</table>
			<br>
		</c:forEach>
		
	
	</body>
</html>