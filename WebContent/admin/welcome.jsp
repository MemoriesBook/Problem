<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>login</title>

</head>

<body>
	<c:set value="${grade }" var="g" />
	<c:choose>
		<c:when test="${g>2 }">
			<font color="FF0000">${username }</font>为超级用户的后台管理页面，进行如下操作：
	<br>
			<a href="${pageContext.request.contextPath }/admin/looklist.action">用户列表（JSTL方式）</a>
			<br>
			<a href="${pageContext.request.contextPath }/admin/findUserByPage.action">分页显示一（JSTL、bootstrap样式）</a>
			<br>
			<a href="${pageContext.request.contextPath }/admin/findStudentByPage.action">分页显示二（JSTL样式）</a>
			<br>
			<a href="${pageContext.request.contextPath }/admin/selectKeyPage.action">组合查询查询示例一：模糊查询</a>
			<br>
			<a href="${pageContext.request.contextPath }/admin/selectFieldPage.action">组合查询查询示例二：筛选条件模糊查询</a>
			<br>
			<br>
		</c:when>
		<c:otherwise>
			<font color="FF0000">${username }</font>为普通用户的后台管理页面，进行如下操作：
	<br>
			<br>
			<a href="${pageContext.request.contextPath }/admin/looklist.action">用户列表</a>
		</c:otherwise>
	</c:choose>

	<br>
	<br>
	<a href="${pageContext.request.contextPath }/logout.action">退出</a>
</body>
</html>
