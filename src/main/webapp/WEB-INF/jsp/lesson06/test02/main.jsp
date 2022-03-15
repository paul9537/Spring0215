<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>front final</title>
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
		section {
		    height: 800px;
		}
		.top-section {
		    height: 500px;
		}
		.bot-section {
		    height: 300px;
		}
		.bot-section > .reserve {
		    background-color:saddlebrown
		}
		.bot-section > .login {
		    background-color: chocolate;
		}
		.bot-section > .contact {
		    background-color: saddlebrown;
		}
		footer {
		    height: 50px;
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
                <section class="top-section bg-success">
                    <img src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg" alt="통나무팬션">
                </section>
                <aside class="bot-section bg-info d-flex">
                    <div class="reserve col-4 display-4"><a href="#" class="text-white">실시간 예약하기</a></div>
                    <div class="login col-5">
						<h5 class="text-white mt-3">예약 확인</h5>
                        <div class="d-flex flex-column ml-4 mt-4">
                            <label class="text-white">이름 : <input type="text" class="form-control col-9" id="name"></label> 
                            <label class="text-white">전화번호 : <input type="text" class="form-control col-9" id="phoneNumber"></label> 
                        </div>
                        <button type="button" class="btn btn-success ml-4" id="lookupBtn">조회하기</button>
                    </div>
                    <div class="contact col-3 display-4 text-white">예약문의 : 010-000-1111</div>
                </aside>
            </section>
            <footer>
            	<div class="small">제주특별자치도 제주시 애월읍</div>
            	<div class="small">사업자등록번호: 111-22-255222 / 농촌민박사업지정 / 대표:최성윤</div>
            	<div class="small">Copyright 2025 tongnamu All Rights Reserved.</div>
            </footer>
        </div>

	<script>
		$(document).ready(function(){
			
			$("#lookupBtn").on("click", function(){
				
				let name = $("#name").val();
				let phoneNumber = $("#phoneNumber").val();
				
				if(name == "") {
					alert("이름을 입력하세요");
					return ;
				}
				
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요");
					return ;
				}
				
				$.ajax({
					type:"get",
					url:"/lesson06/get_booking",
					data:{"name":name, "phoneNumber":phoneNumber},
					success:function(data) {
						if(data.result == "fail") {
							alert("예약 내역이 없습니다");
						} else {
						alert("이름 : " + data.booking.name + "\n"
								+ "날짜 : " + data.booking.date.slice(0, 10) + "\n"
								+ "일수 : " + data.booking.day);
						}
						
					},
					error:function() {
						alert("조회 에러");
					}
				});
			
			});
		});
	</script>
    </body>
</html>