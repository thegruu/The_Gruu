package com.thegruu.jdbc.teste;

import java.util.List;

import com.thegruu.entidades.GrupoUsuario;
import com.thegruu.jdbc.GrupoUsuarioDAO;

public class TesteGrupoUsuarioDAO {

	public static void main(String[] args) {
		
		testBuscarTodos();

	}
	
	private static void testBuscarTodos(){
		GrupoUsuarioDAO gruUsuDao = new GrupoUsuarioDAO();
		List<GrupoUsuario> listaResultado = gruUsuDao.buscarTodos();
		
		System.out.println("LISTAGEM DE GRUPOS POR USUARIO");
		System.out.println("======================================================================================\n");

		for(GrupoUsuario gu : listaResultado){
			System.out.println(gu.getIdUsuario() + " - " + gu.getIdGrupo() + " - " + gu.getFlAtivo());
		}
		
	}

}
