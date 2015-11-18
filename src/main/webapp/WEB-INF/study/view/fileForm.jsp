<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="getFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="서버전달"/>
</form>
<%@ include file="/debug/debug.jsp"%>
</body>
</html>