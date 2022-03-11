<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<style>
		section {
			height:700px;
			width:1000px;
		}
		
		section > .menu {
			width: 180px;
		}
		
		section > .weatherInfo {
			height:700px;
			width: 800px;
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
			<article class="weatherInfo ml-4 mt-3">
				<div>
					<h3 class="font-weight-bold">과거 날씨</h3>
					<table class="table table-sm text-center">
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
							<c:forEach var="weather" items="${weather }" >
							<tr>
								<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 d일" /></td>
								<c:choose>
									<c:when test="${weather.weather eq '맑음' }" >
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg" alt="날씨 아이콘"></td>
									</c:when>
									<c:when test="${weather.weather eq '구름조금' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg" alt="날씨 아이콘"></td>
									</c:when>
									<c:when test="${weather.weather eq '흐림' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg" alt="날씨 아이콘"></td>
									</c:when>
									<c:when test="${weather.weather eq '비' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg" alt="날씨 아이콘"></td>
									</c:when>
									<c:otherwise>
										<td>${weather.weather }</td>
									</c:otherwise>
								</c:choose>
								<td>${weather.temperatures }</td>
								<td>${weather.precipitation }</td>
								<td>${weather.microDust }</td>
								<td>${weather.windSpeed }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</article>
		</section>
		
		<jsp:include page="/WEB-INF/jsp/lesson05/test05/footer.jsp" />
	</div>

</body>
</html>