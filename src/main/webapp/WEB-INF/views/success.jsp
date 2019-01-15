<%--
  Created by IntelliJ IDEA.
  User: Raven
  Date: 2019/1/3
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>Title</title>
</head>
<body>
<h4> Success Page</h4>
time: ${requestScope.time}
<br>
name: ${requestScope.names}
<br>
request user: ${requestScope.user}
<br><br>
session user: ${sessionScope.user}
<br><br>
request user: ${requestScope.school}
<br><br>
session user: ${sessionScope.school}
<br><br>

abc user: ${requestScope.abc}
<br><br>

user user: ${requestScope.user}
<br><br>

<fmt:message key="i18n.username"></fmt:message>
<br><br>

<fmt:message key="i18n.password"></fmt:message>
<br><br>
</body>
</html>
