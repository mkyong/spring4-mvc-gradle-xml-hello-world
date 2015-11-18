<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<%@ include file="/include/ink_head.jsp"%>

<style>
body {
	background: #ededed;
}

.panel {
	border-radius: 2px;
	-webkit-box-shadow: #dddddd 0 1px 1px 0;
	-moz-box-shadow: #dddddd 0 1px 1px 0;
	box-shadow: #dddddd 0 1px 1px 0;
	padding: 1em;
	border: 1px solid #BBB;
	background-color: #FFF;
}

.text {
	word-break: break-all;
}
</style>
</head>
<body>

	<!--[if lte IE 9 ]>
    <div class="ink-alert basic" role="alert">
        <button class="ink-dismiss">&times;</button>
        <p>
            <strong>You are using an outdated Internet Explorer version.</strong>
            Please <a href="http://browsehappy.com/">upgrade to a modern browser</a> to improve your web experience.
        </p>
    </div>
    -->

	<div class="panel">

		<nav id="p1" class="p1 ink-navigation">
			<ul class="pagination black">
			</ul>
		</nav>

		<div id="car1" class="ink-carousel"
			data-space-after-last-slide="false" data-autoload="false">

			<ul class="stage column-group half-gutters">
				<!--  -->
				<c:forEach items="${BoardList}" var="row">
					<li class="slide xlarge-33 large-50 medium-50 small-100 tiny-100">
						<!-- <img class="half-bottom-space" src="http://lorempixel.com/400/200/sports/1"> -->
						<div class="description">
							<!--  <h4 class="no-margin">Highlight Title</h4> -->
							<h5 class="slab">${row.b_no }/${row.b_nick  }/${row.b_date  }</h5>
							<p class="text">${row.b_text  }</p>
						</div>
					</li>
				</c:forEach>
				<!--  -->
			</ul>

		</div>

		<nav id="p1" class="p1 ink-navigation">
			<ul class="pagination black">
			</ul>
		</nav>

	</div>

	<script>
		Ink.requireModules([ 'Ink.UI.Carousel_1' ], function(InkCarousel) {
			new InkCarousel('#car1', {
				pagination : '.p1'
			});
		});
	</script>

	<div class="panel">
		<c:forEach items="${BoardList}" var="row">
			<div id="row${row.b_no  }" class="row" value="${row.b_no  }">
				<div class="all-10">${row.b_no  }</div>
				<div class="all-20">${row.b_nick  }</div>
				<div class="all-50">
					<a href="boardEdit" class="edit" value="${row.b_no  }">수정하기</a> <a
						href="boardEdit" class="editok hide-all" value="${row.b_no  }">수정전송</a>
					<a href="boardDelete" class="delete" value="${row.b_no  }">삭제하기</a>
					<a href="boardDelete" class="deleteok hide-all"
						value="${row.b_no  }">삭제전송</a> <a href="boardDelete"
						class="no hide-all" value="${row.b_no  }">취소</a> <input
						type="password" class="pw hide-all" />
				</div>
				<div class="all-20 align-right">${row.b_date  }</div>
				<div class="all-100 text">${row.b_text  }</div>
			</div>
		</c:forEach>
	</div>

	<script type="text/javascript">
		function a(dv) {
			var url = dv.attr("href")
			var b_no = dv.attr("value")
			// 			$("").p
			alert("url:" + url + ",b_no:" + b_no)
			return false
		}

		$(function() {
			$(".edit").click(
					function() {
						var txt = $(this).parent().siblings(".text")
						var b_text = txt.html()
						// 				alert(b_text)
						txt.addClass("hide-all")
						$(this).parents(".row").append(
								"<textarea name='b_text' id='' class='all-100 text' rows='5'>"
										+ b_text + "</textarea>")

						$(this).addClass("hide-all")
						$(this).siblings(".editok").removeClass("hide-all")
						$(this).siblings(".delete").addClass("hide-all")
						$(this).siblings(".deleteok").removeClass("hide-all")
						$(this).siblings(".no").removeClass("hide-all")
						$(this).siblings(".pw").removeClass("hide-all")
						return false
					})
			$(".editok").click(function() {
				$(this).siblings(".edit").removeClass("hide-all")
				$(this).addClass("hide-all")
				$(this).siblings(".delete").removeClass("hide-all")
				$(this).siblings(".deleteok").addClass("hide-all")
				$(this).siblings(".no").addClass("hide-all")
				$(this).siblings(".pw").addClass("hide-all")
				var txt=$(this).parent().siblings("textarea").val()
				$(this).parent().siblings(".text").html(txt)
				$(this).parent().siblings(".text").removeClass("hide-all")
				$(this).parent().siblings("textarea").remove()
				// 				a($(this))
				return false
			})
			$(".delete").click(function() {
				$(this).siblings(".edit").removeClass("hide-all")
				$(this).siblings(".editok").addClass("hide-all")
				$(this).addClass("hide-all")
				$(this).siblings(".deleteok").removeClass("hide-all")
				$(this).siblings(".no").removeClass("hide-all")
				$(this).siblings(".pw").removeClass("hide-all")
				$(this).parent().siblings("textarea").remove()
				// 				a($(this))
				return false
			})
			$(".deleteok").click(function() {
				$(this).parents(".row").remove()
				// 				a($(this))
				return false
			})
			$(".no").click(function() {
				$(this).siblings(".edit").removeClass("hide-all")
				$(this).siblings(".editok").addClass("hide-all")
				$(this).siblings(".delete").removeClass("hide-all")
				$(this).siblings(".deleteok").addClass("hide-all")
				$(this).addClass("hide-all")
				$(this).siblings(".pw").addClass("hide-all")
				$(this).parent().siblings("textarea").remove()
				$(this).parent().siblings(".text").removeClass("hide-all")
				// 				a($(this))
				return false
			})
			/* 			$(".edit").click(function() {
			 var url = $(this).attr("href")
			 var no = $(this).parent(".row").attr("value")
			 alert("url:" + url + ",no:" + no)
			 return false
			 })
			 $(".delete").click(function() {
			 var url = $(this).attr("href")
			 var no = $(this).parent(".row").attr("value")
			 alert("url:" + url + ",no:" + no)
			 return false
			 }) */
		})
	</script>

	<%-- <table class="ink-table bordered hover panel">
			<thead>
				<tr class="half-gutters">
					<th class="all-10">NICK/NO/DATE</th>
					<!-- <th class="all-10"></th> -->
					<th class="all-90">TEXT</th>
					<!-- <th class="all-10"></th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BoardList}" var="row">
					<tr class="half-gutters">
						<td class="all-100">${row.b_nick  }<br>${row.b_no    }<br>${row.b_date  }</td>
						<td class="all-10">${row.b_pw    }</td>
						<td class="all-100">${row.b_text  }</td>
						<td class="all-10">${row.b_date  }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table> --%>

	<%@ include file="/debug/debug.jsp"%>
</body>
</html>
