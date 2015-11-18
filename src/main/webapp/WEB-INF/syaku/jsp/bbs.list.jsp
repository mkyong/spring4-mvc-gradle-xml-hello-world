<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta charset="utf-8">
<title>스프링프레임워크 게시판</title>
</head>
<body>
	<%@ include file="include/message.jsp"%>
	<table border="1">
		<colgroup>
			<col width="60">
			<col>
			<col width="115">
			<col width="85">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">등록일</th>
			</tr>
		</thead>
		<tbody>
			<!-- 목록이 반복될 영역 -->
			<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td>${item.idx}</td>
					<td><a href="./${item.idx}">${item.subject}</a></td>
					<td>${item.user_name}</td>
					<td>${item.reg_datetime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="./write">쓰기</a>
	</div>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>