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
</head>
<body>
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
					<td><a href="">Edit</a> </td>
					<td><a href="">Delete</a> </td>
					
			</c:forEach>
		</table>
	</c:if>
<br><br>
<a href="emp">Add New Employee</a>
</body>
</html>
