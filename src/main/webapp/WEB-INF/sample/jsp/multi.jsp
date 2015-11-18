<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%!public int multiply(int a, int b) {
		return a * b;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${title}</title>
</head>
<body>
	<ul>
		<%
			int i = 9;
			for (int j = 1; j < 10; j++) {
				out.println("<li>"+i + "*" + j + "=" + multiply(i, j)+"</li>");
			}
		%>
	</ul>
<%@ include file="/debug/debug.jsp"%>
</body>
</html>