<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardList.jsp</title>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td>${ vo.b_no }</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><c:out value="${ vo.b_title }"></c:out></td>
		</tr>
		<tr>
			<td>수정날자</td>
			<td><c:out value="${ vo.b_eddate }"></c:out></td>
		</tr>
		<tr>
			<td>최초날자</td>
			<td>${ vo.b_indate }</td>
		</tr>
		<tr>
			<td>삭제여부</td>
			<td>${ vo.b_delete }</td>
		</tr>
		<%-- 		<tr>
			<td>조회수</td>
			<td>${ vo.hit }</td>
		</tr> --%>
		<tr>
			<td>회원번호</td>
			<td>${ vo.u_no }</td>
		</tr>
		<tr>
			<td>아뒤</td>
			<td><c:out value="${ vo.u_id }"></c:out></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><c:out value="${ vo.u_nick }"></c:out></td>
		</tr>
		<tr>
			<td>삭제여부</td>
			<td>${ vo.u_delete }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="60" rows="5" disabled>${ vo.b_content }</textarea></td>
		</tr>
		<tr>
			<td>이전글</td>
			<td><a href="getInfo.do?num=${ prev.b_no }">${ prev.b_title }</a></td>
		</tr>
		<tr>
			<td>다음글</td>
			<td><a href="getInfo.do?num=${ next.b_no }">${ next.b_title }</a></td>
		</tr>
	</table>

	<%@ include file="/debug/debug.jsp"%>
</body>
</html>