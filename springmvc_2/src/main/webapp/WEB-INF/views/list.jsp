<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2019/1/17
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>Title</title>
	<%--
	   SpringMVC 处理静态资源：
	   1. 为什么会有这个问题
	   优雅的REST 风格的资源URL 不希望带.html或者.do等后缀
	   若将DispatcherServlet 请求映射配置为/,
	   则SpringMVC将捕获web容器的所有请求，包括静态资源的请求，
	   SpringMVC会将他们当成一个普通请求处理，因找不到对应处理器将导致错误。
	   2.解决：
	   在SpringMVC的配置文件中配置
	   <mvc:default-servlet-handler/>
	--%>
	<script src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$(".delete").click(function () {
			    var href = $(this).attr("href");
				$("form").attr("action",href).submit();
			    return false;
            });
        })
	</script>
</head>
<body>

	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>

	<c:if test="${empty requestScope.employeeMap}">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employeeMap}">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach items="${requestScope.employeeMap}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>${emp.gender == 0 ? 'Female':'Male'}</td>
					<td>${emp.department.departmentName}</td>
					<td><a href="emp/${emp.id}">修改</a> </td>
					<td><a class="delete" href="emp/${emp.id}">删除</a> </td>
					
			</c:forEach>
		</table>
	</c:if>
<br><br>
<a href="emp">Add New Employee</a>
</body>
</html>
