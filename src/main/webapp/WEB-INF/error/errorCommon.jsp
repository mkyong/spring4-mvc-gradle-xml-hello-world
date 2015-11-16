<%@ page language="java" contentType="text/html; charset=EUC-KR"
	isErrorPage="true" pageEncoding="EUC-KR"%>
<%
	response.setStatus(200);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>에러페이지</title>
</head>
<body>
<h1>에러페이지 입니다</h1>
<p><%= exception.getMessage() %></p>

<%@ include file="/debug/debug.jsp" %>
</body>
</html>