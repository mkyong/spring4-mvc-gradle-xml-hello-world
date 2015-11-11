<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>sample</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/jquery/3.0.0-alpha1/jquery.js"></script>
<script src="jquery-1.11.3.js"></script>
<script src="jquery-1.11.3.min.js"></script>
</head>
<body>
	<h1>Hello world! sample</h1>

	<P>The time on the server is ${serverTime}.</P>

	<script type="text/javascript">
	
		$(function() {
			
			//	쿼리 작동 테스트용
			$("#jquery_result").html("jquery test")
			
			//	아작스 테스트용
			$("#jquery_menu a").click(
					function() {
						var url = $(this).attr("href")
						$.ajax({
							method : "GET",
							url : url,
							success : function(values) {
								
								$("#jquery_result").html(values + "<br>")

								//	배열 받기
								$.each(values, function(index, value) {
									$("#jquery_result")
											.append(
													index + " : " + value
															+ "<br>")
								})
							}
						})
						//	링크 기능 해제
						return false
					})
		})
	</script>

	<h1>link menu</h1>

	<div id="menu">
		<ol>
			<li><a href="/defult/sample/">sample home</a></li>
			<li><a href="sampleController">sampleController</a></li>
			<li><a href="sampleResponseBody">sampleResponseBody</a></li>
			<li><a href="sampleResponseBodyList">sampleResponseBodyList</a></li>
			<li><a href="sampleResponseBodyMap">sampleResponseBodyMap</a></li>
		</ol>
	</div>

	<h1>jquery_menu</h1>

	<div id="jquery_menu">
		<ol>
			<li><a href="sampleResponseBody">sampleResponseBody</a></li>
			<li><a href="sampleResponseBodyList">sampleResponseBodyList</a></li>
			<li><a href="sampleResponseBodyMap">sampleResponseBodyMap</a></li>
		</ol>
	</div>
	<!-- 결과 출력용 -->
	<p id="jquery_result"></p>

	<%@ include file="/debug/debug.jsp"%>
</body>
</html>
