<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="boardCss.css">
<script type="text/javascript" src="boardActionJs.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="listForm" method="get">
		<table class="listTable">
			<tr>
				<td colspan="5" align="right" id="boardListCount">게시글 수 :
					${boardCount} 건</td>
			</tr>
		</table>
		<table class="listTable" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<tr>
				<c:if var="boardCountZroe" test="${boardCount == 0}">
					<td colspan="5"><font color="red">게시글이 없습니다.</font></td>
				</c:if>
			</tr>
			<c:if test="${!boardCountZroe}">
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.seq}</td>
						<td><a href="">${list.title}</a></td>
						<td>${list.name}</td>
						<td>${list.regdate}</td>
						<td>${list.readcount}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<!-- 페이지 -->
		<c:if test="${!boardCountZroe}">
			<table class="listTable">
				<tr>
					<td colspan="5" align="center"><c:if test="${startPage > 1}">
							<span> <a
								href="list.html?pageNumber=${startPage - 1}&boardListSearchText=${boardListSearchText}&boardListSelect=${boardListSelect}">이전</a>
							</span>
						</c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${pageNumber == i }">
									<span> <a
										href="list.html?pageNumber=${i}&boardListSearchText=${boardListSearchText}&boardListSelect=${boardListSelect}"
										id="boardList_a">${i}</a>&nbsp;
									</span>
								</c:when>

								<c:otherwise>
									<span> <a
										href="list.html?pageNumber=${i}&boardListSearchText=${boardListSearchText}&boardListSelect=${boardListSelect}">${i}</a>&nbsp;
									</span>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:if test="${endPage < totalPageCount}">
							<span> <a
								href="list.html?pageNumber=${endPage + 1}&boardListSearchText=${boardListSearchText}&boardListSelect=${boardListSelect}">다음</a>
							</span>
						</c:if></td>
				</tr>
			</table>
		</c:if>
		<!-- 검색 -->
		<table class="listTable">
			<tr>
				<td colspan="5" align="center"><select name="boardListSelect">
						<option value="name">작성자</option>
						<option value="title">글제목</option>
						<option value="seq">글번호</option>
				</select> <input type="text" id="boardListSearchText"
					name="boardListSearchText" onkeydown="enterEvent();"> <input
					type="button" value="검색" onclick="boardListSearchGo();"> /
					<input type="button" value="글 입력" onclick="Location.href='#'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>