package com.thegruu.jdbc.teste;

import java.util.List;

import com.thegruu.entidades.Pais;
import com.thegruu.jdbc.PaisDAO;

public class TestePaisDAO {

	public static void main(String[] args) {
		
		testBuscarTodos();

	}
	
	private static void testBuscarTodos(){
		PaisDAO paisDao = new PaisDAO();
		List<Pais> listaResultado = paisDao.buscarTodos();
		
		System.out.println("LISTAGEM DE PAISES");
		System.out.println("======================================================================================\n");

		for(Pais p : listaResultado){
			System.out.println(p.getId_pais() + " - " + p.getNm_pais());
		}
		
	}

}
