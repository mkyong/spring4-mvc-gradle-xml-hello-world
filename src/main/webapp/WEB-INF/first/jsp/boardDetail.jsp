<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../include/include-header.jspf"%>
</head>
<body>
	<table class="board_view">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<caption>게시글 상세</caption>
		<tbody>
			<tr>
				<th scope="row">글 번호</th>
				<td>${map.IDX }</td>
				<th scope="row">조회수</th>
				<td>${map.HIT_CNT }</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${map.CREA_ID }</td>
				<th scope="row">작성시간</th>
				<td>${map.CREA_DTM }</td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${map.TITLE }</td>
			</tr>
			<tr>
				<td colspan="4">${map.CONTENTS }</td>
			</tr>
			<c:if test="${list!=null }">
			<tr>
				<th scope="row">첨부파일</th>
				<td colspan="3"><c:forEach var="row" items="${list }">
						<p>
							<input type="hidden" id="IDX" value="${row.IDX }"> <a
								href="#this" name="file">${row.ORIGINAL_FILE_NAME }</a>
							(${row.FILE_SIZE }kb)
						</p>
					</c:forEach></td>
			</tr>
			</c:if>
		</tbody>
	</table>
	<br />

	<a href="#this" class="btn" id="list">목록으로</a>
	<a href="#this" class="btn" id="update">수정하기</a>

	<%@ include file="../include/include-body.jspf"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#list").on("click", function(e) { //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});

			$("#update").on("click", function(e) { //수정하기 버튼
				e.preventDefault();
				fn_openBoardUpdate();
			});

			$("a[name='file']").on("click", function(e) { //파일 이름
				e.preventDefault();
				fn_downloadFile($(this));
			});
		});

		function fn_openBoardList() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='openBoardList' />");
			comSubmit.submit();
		}

		function fn_openBoardUpdate() {
			var idx = "${map.IDX}";
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='openBoardUpdate' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}
		function fn_downloadFile(obj) {
			var idx = obj.parent().find("#IDX").val();
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='common/downloadFile' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
			comSubmit.reset()
		}
		function fn_addFile() {
			var str = "<p>" + "<input type='file' id='file_" + (gfv_count)
					+ "' name='file_" + (gfv_count) + "'>"
					+ "<a href='#this' class='btn' id='delete_" + (gfv_count)
					+ "' name='delete_" + (gfv_count) + "'>삭제</a>" + "</p>";
			$("#fileDiv").append(str);
			$("#delete_" + (gfv_count++)).on("click", function(e) { //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});
		}

		function fn_deleteFile(obj) {
			obj.parent().remove();
		}
	</script>
	<%@ include file="/debug/debug.jsp"%>
</body>
</html>