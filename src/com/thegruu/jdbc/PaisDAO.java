package com.thegruu.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Pais;



public class PaisDAO {
	
	private Connection con = Conexao.getConnection();
	
	public List<Pais> buscarTodos(){
		//monta sql
		String sql = "SELECT * FROM tb_pais";
		//constroi preparestatment com sql
		List<Pais> lista = new ArrayList<Pais>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Pais pais = new Pais();
				pais.setId_pais(resultado.getInt("id_pais")); //valor da coluna id
				pais.setNm_pais(resultado.getString("nm_pais")); //valor da coluna nome
							
				lista.add(pais);
			}
			
			preparador.close();
			
			System.out.println("Lista de Países");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
//	public Tb_paises buscaPorId(Integer id){
//		String sql = "SELECT * FROM tb_paises WHERE ID=?";
//		Tb_paises tbp = null;
//		try {
//			PreparedStatement preparador = con.prepareStatement(sql);
//			preparador.setInt(1, id);
//			
//			ResultSet resultado = preparador.executeQuery();
//			
//			if(resultado.next()){
//				
//				tbp = new Tb_paises();
//				tbp.setId_pais(resultado.getInt("id")); //valor da coluna id
//				tbp.setNome_pais(resultado.getString("nome")); //valor da coluna nome
//				
//			}
//			public Tb_paises buscaPorNome(String nome){
//				String sql = "SELECT * FROM tb_paises WHERE NOME=?";
//				Tb_paises tbp = null;
//				try {
//					PreparedStatement preparador = con.prepareStatement(sql);
//					preparador.setString(1, nome);
//					
//					ResultSet resultado = preparador.executeQuery();
//					
//					if(resultado.next()){
//						
//						tbp = new Tb_paises();
//						tbp.setId_pais(resultado.getInt("id")); //valor da coluna id
//						tbp.setNome_pais(resultado.getString("nome")); //valor da coluna nome
//						
//					}
//			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return tbp;
//		
//	}
}
