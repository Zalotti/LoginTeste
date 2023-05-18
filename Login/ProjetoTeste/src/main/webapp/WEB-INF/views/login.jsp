<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
 <form action="<%= request.getContextPath() %>/login" method="post">
    <fieldset>
    <legend>Login</legend><br>
    <label for="username">Usuário:</label><br>
    <input type="text" name="username" id="username" required><br>
    <label for="pass">Senha:</label><br>
    <input type="password" name="password" id="password" required pattern="[a-Za-Z\s]+$"><br>
    <input type="submit" value="Login" />
    <a href="register">Não possui login?</a>
</fieldset>
</form>
</body>
</html>