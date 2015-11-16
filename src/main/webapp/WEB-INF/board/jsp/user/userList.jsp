<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>userList.jsp</title>

<!-- <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="themes/icon.css"> -->
<!-- <script type="text/javascript" src="jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="jquery.easyui.min.js"></script> -->

<jsp:include page="../include/easyui.jsp"></jsp:include>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비번</th>
				<th>닉네임</th>
				<th>가입날자</th>
				<th>탈퇴여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="row">
				<tr>
					<td>${row.u_no}</td>
					<td>${row.u_id}</td>
					<td>${row.u_pw}</td>
					<td>${row.u_nick}</td>
					<td>${row.u_indate}</td>
					<td>${row.u_delete}</td>
					<%-- 					<td><a href="boardDetail?b_no=${row.b_no}">${row.b_title}</a></td> --%>
					<%-- <td>${row.b_content}</td> --%>
					<%-- 					<td><a href="userDetail?u_no=${row.u_no}">${row.u_nick}</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>

	<script type="text/javascript">
		function pg(pageNumber, pageSize) {
			$(location)
					.attr(
							'href',
							'userList?pageNum=' + pageNumber
									+ '&pageSize=' + pageSize
									+ '&shtype=${shtype}&shvalue=${shvalue}')
		}
	</script>
	<div class="easyui-pagination"
		data-options="
			pageList: [5,10,25,50,100,250,500,1000,2500,5000,10000],
			pageNumber:${pageNum },
			total:${totalRowCount },
			pageSize:${pageSize },
			onSelectPage:pg,
			buttons:$('#p_buttons')
			"></div>

	<script type="text/javascript">
		function sch(value, type) {
			$(location).attr('href',
					'userList?&shtype=' + type + '&shvalue=' + value)
		}
	</script>
	<div id="p_buttons">
		<table>
			<!-- style="border-spacing: 0" -->
			<tr>
				<td><input class="easyui-searchbox" style="width: 150px"
					data-options="searcher:sch,prompt:'Please Input Value',menu:'#mm',
					value:'${shvalue }'">
				</td>
				<td><div id="mm" style="width: 120px">
						<div
							data-options="name:'all'	<c:if test="${'all'==shtype }">		,selected:true</c:if>">All</div>
						<div
							data-options="name:'id'		<c:if test="${'id'==shtype }">		,selected:true</c:if>">Id</div>
						<div
							data-options="name:'nick'	<c:if test="${'nick'==shtype }">	,selected:true</c:if>">Nick</div>
					</div></td>
			</tr>
		</table>
	</div>








	<%@ include file="/debug/debug.jsp"%>
</body>
</html>