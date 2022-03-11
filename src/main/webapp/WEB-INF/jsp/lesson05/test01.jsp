<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test01</title>
</head>
<body>

	<%-- 1. --%>
	<h2>JSTL core 변수</h2>
	<c:set var="number1" value="36" />
	<c:set var="number2" value="3" />
	
	<h4>첫번째 숫자 : ${number1 }</h4>
	<h4>두번째 숫자 : ${number2 }</h4>

	<%-- 2. --%>
	<h2>JSTL core 연산</h2>
	<h4>더하기 : ${number1 + number2 }</h4>
	<h4>빼기 : ${number1 - number2 }</h4>
	<h4>곱하기 : ${number1 * number2 }</h4>
	<h4>나누기 : ${number1 / number2 }</h4>

	<%-- 3. --%>
	<h2>JSTL core out</h2>
	<c:out value="<title>core out</title>" escapeXml="true" />
	
	<%-- 4. --%>
	<h2>JSTL core if</h2>
	<c:if test="${((number1 + number2) / 2) >= 10 }" >
		<h1>${(number1 + number2) / 2 }</h1>
	</c:if>
	
	<c:if test="${((number1 + number2) / 2) <= 10 }" >
		<h3>${(number1 + number2) / 2 }</h3>
	</c:if>
	
	<c:if test="${number1 * number2 > 100 }" >
		<c:out value="<script>alert('너무 큰 수 입니다.');</script>" escapeXml="false" />
	</c:if>
	

</body>
</html>