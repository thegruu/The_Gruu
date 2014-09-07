package com.thegruu.jdbc.teste;

import java.util.List;

import com.thegruu.entidades.Interesses;
import com.thegruu.jdbc.InteressesDAO;

public class TesteInteressesDAO {

	public static void main(String[] args) {

		testBuscarTodos();

	}
	
	private static void testBuscarTodos(){
		
	InteressesDAO intDao = new InteressesDAO();
	List<Interesses> listaResultado = intDao.buscarTodos();
	
	System.out.println("LISTAGEM DE INTERESSES");
	System.out.println("======================================================================================\n");

	for(Interesses i : listaResultado){
		System.out.println(i.getIdInteresse() + " - " + i.getDsInteresse() + " - " + i.getDsImagenInteresse() + " - " + i.getFlAtivos());
	}
	

	
}

}
