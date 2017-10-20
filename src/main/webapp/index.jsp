<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>



springmvc上传文件
<form name="form1" action="/upload" method="post"  enctype="multipart/form-data">
    <input type="file" name="file" multiple="multiple" />
    <input type="submit" value="springmvc上传文件" />
</form>

<form name="form2" action="/downFile" method="get">
    <input type="submit" value="down文件" />
</form>
<br/><br/><br/>

<a href="test.html">git/</a>                                               17-Apr-2017 04:03                   -<br/>
<a href="jdk/">jdk/</a>                                               17-Apr-2017 03:59                   -<br/>
<a href="maven/">maven/</a>                                             17-Apr-2017 04:22                 -<br/>
<a href="mysql/">mysql/</a>

</body>
</html>
