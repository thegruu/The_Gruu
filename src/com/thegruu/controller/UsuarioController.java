package com.thegruu.controller;


import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thegruu.entidades.Usuario;
import com.thegruu.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando método GET");
		
		String acao = request.getParameter("acao"); //recebe o parametro vindo da url
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if(acao !=null && acao.equals("alt")){
			
			String id = request.getParameter("id"); //recebe o parametro id que esta vindo da URL
			
			Usuario usuario = usuarioDAO.buscaPorId(Integer.parseInt(id)); //objeto usuario recebe os dados do usuario encontrado atraves do método buscaPorId
			
			request.setAttribute("usuario", usuario); //atribui o objeto usuario ao request
			
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp"); //encaminha para a tela os dados do objeto usuario
			saida.forward(request, response);
			
		}
		
		if(acao !=null && acao.equals("lis")){
			
			//1) obter a lista
			
			List<Usuario> lista = usuarioDAO.buscarTodos();
			
			//2) Atribuir no request a lista
			request.setAttribute("lista", lista);
			
			//3) Encaminhamento ao listausuarios.jsp
			RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
			saida.forward(request, response);
		}
	
//	String htmlSaida = "<html> <body>"
//			+ "<table border='1'>"
//					+ "<tr><td>Id</td><td>Nome</td><td>Sobrenome</td><td>Apelido</td><td>Nascimento</td><td>Sexo</td><td>Cidade</td><td>E-mail</td><td>Senha</td>"
//					+ "</tr>";
//	
//	for(Usuario usu : lista){
//		htmlSaida += "<tr>"
//				+ "<td>"+usu.getId()+"</td><td>"+usu.getNome()+"</td><td>"+usu.getSobrenome()+"</td><td>"+usu.getApelido()+"</td><td>"+usu.getNascimento()+"</td><td>"+usu.getSexo()+"</td><td>"+usu.getCidade()+"</td><td>"+usu.getEmail()+"</td><td>"+usu.getSenha()+"</td>"
//				+ "</tr>";
//	}
//	
//	htmlSaida += "</table>"
//			+ "</body>"
//			+ "</html>";
//	
//	
//	PrintWriter saida = response.getWriter();
//	saida.println(htmlSaida);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando método POST");
		
		//recebe dados da tela
		

			String id = request.getParameter("txtid");
			String nome = request.getParameter("txtnome");
			String sobrenome = request.getParameter("txtsobrenome");
			String apelido = request.getParameter("txtapelido");
			String nascimento = request.getParameter("dtnascimento");
			String sexo = request.getParameter("txtsexo");
			String cidade = request.getParameter("txtcidade");
			String email = request.getParameter("txtemail");
			String senha = request.getParameter("passenha");
			String foto = request.getParameter("txtfoto");
			
			//cria o objeto ususario e seta os valores vindo da tela
			Usuario usuario = new Usuario();

			if(id!=null && id!="" && id!="0"){
				
				usuario.setId(Integer.parseInt(id));
			}
			
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setApelido(apelido);
			usuario.setNascimento(nascimento);
			usuario.setSexo(sexo);
			usuario.setCidade(cidade);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setFoto(foto);
			
			//pede para o usuarioDAO cadastrar no banco de dados.
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);

			
			//saida no browser
			PrintWriter saida = response.getWriter();
			saida.print("Salvo com sucesso!");
		
	}

}
