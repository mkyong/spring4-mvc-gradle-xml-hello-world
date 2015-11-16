<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div class="hint" id="div">
	
		<form action="xss_test1.jsp" id="form1" method="post">
			xss_test1.jsp <br /> <input type="text" name="data" id="data1"
				size="50" value="&lt;script&gt;alert('xss')&lt;/script&gt;" /> <input
				type="submit" value="run" />
			&lt;script&gt;alert("xss")&lt;/script&gt; 라고 입력하기
		</form>
		
		<form action="xss_test2.jsp" id="form1" method="post">
			xss_test2.jsp <br /> <input type="text" name="data" id="data1"
				size="50" value="1" /> <input type="submit" value="run" /> <label
				for="">입력값 1or2</label>
		</form>
		
		<form action="xss_test3.jsp" id="form1" method="post">
			xss_test3.jsp -> xss_dom.jsp?message= <br /> <input type="text"
				name="data" id="data1" size="50"
				value="&lt;script&gt;alert('xss')&lt;/script&gt;" /> <input
				type="submit" value="run" />
			&lt;script&gt;alert("xss")&lt;/script&gt;
		</form>
		
		<form action="xss_test4.jsp" id="form1" method="post">
			xss_test4.jsp <br /> <input type="text" name="data" id="data1"
				size="50" value="&lt;script&gt;alert('xss')&lt;/script&gt;" /> <input
				type="submit" value="run" />
			&lt;script&gt;alert("xss")&lt;/script&gt;
		</form>
		
		<form action="xss_test4.jsp" id="form1" method="post">
			xss_test4.jsp <br />
			<textarea name="data" id="data1">&lt;script&gt;alert('xss')&lt;/script&gt;</textarea>
			<input type="submit" value="run" />
			&lt;script&gt;alert("xss")&lt;/script&gt;
		</form>
		
		<form action="../sample/xss_test" id="form1" method="post">
			../sample/xss_test -> xss_result.jsp <br />
			<textarea name="data" id="data1">&lt;script&gt;alert('xss')&lt;/script&gt;</textarea>
			<input type="submit" value="run" />
			&lt;script&gt;alert("xss")&lt;/script&gt;
		</form>

	</div>
	
	<%@ include file="/debug/debug.jsp"%>
	
</body>
</html>