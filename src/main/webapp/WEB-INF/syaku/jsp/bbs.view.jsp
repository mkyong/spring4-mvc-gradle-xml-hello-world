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
	<script>
		function del() {
			if (confirm("삭제하시겠습니까?"))
				document.form.submit();
		}
	</script>

	<form id="form" name="form" method="post" action="./delete">
		<input type="hidden" id="idx" name="idx" value="${object.idx}" />
	</form>
	<p>${object.subject}</p>

	<div>${object.content}</div>

	<div>
		<p>작성자 : ${object.user_name}</p>
		<p>등록일 : ${object.reg_datetime}</p>
	</div>

	<div>
		<button type="button" onclick="del()">삭제</button>
		<a href="./write?idx=${object.idx}">수정</a> <a href="./">목록</a>
	</div>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>