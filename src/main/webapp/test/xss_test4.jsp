<%@page import="com.nhncorp.lucy.security.xss.XssFilter"%>
<%@page import="com.nhncorp.lucy.security.xss.XssFilterException"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("utf-8");
	StringBuffer bf = new StringBuffer();
	String data = request.getParameter("data");
	try {
		data = URLDecoder.decode(data, "utf-8");
		System.out.println("data:" + data);
	} catch (UnsupportedEncodingException e) {
		// 		System.out.println("¿¡·¯");
		e.printStackTrace();
	}
	XssFilter filter=XssFilter.getInstance("lucy-xss-superset.xml");
	bf.append(filter.doFilter(data));
	System.out.println(bf.toString());
	pageContext.setAttribute("result", bf.toString());
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${result}
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>