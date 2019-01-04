<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<body>
<form action="springmvc/testMethod" method="post">
	<input type="submit" value="submit">
</form>
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
