<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<style>
		section {
			height: 300px;
		}
	
		section > .menu {
			width: 180px;
		}
		
		footer {
			height: 80px;
		}
	
	</style>

</head>
<body>

	<div id="wrapper" class="container">
	
		<section class="d-flex">
			<jsp:include page="/WEB-INF/jsp/lesson05/test05/nav.jsp" />
			<section class="input-section ml-4">
				<h3 class="mt-3">날씨 입력</h3>
				<form method="get" action="/lesson05/add_weather">
					<div class="upper-input d-flex mt-5 ml-4">
						<div class="date input-group">
							<label class="mt-1 mr-2">날짜</label> 
							<input type="text" class="form-control" name="date">
						</div>
						<div class="weather input-group">
							<label class="mt-1 mr-2 ml-4">날씨</label>
							<select class="form-control" name="weather">
								<option>맑음</option>
								<option>흐림</option>
								<option>비</option>
								<option>구름조금</option>
							</select>
						</div>
						<div class="microDust input-group">
							<label class="mt-1 mr-2 ml-4">미세먼지</label>
							<select class="form-control" name="microDust">
								<option value="보통">보통</option>
								<option value="좋음">좋음</option>
								<option value="나쁜">나쁜</option>
								<option value="최악">최악</option>
							</select>
						</div>
					</div>
					<div class="lower-input d-flex mt-5 ml-4">
						<div class="temperatures input-group">
							<label class="mt-1 mr-2">기온</label>
							<input type="text" class="form-control" name="temperatures">
							<span class="input-group-text">℃</span>
						</div>
						<div class="precipitation input-group">
							<label class="mt-1 mr-2 ml-4">강수량</label>
							<input type="text" class="form-control" name="precipitation">
							<span class="input-group-text">mm</span>
						</div>
						<div class="input-group">
							<label class="mt-1 mr-2 ml-4">풍속</label>
							<input type="text" class="form-control" name="windSpeed">
							<span class="input-group-text">km/h</span>
						</div>
					</div>
					<button type="submit" class="save-button btn btn-success mt-4" style="float:right;">저장</button>
				</form>
			</section>
		</section>
		<jsp:include page="/WEB-INF/jsp/lesson05/test05/footer.jsp" />
		
	</div>

</body>
</html>