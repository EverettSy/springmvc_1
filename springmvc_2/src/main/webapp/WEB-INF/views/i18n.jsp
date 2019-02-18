<%--
  Created by IntelliJ IDEA.
  User: YuSong
  Date: 2019/2/18
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>Title</title>
</head>
<body>
	
	<fmt:message key="il8n.user"></fmt:message>

	<br><br>
	<a href="i18n2">I18N2 PAGE</a>
	
	<br><br>
	<a href="i18n?locale=zh_CH">中文</a>
	
	<br><br>
	<a href="i18n?locale=en_US">英文</a>

</body>
</html>
