<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/static/jquery-1.11.1.min.js"></script>

</head>
<body>
	json page:
	<input type="button" value="send" onclick="sendJson()">
	<script type="text/javascript">
			function sendJson(){
				$.ajax({
					contentType:'application/json',
					type:'post',
					url:'${pageContext.request.contextPath}/json/test2',
					data:'{"id":"123","name":"WHH","desc":"Wonderful"}',
					success:function(data){
						$("body").append(data);
					}
				});					
			}
	</script>
</body>
</html>