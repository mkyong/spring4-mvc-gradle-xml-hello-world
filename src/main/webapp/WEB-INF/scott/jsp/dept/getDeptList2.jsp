<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%
	List<HashMap> dList = 
		(List<HashMap>)request.getAttribute("dList");
%>  
<html>
<head>
<title>부서목록(WEB-INF)</title>
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
		HashMap pMap = dList.get(i);
%>	
	<tr>
		<td><%=pMap.get("DEPTNO") %></td>
		<td><%=pMap.get("DNAME") %></td>
		<td><%=pMap.get("LOC") %></td>
	</tr>
<%
	}
%>	
</table>
</body>
</html>