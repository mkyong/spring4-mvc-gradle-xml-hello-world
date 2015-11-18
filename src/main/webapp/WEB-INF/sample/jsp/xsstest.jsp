<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>xsstest</title>
</head>
<body>
<div>
	<a href="xsstest?data=<script>alert('test')</script>">스크립트 테스트</a>
</div>

	${resultData}
</body>
</html>