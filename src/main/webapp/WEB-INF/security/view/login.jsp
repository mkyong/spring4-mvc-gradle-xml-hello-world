<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인페이지</title>
</head>
<body>
	<h2>로그인</h2>
	<form name="form" method="post" action="loginProcess">
		<table>
			<tr height="40px">
				<td>사용자아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr height="40px">
				<td>패스워드</td>
				<td><input type="password" name="pw"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="center"><input type="submit" value="로그인"></td>
				<td align="center"><input type="reset" value="리셋"></td>
			</tr>
		</table>
	</form>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>