<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>login</title>

</head>

<body>
	<script type="text/javascript">
		function refreshCode() {
			var vcode = document.getElementById("vcode");
			vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="
					+ new Date().getTime();
		}
	</script>
	${error }
	<form action="${pageContext.request.contextPath }/login.action" method="post">
		用户名：<input type="text" name="user" style="width: 150px"><br><br>
		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pw" style="width: 150px"><br>
		验证码：<input type="text" name="verifycode" style="width: 150px"> 
		<a href="javascript:refreshCode()">
            <img src="${pageContext.request.contextPath}/checkCodeServlet" id="vcode" />
		</a> <br><br> <input type="submit" value="提交">
	</form>
	<br>
	<br> 如果你没有账号，请先
	<a href="${pageContext.request.contextPath }/reg.jsp">注册</a>。
</body>
</html>
