<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포맷 라이브러리 활용</title>
<!-- bootstrap CDN Link -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>1. 후보자 득표율</h1>
		<table class="table text-center">
			<thead>
				<tr>
				<th>기호</th>
				<th>득표수</th>
				<th>득표율</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vote" items="${candidates }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><fmt:formatNumber value="${vote }" /></td>
					<td><fmt:formatNumber value="${vote / 1000000 }" type="percent" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h1>2. 카드명세서</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>사용처</th>
					<th>가격</th>
					<th>사용날짜</th>
					<th>할부</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach var="cardBill" items="${cardBill }">
				<tr>
					<td>${cardBill.store }</td>
					<td><fmt:formatNumber value="${cardBill.pay }" type="currency" currencySymbol="$"/></td>
					<td><fmt:parseDate value="${cardBill.date }" pattern="yyyy-MM-dd" var="date"/>
						<fmt:formatDate value="${date }" pattern="yyyy년 MM월 dd일" /></td>
					<td>${cardBill.installment }</td>
				</tr>
			</c:forEach>
			</tbody>		
		</table>
	</div>

</body>
</html>