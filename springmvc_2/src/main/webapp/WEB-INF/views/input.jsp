<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2019/1/18
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>Title</title>
</head>
<body>

<form action="testConversionServiceConverer" method="post">
	<!-- lastname-email-gender-department.id 例如： GG-gg@163.com-0-105 -->
	Employee: <input type="text" name="employee"/>
	<input type="submit" value="Submit">
</form>
<br>
<%--
 1.为什么使用form标签呢？
 可以快速快速进行
 
 2.注意：
 可以通过modelAttribute 属性指定绑定的模型属性，
 若没有指定该属性，则默认从request 域对象中读取command 的表单bean
 如果该属性值也不存在，则会发生错误。
--%>

<form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="employee">
	
	<%--<form:errors path="*"></form:errors>--%>
	<br>
	
	<c:if test="${employee.id == null}">
		<%-- path属性对应html表单标签的name属性值--%>
		LastName: <form:input path="lastName"/>
		<form:errors path="lastName"></form:errors>
	</c:if>
	<c:if test="${employee.id != null}">
		<form:hidden path="id"/>
		<input type="hidden" name="_method" value="PUT"/>
	</c:if>
	
	<br>
	Email: <form:input path="email"/>
	<form:errors path="email"></form:errors>
	<br>
	<%
		Map<String, String> genders = new HashMap();
		genders.put("1", "Male");
		genders.put("0", "Female");
		
		request.setAttribute("genders", genders);
	%>
	Gender:
	<br>
	<form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
	<br>
	Department: <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"/>
	<br>
	
	<!--
	1.数据类型转换
	2.数据类型格式化
	3.数据校验。
	1）.如何校验？ 注解？
	①、使用JSR 303验证标准
	②、加入hibernate validator 验证框架
	③、在SpringMVC 配置文件中添加<mvc:annotation-driven/>
	④、需要在bean的属性上添加对应的注释
	⑤、在目标方法bean类型的前面@Valid 注释
	
	2）.验证出错转向到哪一个页面
	注意： 需校验的Bean对象和其绑定结果对象或错误对象时成对出现的，他们之间不允许申明其他的入参
	
	3）.错误消息？如何显示，如何把错误消息进行国际化
	-->
	
	Birth: <form:input path="birth"/>
	<form:errors path="birth"></form:errors>
	<br>
	Salary: <form:input path="salary"/>
	<br>
	<input type="submit" value="Submit">
</form:form>
</body>
</html>
