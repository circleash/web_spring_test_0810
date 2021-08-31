<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/lesson05/test05/css/style.css" type="text/css">
        <!-- bootstrap CDN link -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap">
			<div class="d-flex">
					<nav>
						<div class="logo d-flex justify-content-center mt-3">
							<img class="logo-image mr-2" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png">
							<span class="text-white logo-text">기상청</span>
						</div>
						<ul class="nav flex-column mt-3">
							<li class="nav-item"><a href="/lesson05/test05/weather_history_1" class="nav-link main-link">날씨</a></li>
							<li class="nav-item"><a href="/lesson05/test05/add_weather_view_1" class="nav-link main-link">날씨입력</a></li>
							<li class="nav-item"><a href="#" class="nav-link main-link">테마날씨</a></li>
							<li class="nav-item"><a href="#" class="nav-link main-link">관측기후</a></li>
						</ul>
					</nav>
					<section class="ml-5 mt-3">
						<h3>과거 날씨</h3>
						<table class="table text-center">
							<thead>
								<tr>
									<th>날짜</th>
	                                <th>날씨</th>
	                                <th>기온</th>
	                                <th>강수량</th>
	                                <th>미세먼지</th>
	                                <th>풍속</th>
								</tr>
								
							</thead>
							<tbody>
								<c:forEach var="weather_1" items="${weather }">
								<tr>
									<td><fmt:formatDate value="${weather_1.date }" pattern="yyyy년 M월 d일" /></td>
									<td>
                                	<c:choose>
                                		<c:when test="${weather_1.weather eq '맑음'}">
                                			<img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg" >
                                		</c:when>
                                		<c:when test="${weather_1.weather eq '구름조금'}">
                                			<img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg" >
                                		</c:when>
                                		
                                		<c:when test="${weather_1.weather eq '흐림'}">
                                			<img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg" >
                                		</c:when>
                                		
                                		<c:when test="${weather_1.weather eq '비'}">
                                			<img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg" >
                                		</c:when>
                                		<c:otherwise>
                                			${weather.weather }
                                		</c:otherwise>
                                	</c:choose>
                                	
                                	
                                </td>
                                <td>${weather_1.temperatures }℃</td>
                                <td>${weather_1.precipitation }mm</td>
                                <td>${weather_1.microDust }</td>
                                <td>${weather_1.windSpeed }km/h</td>
                            </tr>
								</c:forEach>
							</tbody>
						</table>
				</section>
			</div>
			<footer class="border-top d-flex">
	                <div class="footer-logo mt-3 ml-4"> <img class="foot-logo-image" src="https://www.weather.go.kr/w/resources/image/foot_logo.png"></div>
	                <div class="copyright mt-2">
	                    <small class="text-secondary">(07062) 서울시 동작구 여의대방로16길 61  <br>
	                    Copyright@2020 KMA. All Rights RESERVED.</small>
	
	                </div>
            </footer>
	</div>

</body>
</html>