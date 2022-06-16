<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
	<title>YoilTellerMVC</title>
</head>
<body>
<!-- 달러 안에 변수가 들어가는 것을 EL(Expression Language) 라 한다. -->
<h1>year=<%=request.getParameter("year") %></h1>
<h1>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일입니다.</h1>
</body>
</html>