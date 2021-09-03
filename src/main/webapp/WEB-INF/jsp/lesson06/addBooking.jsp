<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/lesson06/test06/css/style.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>     
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<div class="container">
	<h1 class="text-center">통나무 팬션</h1>
	<nav class="mt-4">
		<ul class="nav nav-fill">
		    <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
		    <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
            <li class="nav-item"><a class="nav-link" href="/lesson06/add_booking_view">예약하기</a></li>
            <li class="nav-item"><a class="nav-link" href="/lesson06/booking_list">예약목록</a></li>
		</ul>
     </nav>
     <h2 class="text-center">예약 하기</h2>
     <label>이름</label>
     <input type="text" name="name" id="nameInput" class="form-control">
     <label>예약날짜</label>
     <input type="text" name="date" id="datepicker" class="form-control">
     <label>숙박일수</label>
     <input type="text" name="day" id="dayInput" class="form-control">
     <label>숙박인원</label>
     <input type="text" name="headcount" id="headcountInput" class="form-control">
     <label>전화번호</label>
     <input type="text" name="phoneNumber" id="phoneNumberInput" class="form-control">
     <button type="button" id="bookingBtn" class="btn btn-info">예약하기</button>
</div>
    <script>
        $(document).ready(function() {
			
        	$("#bookingBtn").on("click", function() {
        		var name = $("#nameInput").val();
        		var date = $("#datepicker").val();
        		var day = $("#dayInput").val();
        		var headcount = $("#headcountInput").val();
        		var phoneNumber = $("#phoneNumberInput").val();
        		
        		if(name == null || name == "") {
                    alert("이름을 입력하세요.");
                    return ;
                }
                if(date == null || date == "") {
                    alert("날짜를 선택하세요.");
                    return ;
                }
                if(day == null || day == "") {
                    alert("숙박일을 입력하세요.");
                    return ;
                }
                if(isNaN(day)) {
                    alert("숙박 일수는 숫자만 입력 가능합니다. ");
                    return ;
                }
                if(headcount == null || headcount == "") {
                    alert("숙박인원을 입력하세요.");
                    return ;
                }
                if(isNaN(headcount)) {
                    alert("숙박인원은 숫자만 입력 가능합니다. ");
                    return ;
                }
                if(phoneNumber == null || phoneNumber == "") {
                    alert("전화번호를 입력하세요.");
                    return ;
                }
                
                $.ajax({
                	type:"get",
                	url:"/lesson06/add_booking",
                	data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber},
                	success:function(data) {
                		if(data.result == "success") {
                			location.href="/lesson06/booking_list";
                		} else {
                			alert("예약 실패");
                		}
                	}, 
                	error:function(e) {
                		alert("error");
                	}
                });
        		
        	});
        	
        	$("#datepicker").datepicker({
        		dateFormat:"yy-mm-dd",
        		minDate:0
        		
        	});
        	
        } );
    </script>
    </body>
</html>