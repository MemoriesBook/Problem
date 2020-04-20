<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>

<title>My JSP 'look.jsp' starting page</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<style type="text/css">
td,th {
	text-align: center;
}
</style>
<script type="text/javascript">
	function deleteUser(id) {
		if (confirm("你确定要删除该用户信息吗？")) {
			location.href = "delete.action?id=" + id;
		}
	}
</script>
</head>

<body>
	<div class="container">


		<h3 style="text-align: center;">
			<font color="FF0000">${username }</font>的后台管理页面
		</h3>
		<h4>&nbsp;&nbsp;[${pb.currentPage }/${pb.totalPage }]&nbsp;&nbsp;
			每页${pb.rows }条&nbsp;&nbsp; 共${pb.totalCount }条记录</h4>
		<table border="1" class="table table-bordered table-hover">
			<tr bgcolor="#eeee99">
				<th>序号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>邮箱</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			<c:forEach var="lists" items="${pb.list }" varStatus="s">
				<tr>
					<td>${(pb.currentPage-1)*pb.rows+s.count}</td>
					<td>${lists.user }</td>
					<td>${lists.age }</td>
					<td>${lists.email }</td>
					<td><a class="btn btn-default btn-sm"
						href="javascript:deleteUser(${lists.id });">删除</a></td>
					<td><a class="btn btn-default btn-sm"
						href='findUser.action?id=${lists.id }'>修改</a></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<ul class="pagination">
			    <!-- 当前页等于1时，“<<”是禁用的 -->
				<c:if test="${pb.currentPage == 1}">
					<li class="disabled">
				</c:if>

				<c:if test="${pb.currentPage != 1}">
					<li>
				</c:if>
				<a
					href="${pageContext.request.contextPath}/admin/findUserByPage.action?currentPage=${pb.currentPage - 1}&rows=${pb.rows }">&laquo;
				</a>
				</li>

				<c:forEach begin="1" end="${pb.totalPage}" var="i">
					<c:if test="${pb.currentPage == i}">
						<li class="active"><a
							href="${pageContext.request.contextPath}/admin/findUserByPage.action?currentPage=${i}&rows=${pb.rows }">${i}</a></li>
					</c:if>
					<c:if test="${pb.currentPage != i}">
						<li><a
							href="${pageContext.request.contextPath}/admin/findUserByPage.action?currentPage=${i}&rows=${pb.rows }">${i}</a></li>
					</c:if>
				</c:forEach>
                <!-- 当前页等于总页数时，“>>”是禁用的 -->
				<c:if test="${pb.currentPage == pb.totalPage}">
					<li class="disabled">
				</c:if>
				<c:if test="${pb.currentPage < pb.totalPage}">
					<li>
				</c:if>
				<a
					href="${pageContext.request.contextPath}/admin/findUserByPage.action?currentPage=${pb.currentPage + 1}&rows=${pb.rows }&totalPage=${pb.totalPage}">
					&raquo; </a>
				</li>
			</ul>
		</div>
		<br> <a href="${pageContext.request.contextPath }/admin/welcome.action">返回</a>
	</div>
</body>
</html>
