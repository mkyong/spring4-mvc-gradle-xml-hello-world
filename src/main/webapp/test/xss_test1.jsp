<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	request.setCharacterEncoding("utf-8");
	StringBuffer bf = new StringBuffer();
	String data = request.getParameter("data");
	bf.append(data);
	pageContext.setAttribute("result", bf.toString());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	크롬은 안뜸. 익플에선 뜸.
	<br>${result}<br> The XSS Auditor refused to execute a script
	in 'http://localhost:8080/defult/test/xss_test1.jsp' because its source
	code was found within the request. The auditor was enabled as the
	server sent neither an 'X-XSS-Protection' nor 'Content-Security-Policy'
	header.
	<br> 취약점 제거
	<br> ${fn:escapeXml(result)}
	<br>
	<c:out value="${result }"></c:out>
	<br>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>