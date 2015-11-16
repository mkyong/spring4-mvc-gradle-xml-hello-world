<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>스프링프레임워크 게시판</title>
</head>
<body>
	<%@ include file="include/message.jsp"%>
	<form id="form" method="post" action="./write_ok">
		<input type="hidden" name="idx" id="idx" value="${object.idx}" />
		<div>
			<span>제목</span> <input type="text" id="subject" name="subject"
				value="${object.subject}" />
		</div>
		<div>
			<span>작성자</span> <input type="text" id="user_name" name="user_name"
				value="${object.user_name}" />
		</div>
		<div>
			<span>내용</span>
			<textarea id="content" name="content" rows="10" cols="20">${object.content}</textarea>
		</div>

		<div>
			<input type="submit" value="save" /> <a href="./">목록</a>
		</div>
	</form>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>