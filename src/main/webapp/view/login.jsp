<%--
  Created by IntelliJ IDEA.
  User: Fantom_X_
  Date: 28.05.2023
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form method="post" action="login.jsp">


    <%--<%
        String s = (String) request.getAttribute("error");
        if(s!=null){
            out.print("<h2>" + s + "</h2>");
        }
    %>--%>

    <input type="email" required placeholder="Email" name="email"><br>
    <input type="password" required placeholder="Пароль" name="password"><br><br>
    <input class="button" type="submit" value="Войти">
    <h2><a href="reg.jsp" methods="get">Вы у нас впервые? Создайте аккаунт</a></h2>



</form>

</body>
</html>
