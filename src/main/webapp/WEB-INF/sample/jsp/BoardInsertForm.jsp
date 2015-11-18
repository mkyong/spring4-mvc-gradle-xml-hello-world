<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BoardInsertForm.jsp</title>

<%@ include file="/include/ink_head.jsp"%>

</head>
<body>
	<form action="BoardInsert" modelAttribute="BoardVO" method="post">
		<input type="text" name="b_nick" value="Nick" /> <br>
		<input type="password" name="b_pw" value="password" /><br>
		<textarea name="b_text" id="" cols="30" rows="10"></textarea>
		<input type="submit" value="전송"/>
	</form>
	
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>