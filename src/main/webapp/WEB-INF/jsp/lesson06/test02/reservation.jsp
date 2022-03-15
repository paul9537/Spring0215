<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<style>
   		#wrap { 
		    width: 1200px;
		    margin: auto;
		}
		header {
		    height: 100px;
		}
		nav {
		    height: 50px;
		    background-color:chocolate;
		}
		.center{
		    display: table;
		    margin-left: auto;
		    margin-right: auto;
		}
	</style>

</head>
<body>
	
	<div id="wrap" class="container">
	    <header class="text-center">
	        <h1 class="mt-2">통나무 팬션</h1>
	    </header>
	    <nav>
	        <ul class="d-flex nav navbar justify-content-around">
	            <li class="nav-items mt-1"><a href="/lesson06/pension" class="text-white">팬션소개</a></li>
	            <li class="nav-items mt-1"><a href="#" class="text-white">객실보기</a></li>
	            <li class="nav-items mt-1"><a href="/lesson06/reservation" class="text-white">예약안내</a></li>
	            <li class="nav-items mt-1"><a href="#" class="text-white">커뮤니티</a></li>
	        </ul>
	    </nav>
	    <section>
	    	<h3 class="text-center mt-4 font-weight-bold">예약하기</h3>
	    	<div class="center" style="width:490px; padding:15px;">
	    		<label>이름</label>
	    		<input type="text" class="form-control" id="nameInput">
	    		
	    		<label>예약날짜</label>
	    		<input type="text" class="form-control" id="dateInput">
	    		
			    <label>숙박일수</label>
	    		<input type="text" class="form-control" id="dayInput">
	    		
 			   	<label>숙박인원</label>
	    		<input type="text" class="form-control" id="headcountInput">
	    		
	    		<label>전화번호</label>
	    		<input type="text" class="form-control" id="phoneNumberInput">
	    	</div>
	    	<button class="btn btn-warning center col-5" type="button" id="reserveBtn">예약하기</button>
	    </section>
   		<footer>
           	<div class="small">제주특별자치도 제주시 애월읍</div>
           	<div class="small">사업자등록번호: 111-22-255222 / 농촌민박사업지정 / 대표:최성윤</div>
           	<div class="small">Copyright 2025 tongnamu All Rights Reserved.</div>
		</footer>
	</div>

	<script>
    $(document).ready(function() {
        
        $("#reserveBtn").on("click", function(){
        	let name = $("#nameInput").val();
        	let date = $("#dateInput").val();
        	let day = $("#dayInput").val();
        	let headcount = $("#headcountInput").val();
        	let phoneNumber = $("#phoneNumberInput").val();
        	
        	if(name == "") {
        		alert("이름을 입력하세요");
        		return ;
        	}
        	
        	if(date == "") {
        		alert("날짜를 선택하세요");
        		return ;
        	}
        	
        	if(day == "") {
        		alert("숙박일수를 입력하세요");
        		return ;
        	}
        	
        	// 숫자가 아닌것을 입력한 경우
        	if(isNaN(day)) {
        		alert("숙박일수는 숫자만 입력 가능합니다");
        		return ;
        	}
        	
        	if(headcount == "") {
        		alert("숙박인원을 입력하세요");
        		return ;
        	}
        	
        	if(isNaN(headcount)) {
        		alert("숙박인원은 숫자만 입력 가능합니다");
        		return ;
        	}
        	
        	if(phoneNumber == "") {
        		alert("전화번호를 입력하세요");
        		return ;
        	}
        	
	        $.ajax({
	        	type:"get",
	        	url:"/lesson06/add_booking",
	        	data:{"name":name, "headcount":headcount, "day":day, "date":date, "phoneNumber":phoneNumber},
	        	success:function(data) {
	        		if(data.result == "success") {
	        			location.href="/lesson06/booking_list";
	        		} else {
	        			alert("예약 실패");
	        		}
	        	},
	        	error:function() {
	        		alert("예약 오류");
	        	}
	        });

        });

        $("#dateInput").datepicker({
            changeMonth: true,  // 월 셀렉트 박스 
            changeYear: true,   // 년 셀렉트 박스 
            minDate:0,
            dateFormat:"yy-mm-dd",  // 표시 포멧 
        });
        
        
        
    });
	
	</script>
</body>
</html>


