<%@page import="java.sql.ResultSet"%>
<%@page import="com.wdg.dao.impl.UserDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'look.jsp' starting page</title>

</head>

<body>
	<font color="FF0000">${username }</font>的后台管理页面。
	<br>

	<form action="${pageContext.request.contextPath }/admin/selectUserKey.action"
		method="post">
		请输入学生姓名关键字： <input type="text" name="key"> <input type="submit" value="查询">
	</form>

	<c:choose>
		<c:when test="${key==null || key==''}">
                              请输入关键字进行查询！
		</c:when>
		<c:otherwise>
	显示数据库表
	<br>
	满足学生姓名查询关键字：<font color=red>${key }</font> 的条件如下：<br>
			<table border="1">
				<tr bgcolor="aabbcc">
					<th>序号</th>
					<th>姓名</th>
					<th>专业</th>
					<th>班级</th>
					<th>实习类型</th>
					<th>指导教师</th>
				</tr>
				<c:forEach var="lists" items="${requestScope.stu_list }"
					varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${lists.username }</td>
						<td>${lists.sort }</td>
						<td>${lists.userclass }</td>
						<td>${lists.sxtype }</td>
						<td>${lists.teacher }</td>
					</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>
			</table>
			<br>
			<br>
			<a href="${pageContext.request.contextPath }/admin/welcome.action">返回</a>
			<br>
</body>
</html>
