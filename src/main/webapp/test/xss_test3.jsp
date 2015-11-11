<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("utf-8");
	String data = request.getParameter("data");
	try{
		response.sendRedirect("xss_dom.jsp?message="+data);
	}catch(IOException e){
		System.out.println("에러");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>