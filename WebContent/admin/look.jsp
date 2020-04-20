<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'look.jsp' starting page</title>

</head>

<body>
	<font color="FF0000">${username }</font>的后台管理页面。
	<br> 显示数据库表
	<br>
	<form
		action="${pageContext.request.contextPath }/admin/delSelecte.action"
		method="post">
		<table border="1">
			<tr bgcolor="#eeee99">
				<c:if test="${grade >2 }">
					<td>选择</td>
					<td>序号</td>
				</c:if>
				<td>姓名</td>
				<td>年龄</td>
				<td>邮箱</td>
				<c:if test="${grade >2 }">
					<td>删除</td>
				</c:if>
				<td>修改</td>
			</tr>
			<c:forEach var="lists" items="${requestScope.lookList }"
				varStatus="s">
				<tr>
					<c:if test="${grade >2 }">
						<td><input type="checkbox" value="${lists.id}" name="ids"></td>
						<td>${s.count}</td>
					</c:if>
					<td>${lists.user }</td>
					<td>${lists.age }</td>
					<td>${lists.email }</td>
					<c:if test="${grade >2 }">
						<td><a href='delete.action?id=${lists.id }'>删除</a></td>
					</c:if>
					<td><a href='findUser.action?id=${lists.id }'>修改</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${grade >2 }">
			<input type="submit" value="批量删除">
		</c:if>
	</form>
	<br>
	<a href="${pageContext.request.contextPath }/admin/welcome.action">返回</a>
</body>
</html>
