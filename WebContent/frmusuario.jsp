<!DOCTYPE html>
<%@page import="com.thegruu.entidades.Usuario" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usu�rio</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"><style type="text/css">

</style></head>
<body>

		<%
	
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	
	%>
	
	
	<form action="usucontroller.do" method="post">
		<p>&nbsp;</p>
		<table width="330" border="0" align="center" cellspacing="4" bgcolor="#FFFFFF">
		  <tr>
		    <td colspan="2"><div align="center">CADASTRO DE USU&Aacute;RIO</div>
		    <input name="txtid" type="hidden" id="txtid" value="<%=usuario.getId()%>"></td>
	      </tr>
		  <tr>
		    <td width="75">Nome:</td>
		    <td width="239"><input type="text" name="txtnome" value="<%=usuario.getNome()%>" size="20"/>
	        </td>
	      </tr>
		  <tr>
		    <td>Sobrenome:</td>
		    <td><input type="text" name="txtsobrenome" value="<%=usuario.getSobrenome()%>" size="20"/></td>
	      </tr>
		  <tr>
		    <td>Apelido:</td>
		    <td><input type="text" name="txtapelido" value="<%=usuario.getApelido()%>" size="20"/></td>
	      </tr>
		  <tr>
		    <td>Nascimento:</td>
		    <td><input type="date" name="dtnascimento" value="<%=usuario.getNascimento()%>" size="20"/></td>
	      </tr>
		  <tr>
		    <td colspan="2"><label>
		      <input name="txtsexo" type="radio" id="masc" value="M" checked />
		      Masculino</label>
              <label>
                <input name="txtsexo" type="radio" id="fem" value="F" />
            Feminino</label></td>
	      </tr>
		  <tr>
		    <td>Cidade: </td>
		    <td><label>
		      <select name="txtcidade" id="txtcidade">
		        <option value="<%=usuario.getCidade()%>"><%=usuario.getCidade()%></option>
		        <option value="1">Florian&oacute;polis</option>
		        <option value="2">S&atilde;o Jos&eacute;</option>
		        <option value="3">Joinville</option>
	          </select>
	        </label></td>
	      </tr>
		  <tr>
		    <td>E-mail:</td>
		    <td><input type="text" name="txtemail" value="<%=usuario.getEmail()%>" size="20"/></td>
	      </tr>
		  <tr>
		    <td><label>Senha: </label></td>
		    <td><input type="password" name="passenha" value="<%=usuario.getSenha()%>" size="20"/></td>
	      </tr>
		  <tr>
		    <td>Foto:</td>
		    <td><input type="text" name="txtfoto" value="<%=usuario.getFoto()%>" size="20"/></td>
	      </tr>
		  <tr>
		    <td colspan="2"><input type="submit" value="Salvar"/></td>
	      </tr>
	  </table>
		<p>&nbsp;</p>
	</form>

</body>
</html>