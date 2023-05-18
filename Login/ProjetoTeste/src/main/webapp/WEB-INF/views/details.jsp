<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <td>${usuario.id}</td>
                <td>${usuario.fistname}</td>
                <td>${usuario.lastname}</td>
                <td>${usuario.username}</td>
                <td>${usuario.password}</td>
                <td>${usuario.address}</td>
                <td>${usuario.contact}</td>
            </tr>
    </table>
</body>
</html>

</body>
</html>