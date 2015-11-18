<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${title}</title>
</head>
<body>
	<ul>
		<li><a href='/'>/</a>의미없음</li>
<%-- 		<li><a href='<c:url value="/"/>'>/</a></li> --%>
		<li><a href="mkyong/">mkyong</a></li>
		<li><a href="defult/">defult</a></li>
		<li><a href="sample/">sample</a></li>
		<li><a href="common/">common</a>예제 없음</li>
		<li><a href="board2/">board2</a></li>
		<li><a href="board/">board</a></li>
		<li><a href="scott/">scott</a></li>
		<li><a href="daumeditor/">daumeditor</a></li>
		<li><a href="miplatform/">miplatform</a></li>
		<li><a href="first/">first</a></li>
		<li><a href="Member/">Member</a></li>
		<li><a href="security/">security</a></li>
		<li><a href="study/">study</a></li>
		<li><a href="syaku/">syaku</a></li>
	</ul>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>