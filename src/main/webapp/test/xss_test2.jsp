<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("utf-8");
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("1", "<script>alert('xss')</script>");
	map.put("2", "&lt;script&gt;alert('xss')&lt;/script&gt");
	StringBuffer bf = new StringBuffer();
	String data = request.getParameter("data");
	if ("1".equals(data)) {
		bf.append(map.get("1"));
	} else if ("2".equals(data)) {
		bf.append(map.get("2"));
	} else {
		bf.append("없음");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%=bf.toString()%>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>