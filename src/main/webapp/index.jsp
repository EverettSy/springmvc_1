<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOTYPE html PUBLIC "-// W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<body>

<a href="springmvc/testRedirect">Test Redirect</a>
<br><br>

<a href="springmvc/testView">Test View</a>
<br><br>

<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
<br><br>


<!--
   模拟修改操作
   1. 原始数据： 1，Tom,123456,sy759770423@163.com,12
   2. 密码不能 被修改
   3. 表单回显，模拟操作直接在表单填写对应的属性值
	   -->

<form action="springmvc/testModelAttribute" method="post">
	<input type="hidden" name="id" value="1"/>
	username: <input type="text" name="username" value="Raven"/>
	<br>
	email: <input type="text" name="email" value="sy759770423@163.com"/>
	<br>
	age: <input type="text" name="age" value="12">
	<br>
	<input type="submit" value="Submit">
</form>

<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
<br><br>

<a href="springmvc/testMap">Test Map</a>
<br><br>

<a href="springmvc/testModelAndView">Test ModelAndView</a>
<br><br>

<a href="springmvc/testServletAPI">Test ServletAPI</a>
<br><br>

<form action="springmvc/testPojo">
	username：<input type="text" name="username"/>
	<br>
	password：<input type="password" name="password"/>
	<br>
	email： <input type="text" name="email"/>
	<br>
	age：<input type="text" name="age"/>
	<br>
	city：<input type="text" name="address.city"/>
	<br>
	province：<input type="text" name="address.province"/>
	<br>
	
	<input type="submit" value="Submit">
</form>
<br><br>
<a href="springmvc/testCookieValue">Test testCookieValue Page</a>
<br><br>
<a href="springmvc/testRequestHeader">Test testRequestHeader Page</a>
<br><br>

<a href="springmvc/testRequestParam?username=raven&age=11">Test RequestParam Page</a>
<br><br>

<form action="springmvc/testMethod" method="post">
	<input type="submit" value="submit">
</form>
<form action="springmvc/testRest/1" method="post">
	<input type="hidden" name="_method" value="PUT">
	<input type="submit" value="TestRest PUT">
</form>
<br><br>
<form action="springmvc/testRest/1" method="post">
	<input type="hidden" name="_method" value="DELETE">
	<input type="submit" value="TestRest DELETE">
</form>
<br><br>

<form action="springmvc/testRest" method="post">
	<input type="submit" value="TestRest POST">
</form>
<br><br>

<a href="springmvc/testRest/1">Test REST Get</a>
<br><br>


<a href="springmvc/testPathVariable/1">Test PathVariable</a>
<br><br>
<a href="springmvc/testAntPath/mv/abc">Test AntPath</a>
<br><br>
<a href="springmvc/testParamsAndHeaders?username=raven&age=10">testParamsAndHeaders</a>
<br><br>
<br><br>
<a href="springmvc/testMethod">testMethod</a>
<br><br>
<a href="springmvc/testRequestMapping">testRequestMapping</a>
<br><br>
<a href="helloworld">Hello World</a>
</body>
</html>
