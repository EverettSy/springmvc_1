<%--
  Created by IntelliJ IDEA.
  User: YuSong
  Date: 2019/1/19
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>Title</title>
	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
        $(function () {
            $("#testJson").click(function () {
                var url = this.href;
                var args = {};
                $.post(url, args, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var id = data[i].id;
                        var lastName = data[i].lastName;

                        alert(id + ": " + lastName);
                    }
                });
                return false;
            });
        })
	</script>
</head>
<body>

<form action="testFileUpload" method="post" enctype="multipart/form-data">
	File： <input type="file" name="file"/>
	DeSsc: <input type="text" name="desc"/>
	<input type="submit" value="Submit"/>
</form>
<br><br>

<a href="emps">List emps</a>

<br><br>

<a href="emp">input</a>

<br><br>
<a href="testJson">Test Json</a>

<br><br>

<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data>">
	File： <input type="file" name="file"/>
	DeSsc: <input type="text" name="desc"/>
	<input type="submit" value="Submit"/>
</form>

<br><br>

<a href="testResponseEntity">Test ResponseEntity</a>

   <!--
      关于国际化：
      1. 在页面上能够根据浏览器语言设置的情况对文本（不是内容），时间，数据进行本地化处理
      2. 可以在bean 中获取获取国际化资源文件locale 对应的消息
      3. 可以通过超链接切换 Locale,而不再依赖于浏览器的语言设置情况
      
      解决：
      1、使用JSTL的fmt 标签
      2、在bean 中注入ResourceBundleMessageSource 的示例，使用其对应的getMessage 方法即可
      3、配置 LocalResolver 和 LocalChangeInterceptor
    -->
<br><br>
<a href="i18n">I18N PAGE</a>

<br><br>
<a href="testExceptionHandlerResolverExceptionResolver?i=10">Test ExceptionHandlerResolverExceptionResolver</a>
</body>
</html>
