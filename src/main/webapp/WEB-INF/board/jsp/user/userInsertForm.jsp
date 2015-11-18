<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<jsp:include page="../include/easyui.jsp"></jsp:include>
</head>
<body>
	<c:if test="${msg != null}">
		<script type="text/javascript">
			alert('${msg}')
		</script>
	</c:if>
	<script type="text/javascript">
		$.extend($.fn.validatebox.defaults.rules, {
			equals : {
				validator : function(value, param) {
					return value == $(param[0]).val();
				},
				message : '위 비번과 일치하지 않습니다.'
			},
			minLength : {
				validator : function(value, param) {
					return value.length >= param[0];
				},
				message : '최소 {0} 글자 이상 적어주세요.'
			}
		});
		$(function() {
			$("#send").click(function() {
				$('#ff').form('submit', {
					url : "userInsert",
					onSubmit : function(param) {
						param.p1 = 'value1';
						param.p2 = 'value2';
						// do some check
						// return false to prevent submit;
					}
// 					,success : function(data) {
// 						alert(data)
// 					}
				});
			})

		})
	</script>
	<form id="ff" method="post">
		<div>
			<label for="id">Id:</label> <input class="easyui-validatebox"
				type="text" name="id"
				data-options="
				required:true
				,missingMessage:'아뒤 입력하세요'
				,invalidMessage:'아뒤'
				" />
		</div>
		<!-- 		<div>
			<label for="pw">Pw:</label> <input id="pwd"
				class="easyui-validatebox" type="password" name="pw"
				data-options="
				required:true
				,missingMessage:'비번 입력하세요'
				,invalidMessage:'비번'
				" />
		</div> -->
		<div id="">
			<label for="pwd">Pw:</label> <input id="pwd" name="pwd"
				type="password" class="easyui-validatebox"
				data-options="
				required:true
				,missingMessage:'비번 입력하세요'
				,validType:['minLength[6]']
				">
		</div>
		<div>
			<label for="rpwd">Pw re:</label> <input id="rpwd" name="rpwd"
				type="password" class="easyui-validatebox" required="required"
				validType="equals['#pwd']"
				data-options="
				missingMessage:'비번 입력하세요'
				">

		</div>

		<div>
			<label for="nick">Nick:</label> <input class="easyui-validatebox"
				type="text" name="nick"
				data-options="
				required:true
				,missingMessage:'닉네임 입력하세요'
				,invalidMessage:'닉네임'
				" />
		</div>
		<div id="">
			<input id="send" type="button" value="전송" />
		</div>
	</form>
	<pre>	
//==================================================
$('#ff').form({
    url:...,
    onSubmit: function(){
        // do some check
        // return false to prevent submit;
    },
    success:function(data){
        alert(data)
    }
});
// submit the form
$('#ff').submit();

//==================================================
// call 'submit' method of form plugin to submit the form
$('#ff').form('submit', {
    url:...,
    onSubmit: function(){
        // do some check
        // return false to prevent submit;
    },
    success:function(data){
        alert(data)
    }
});

//==================================================
$('#ff').form('submit', {
    url:...,
    onSubmit: function(param){
        param.p1 = 'value1';
        param.p2 = 'value2';
    }
});

//==================================================
{
    "success": true,
    "message": "Message sent successfully."
}

$('#ff').form('submit', {
    success: function(data){
        var data = eval('(' + data + ')');  // change the JSON string to javascript object
        if (data.success){
            alert(data.message)
        }
    }
});
</pre>

</body>
</html>