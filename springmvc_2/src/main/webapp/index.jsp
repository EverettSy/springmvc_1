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
</body>
</html>
