<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking List Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
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
	</style>
</head>
<body>

	<div id="wrap">
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
			<h3 class="text-center">예약 목록 보기</h3>
			<table class="table text-center table-sm">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${booking }" >
					<tr>
						<td>${booking.name }</td>
						<td><fmt:formatDate value="${booking.date }" pattern="yyyy년 M월 d일"/></td>
						<td>${booking.day }</td>
						<td>${booking.headcount }</td>
						<td>${booking.phoneNumber }</td>
						<c:choose>
							<c:when test="${booking.state eq '대기중'}">
								<td><a href="#" class="text-info pendingBtn" data-booking-id="${booking.id }">대기중</a> </td>
							</c:when>
							<c:when test="${booking.state eq '확정'}">
								<td class="text-success">${booking.state }</td>
							</c:when>
							<c:when test="${booking.state eq '취소'}">
								<td class="text-danger">${booking.state }</td>
							</c:when>
							<c:otherwise>
								<td>${booking.state }</td>
							</c:otherwise>
						</c:choose>
						<td><button type="button" class="btn btn-danger">삭제</button></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		<footer>
           	<div class="small">제주특별자치도 제주시 애월읍</div>
           	<div class="small">사업자등록번호: 111-22-255222 / 농촌민박사업지정 / 대표:최성윤</div>
           	<div class="small">Copyright 2025 tongnamu All Rights Reserved.</div>
		</footer>
	</div>
	
	<script>
		$(document).ready(function(){
			
			$(".pendingBtn").on("click", function(){
				
				let bookingId = $(this).data("booking-id");
				
				$.ajax({
					type:"get",
					url:"/lesson06/change_state",
					data:{"id":bookingId},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("상태 변경 실패");
						}
					},
					error:function() {
						alert("상태 변경 에러");
					}
				});
			});
		});
	</script>

</body>
</html>