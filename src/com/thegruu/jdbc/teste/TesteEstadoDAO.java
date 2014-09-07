package com.thegruu.jdbc.teste;

import java.util.List;

import com.thegruu.entidades.Estado;
import com.thegruu.jdbc.EstadoDAO;

public class TesteEstadoDAO {

	public static void main(String[] args) {

		testBuscarTodos();

	}
	
	private static void testBuscarTodos(){
		EstadoDAO estDao = new EstadoDAO();
		List<Estado> listaResultado = estDao.buscarTodos();
		
		System.out.println("LISTAGEM DE ESTADOS");
		System.out.println("======================================================================================\n");

		for(Estado e : listaResultado){
			System.out.println(e.getId_estado() + " - " + e.getNm_estado() + " - " + e.getPais_id());
		}
		
	}

}
