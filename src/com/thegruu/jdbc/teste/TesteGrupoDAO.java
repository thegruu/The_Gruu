package com.thegruu.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import com.thegruu.entidades.Grupo;
import com.thegruu.entidades.Usuario;
import com.thegruu.jdbc.GrupoDAO;
import com.thegruu.jdbc.UsuarioDAO;

public class TesteGrupoDAO {

	public static void main(String[] args) {
		
		
		testCadastrar();
		
		testBuscarTodos();

	}
	
	private static void testBuscarTodos(){
		GrupoDAO gruDao = new GrupoDAO();
		List<Grupo> listaResultado = gruDao.buscarTodos();
		
		System.out.println("LISTAGEM DE GRUPOS");
		System.out.println("======================================================================================\n");

		for(Grupo g : listaResultado){
			System.out.println(g.getIdGrupo() + " - " + g.getNmGrupo() + " - " + g.getFlAtivo() + " - " + g.getDtCriacao() + " - " + g.getIdAdministrador() + " - " + g.getIdInteresse());
		}
		
	}
	
	private static void testCadastrar() {
		
		Scanner k = new Scanner(System.in);
		
		System.out.println("Digite o nome: ");
		String nome = k.nextLine();
		
		System.out.println("Digite o interesse_id: ");
		String interesse_id = k.nextLine();
		
		System.out.println("Digite o id_administrador: ");
		String id_administrador = k.nextLine();
		
		System.out.println("Ativo? (S/N): ");
		String ativo = k.nextLine();

		
		k.close();
		
		Grupo grupo = new Grupo();
		
		grupo.setNmGrupo(nome);
		grupo.setIdInteresse(interesse_id);
		grupo.setIdAdministrador(id_administrador);
		grupo.setFlAtivo(ativo);

		
		GrupoDAO grupoDao = new GrupoDAO();
		grupoDao.cadastrar(grupo);
	}

}
