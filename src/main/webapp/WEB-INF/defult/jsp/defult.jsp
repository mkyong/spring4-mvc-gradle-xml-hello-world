<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>defult</title>
</head>
<body>
<h1>
	Hello world!  defult
</h1>

<P>  The time on the server is ${serverTime}. </P>

<%@ include file="/debug/debug.jsp" %>
</body>
</html>
