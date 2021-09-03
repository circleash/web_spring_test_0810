<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- bootstrap CDN link -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" id="titleInput" class="form-control">
		<label class="mt-3">주소</label>
		<div class="d-flex">
		<input type="text" id="urlInput" class="form-control">
		<button type="button" id="urlCheckBtn" class="btn btn-info">중복 체크</button>
		</div>
		<div class="text-danger d-none" id="duplicateDiv"><small>중복된 url입니다.</small></div>
		<div class="text-success d-none" id="noneDuplicateDiv"><small>사용 가능한 url입니다.</small></div>
		<button type="button" id="addFavorite" class="btn btn-success btn-block mt-3">추가</button>
	</div>
	<script>
	$(document).ready(function() {
		//중복체크 확인 여부 변수
		var isChecked = false;
		//중복 url 여부
		var isDuplicate = true;
		
		$("#addFavorite").on("click", function() {
			var title = $("#titleInput").val();
			var url = $("#urlInput").val();
			
			if(title == null || title == "") {
				alert("제목을 입력하세요");
				return;
			}
			
			if(url == null || url == "") {
				alert("주소를 입력하세요");
				return;
			}
			
			// http:// 또는 https:// 가 아니면 잘못된 url
			if(!(url.startsWith("http://") || url.startsWith("https://"))) {
				alert("잘못된 주소 형식입니다.");
				return;
			}
			
			//중복 체크 여부 유효성 검사
			if(isChecked == false) {
				alert("중복체크를 진행해 주세요!")
				return;
			}
			
			//이름이 중복된 경우
			if(isDuplicate == true) {
				alert("중복된 url은 입력할 수 없습니다");
				return;
			}
			
			$.ajax({
				type:"post",
				url:"/lesson06/add_favorite",
				data:{"name":title, "url":url},
				success:function(data) {
					// 성공 했을때 {"result" : "success"}
					// 실패 했을때 {"result" : "fail"};
					if(data.result == "success") {
						location.href="/lesson06/favorite_list";
					} else {
						alert("삽입 실패");
					}
					
				},
				error :function(e) {
					alert("error");
				}
				
			});
			
		});
		$("#urlCheckBtn").on("click", function() {
			var url = $("#urlInput").val();
			
			if(url == null || url =="") {
				alert("주소를 입력하세요");
				return;
			}
			
			// http:// 또는 https:// 가 아니면 잘못된 url
			if(!(url.startsWith("http://") || url.startsWith("https://"))) {
				alert("잘못된 주소 형식입니다.");
				return;
			}
			$.ajax({
				type:"get",
				url:"/lesson06/is_url_duplication",
				data:{"url":url},
				success:function(data) {
					//data {"isDuplication":true}
					//{"isDuplication":false}
					isChecked = true;
					if(data.isDuplication) {
						
						isDuplicate = true;
						$("#duplicateDiv").removeClass("d-none");
						$("#noneDuplicateDiv").addClass("d-none");
					} else {
						isDuplicate = false;
						$("#noneDuplicateDiv").removeClass("d-none");
						$("#duplicateDiv").addClass("d-none");
					}
				},
				error:function(e) {
					alert("error");
				}
			
			})
			
		})
		
	});
	
	
	</script>
</body>