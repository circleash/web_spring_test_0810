<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 테스트</title>
</head>
<body>
	<h3>1. JSTL Core 변수</h3>
	
	<c:set var="number1" value="36" />
	<c:set var="number2">3</c:set>
	
	<h4>첫번째 숫자 : ${number1 }</h4>
	<h4>두번째 숫자 : ${number2 }</h4>
	
	<h3>2. JSTL Core 연산</h3>
	
	<h4>더하기 : ${number1 + number2 }</h4>
	<h4>빼기 : ${number1 - number2 }</h4>
	<h4>곱하기 : ${number1 * number2 }</h4>
	<h4>나누기 : ${number1 / number2 }</h4>
	
	<h3>3. JSTL Core Out</h3>
	
	<c:out value="<title>core out</title>" />
	
	<h3>4. JSTL Core if</h3>
	<c:set var="average" value="${(number1 + number2) / 2 }" />
	<c:if test="${average >= 10 }">
		<h1>${average }</h1>
	</c:if>
	<c:if test="${average < 10 }">
		<h1>${average }</h1>
	</c:if>
	<c:choose>
		<c:when test="${average >= 10 }">
			<h1>${average }</h1>
		</c:when >
		
		<c:when test="${average < 10 }">
		<h4>${average }</h4>
		</c:when>
	</c:choose>
	
	<h3>5. JSTL core if</h3>
	
	<c:if test="${number1 * number2 > 100 }">
		<c:out value="<script>alert('너무 큰수입니다');</script>" escapeXml="false"/>	
	</c:if>
	
</body>
</html>