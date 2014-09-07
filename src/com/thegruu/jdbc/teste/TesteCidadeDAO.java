package com.thegruu.jdbc.teste;

import java.util.List;

import com.thegruu.entidades.Cidade;
import com.thegruu.jdbc.CidadeDAO;

public class TesteCidadeDAO {

	public static void main(String[] args) {
		
		testBuscarTodos();	

	}
	
	private static void testBuscarTodos(){
		CidadeDAO citDao = new CidadeDAO();
		List<Cidade> listaResultado = citDao.buscarTodos();
		
		System.out.println("LISTAGEM DE CIDADES");
		System.out.println("======================================================================================\n");

		for(Cidade c : listaResultado){
			System.out.println(c.getId_cidade() + " - " + c.getNm_cidade() + " - " + c.getEstado_id());
		}
		
	}

}
