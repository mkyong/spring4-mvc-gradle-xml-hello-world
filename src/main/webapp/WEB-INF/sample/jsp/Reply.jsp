<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!--  댓글 반복 시작 -->
	<c:forEach var="comment" items="${commentList }">
		<div class="comments">
			<span class="writer">${comment.name }</span> <span class="date">${comment.regdate }</span>
			<c:if test="${user.username == comment.username }">
				<span class="modify-del"> <a href="#" class="comment-toggle">수정</a>
					| <a href="#" class="comment-delete" title="${comment.commentNo }">삭제</a>
				</span>
			</c:if>
			<p class="view-comment">${comment.htmlMemo }</p>
			<form class="modify-comment" action="updateComment_proc.jsp"
				method="post" style="display: none">
				<p>
					<input type="hidden" name="commentNo" value="${comment.commentNo }" />
					<input type="hidden" name="boardCd" value="${param.boardCd }" /> <input
						type="hidden" name="articleNo" value="${param.articleNo }" /> <input
						type="hidden" name="curPage" value="${param.curPage }" /> <input
						type="hidden" name="searchWord" value="${param.searchWord }" />
				</p>
				<div style="text-align: right;">
					<a href="#">수정하기</a> | <a href="#">취소</a>
				</div>
				<div>
					<textarea class="modify-comment-ta" name="memo" rows="7" cols="50">${comment.memo }</textarea>
				</div>
			</form>
		</div>
	</c:forEach>
	<!--  댓글 반복 끝 -->


</body>
</html>