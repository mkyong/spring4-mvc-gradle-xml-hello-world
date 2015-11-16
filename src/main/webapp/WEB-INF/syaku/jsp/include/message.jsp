<%-- <%@ include file="include/message.jsp"%> --%>
<c:if test="${ message!=null}">
	<script type="text/javascript">
		alert("${message}")
	</script>
</c:if>
<c:if test="${ msg!=null}">
	<script type="text/javascript">
		alert("${msg}")
	</script>
</c:if>