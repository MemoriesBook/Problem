<%@page import="com.wdg.bean.User_reg"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.wdg.dao.impl.UserDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'reg.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<script language="javascript">
		function checksignup() {
			var r1, r2
			r1 = new RegExp('[^0-9]', '');
			r2 = (document.formSignUp.age.value.length == 2);

			if (document.formSignUp.user.value == '') {
				window.alert('请输入用户名!!');
				document.formSignUp.user.focus();
			} else if (document.formSignUp.pw.value == '') {
				window.alert('请输入口令!!');
				document.formSignUp.pw.focus();
			} else if (document.formSignUp.pw.value.length < 6) {
				window.alert('口令不得少于6个字符!!');
				document.formSignUp.pw.focus();
			} else if (document.formSignUp.pw.value != document.formSignUp.signup_pw.value) {
				window.alert('验证口令错误!!');
				document.formSignUp.signup_pw.focus();
			} else if (document.formSignUp.age.value.search(r1) >= 0) {
				window.alert('请输入正确的年龄!!');
				document.formSignUp.age.focus();
			} else if (!r2) {
				window.alert('年龄的长度不正确!!');
				document.formSignUp.age.focus();
			} else if (document.formSignUp.email.value.indexOf('@', 0) == -1
					|| document.formSignUp.email.value == ''
					|| document.formSignUp.email.value.indexOf('.', 0) == -1) {
				window.alert('请重新输入正确的电子邮件地址!!');
				document.formSignUp.email.focus();
			} else {
				return true;
			}
			return false;
		}
	</script>
<body>

	<FORM METHOD=POST ACTION="${pageContext.request.contextPath }/admin/modify.action" NAME="formSignUp">
		注册户名：${user.user }<br> 
		       <INPUT TYPE="hidden" NAME="id" value="${user.id }"><br> 
		登陆口令：<INPUT TYPE="password" NAME="pw" value="${user.pw }"><br> 
		用户年龄：<INPUT TYPE="text" NAME="age" value="${user.age }"><br> 
		电子邮箱：<INPUT TYPE="text" NAME="email" value="${user.email }"><br> 
		<INPUT TYPE="submit" value="提交" onclick="javascript:return checksignup()"> 
		<INPUT TYPE="reset" value="重写">
	</FORM>
</body>
</html>
