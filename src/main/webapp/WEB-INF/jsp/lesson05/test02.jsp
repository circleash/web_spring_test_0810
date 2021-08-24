<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가요순위 HOT5</title>
<!-- bootstrap CDN Link -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>HOT5</h1>
			<table class="table text-center" >
				<thead>
					<tr>
						<th>순위</th>
						<th>제목</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="musicRankings" items="${musicRanking }" varStatus="status">
				
					<tr>
						<td>${status.count }</td>
						<td>${musicRankings }</td>
					</tr>
				
				</c:forEach>
				</tbody>
			</table>
			
			<h1>멤버십</h1>
			
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>				
						<th>전화번호</th>
						<th>등급</th>
						<th>포인트</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="member" items="${membership }">
					<tr>
						<td>${member.name }</td>
						<td>${member.phoneNumber }</td>
						<td>
							<c:choose>
								<c:when test="${member.grade == 'VIP' }">
									<span class="text-danger">${member.grade }</span>	
								</c:when>
								<c:when test="${member.grade eq 'GOLD' }">
									<span class="text-warning">${member.grade }</span>
								</c:when>
								<c:otherwise>
									${member.grade }
								</c:otherwise>
							</c:choose>
						</td>					
						<td>
							<span
							<c:if test="${member.point > 5000 }">
								 class="text-primary"	
							</c:if>
							>${member.point }P</span>
						</td>
					</tr>
					</c:forEach>
				</tbody>	
			</table>
	
	</div>
</body>
</html>