<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, scott.DeptVO" %>    
<%
	List<DeptVO> dList = 
		(List<DeptVO>)request.getAttribute("dList");
%>  
<html>
<head>
<title>부서목록</title>
</head>
<body>
<table border="1" width="500">
	<tr>
		<td>부서번호</td>
		<td>부서명</td>
		<td>지역</td>
	</tr>
<%
	for(int i=0;i<dList.size();i++){
		DeptVO dvo = dList.get(i);
%>	
	<tr>
		<td><%=dvo.getDeptno() %></td>
		<td><%=dvo.getDname() %></td>
		<td><%=dvo.getLoc() %></td>
	</tr>
<%
	}
%>	
</table>
</body>
</html>