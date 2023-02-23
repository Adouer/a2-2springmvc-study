<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h2>这是主页</h2>
你好，<span>${username}</span>,<a href="${pageContext.request.contextPath}/user/goOut">注销</a>
  </body>
</html>
