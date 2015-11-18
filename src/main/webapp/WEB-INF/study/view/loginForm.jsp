<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<input type="text" name="id" /> <input type="password"
			name="password" /> <input type="submit" value="전송" />
	</form>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>