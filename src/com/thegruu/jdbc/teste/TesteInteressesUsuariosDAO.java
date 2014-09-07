package com.thegruu.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import com.thegruu.entidades.Interesses;
import com.thegruu.entidades.InteressesUsuarios;
import com.thegruu.entidades.Usuario;
import com.thegruu.jdbc.InteressesDAO;
import com.thegruu.jdbc.InteressesUsuariosDAO;
import com.thegruu.jdbc.UsuarioDAO;

public class TesteInteressesUsuariosDAO {

	public static void main(String[] args) {

		
		testCadastrar();
		testBuscarTodos();

	}
	
	private static void testBuscarTodos(){
		InteressesUsuariosDAO intUsuDao = new InteressesUsuariosDAO();
		List<InteressesUsuarios> listaResultado = intUsuDao.buscarTodos();
		
		System.out.println("LISTAGEM DE INTERESSES POR USUARIO");
		System.out.println("======================================================================================\n");

		for(InteressesUsuarios iu : listaResultado){
			System.out.println(iu.getIdInteresses() + " - " + iu.getIdUsuario());
		}
	}
	
	private static void testCadastrar() {
		
		Scanner k = new Scanner(System.in);
		
		System.out.println("Digite o usuario_id: ");
		String usuario_id = k.nextLine();
		System.out.println("Digite o interesse_id: ");
		String interesse_id = k.nextLine();
		System.out.println("Ativo? (true/false): ");
		boolean fl_ativo = k.nextBoolean();
		

		
		k.close();
		
		InteressesUsuarios intUsu = new InteressesUsuarios();
		intUsu.setIdUsuario(usuario_id);
		intUsu.setIdInteresses(interesse_id);
		intUsu.setFlAtivo(fl_ativo);

		
		InteressesUsuariosDAO intUsuDao = new InteressesUsuariosDAO();
		intUsuDao.cadastrar(intUsu);
	}
	
}


