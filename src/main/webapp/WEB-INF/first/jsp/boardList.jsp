<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include-header.jspf"%>
<c:if test="${ csrfError!=null}">
	<c:remove var="csrfError" />
</c:if>
<%-- <c:if test="${ msg!=null}">
	<script type="text/javascript">
		alert("${msg}")
	</script>
</c:if> --%>
</head>
<body>
	<h2>게시판 목록</h2>
	<table class="board_list">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="15%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.IDX }</td>
							<td class="title"><a href="#this" name="title">${row.TITLE }</a>
								<input type="hidden" id="IDX" value="${row.IDX }"></td>
							<td>${row.HIT_CNT }</td>
							<td>${row.CREA_DTM }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	<c:if test="${not empty paginationInfo}">
        <ui:pagination paginationInfo = "${paginationInfo}" type="text" jsFunction="fn_search"/>
    </c:if>
    <input type="hidden" id="currentPageNo" name="currentPageNo"/>
	
	<br />
	<a href="#this" class="btn" id="write">글쓰기</a>

	<%@ include file="../include/include-body.jspf"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#write").on("click", function(e) { //글쓰기 버튼
				e.preventDefault();
				fn_openBoardWrite();
			});

			$("a[name='title']").on("click", function(e) { //제목 
				e.preventDefault();
				fn_openBoardDetail($(this));
			});
		});

		function fn_openBoardWrite() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='openBoardWrite' />");
			comSubmit.submit();
		}

		function fn_openBoardDetail(obj) {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='openBoardDetail' />");
			comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
			comSubmit.submit();
		}
		
		function fn_search(pageNo){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='openBoardListPaging' />");
            comSubmit.addParam("currentPageNo", pageNo);
            comSubmit.submit();
        }
	</script>

	<%@ include file="/debug/debug.jsp"%>
</body>
</html>