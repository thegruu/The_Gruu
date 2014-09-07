<%@page import= "com.thegruu.entidades.Usuario" %>  
<%@page import= "java.util.List" %>  
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr bgcolor="#EAEAEA">
			<th>Id</th>
			<th>Nome</th>
			<th>Sobrenome</th>
			<th>Apelido</th>
			<th>Nascimento</th>
			<th>Sexo</th>
			<th>Cidade</th>
			<th>E-mail</th>
			<th>Senha</th>
			<th>Ação</th>
		</tr>
	

<%
List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");

for(Usuario usu : lista){
%>
<tr>	
	<td><%out.print(usu.getId()); %></td>
	<td><%= usu.getNome() %></td>
	<td><%= usu.getSobrenome() %></td>
	<td><%= usu.getApelido() %></td>
	<td><%= usu.getNascimento() %></td>
	<td><%= usu.getSexo() %></td>
	<td><%= usu.getCidade() %></td>
	<td><%= usu.getEmail() %></td>
	<td><%= usu.getSenha() %></td>
	<td><a  href="usucontroller.do?acao=alt&id=<%= usu.getId()%>">Alterar</a></td>
</tr>
	


<%
}
%>
</table>
</body>
</html>