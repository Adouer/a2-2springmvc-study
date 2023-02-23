<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/user/login">
      用户名:<input type="text" name="username"/>
      密码:<input type="text" name="password"/>
      <input type="submit" value="登录">
  </form>
  </body>
</html>
