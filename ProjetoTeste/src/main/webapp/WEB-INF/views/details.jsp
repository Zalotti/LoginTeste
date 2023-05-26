<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações</title>
</head>
<body>

<h1>Login efetuado!</h1>

<table>

    
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Usuário</th>
            <th>Senha</th>
            <th>Endereço</th>
            <th>Contato</th>
            
        </tr>

            <tr>
                <td>${usuarios.id}</td>
                <td>${usuarios.fistname}</td>
                <td>${usuarios.lastname}</td>
                <td>${usuarios.username}</td>
                <td>${usuarios.password}</td>
                <td>${usuarios.address}</td>
                <td>${usuarios.contact}</td>
            </tr>
    </table>
</body>
</html>

</body>
</html>