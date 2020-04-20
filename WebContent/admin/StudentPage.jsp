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
	&nbsp;&nbsp;[${pb.currentPage }/${pb.totalPage }]&nbsp;&nbsp;
	每页${pb.rows }条&nbsp;&nbsp;
	共${pb.totalCount }条记录
	<table border="1">
		<tr bgcolor="aabbcc">
			<td>序号</td>
			<td>姓名</td>
			<td>专业</td>
			<td>班级</td>
			<td>实习类型</td>
			<td>指导教师</td>
		</tr>
		<c:forEach var="lists" items="${pb.list }" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${lists.username }</td>
				<td>${lists.sort }</td>
				<td>${lists.userclass }</td>
				<td>${lists.sxtype }</td>
				<td>${lists.teacher }</td>
			</tr>
		</c:forEach>
	</table>
	<form name="form1" action="${pageContext.request.contextPath }/admin/findStudentByPage.action">
	         请输入页次：<input name="currentPage" type="text" size="4">
	         <input type="hidden" name="totalPage" value="${pb.totalPage}">
	    <input type="submit" name="Submit" value="GO"><BR>
	</form>

	[<a href='${pageContext.request.contextPath }/admin/findStudentByPage.action?currentPage=1&rows=${pb.rows}'>首页</a>]&nbsp;
	[<a href='${pageContext.request.contextPath }/admin/findStudentByPage.action?currentPage=${pb.currentPage - 1}&rows=${pb.rows}'>上页</a>]&nbsp;
	[<a href='${pageContext.request.contextPath }/admin/findStudentByPage.action?currentPage=${pb.currentPage + 1}&rows=${pb.rows}&totalPage=${pb.totalPage}'>下页</a>]&nbsp;
	[<a href='${pageContext.request.contextPath }/admin/findStudentByPage.action?currentPage=${pb.totalPage }&rows=${pb.rows}'>尾页</a>]&nbsp;

	<br><br><br>
	<a href="${pageContext.request.contextPath }/admin/welcome.action">返回</a>
</body>
</html>
