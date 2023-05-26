<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.List"%>
<%@ page import= "model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações</title>
</head>
<body>

<h1>Login efetuado!</h1>

<table>

<% 
List <Employee> usuarios = (List) request.getAttribute("usuarios");
%>

    
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Usuário</th>
            <th>Senha</th>
            <th>Endereço</th>
            <th>Contato</th>
            
        </tr>
        
        <%
        for (Employee e : usuarios){ 
        %>

            <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getFirstName()%></td>
                <td><%=e.getLastName()%></td>
                <td><%=e.getUsername()%></td>
                <td><%=e.getPassword()%></td>
                <td><%=e.getAddress()%></td>
                <td><%=e.getContact()%></td>
            </tr>
            <%} %>
    </table>
</body>
</html>

</body>
</html>