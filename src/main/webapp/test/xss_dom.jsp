<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var a = document.URL
		a = a.substring(a.indexOf("message=") + 8, a.length)
		a = unescape(a)
		//document.write(a.substring(a.indexOf("message=")+8, a.length))		
		var rg = "/^([0-9A-Za-z+\s])*$"
		if (rg.test(a)) {
			var data = sanitize(a)
			document.getElementById("resultData").innerHTML = data
		} else {
						
		}
	}
	function sanitize(str) {
		var p=document.createElement("p")
		p.appendChild(document.createTextNode(str))
		return p.innerHTML
	}
</script>
</head>
<body>

</body>
</html>