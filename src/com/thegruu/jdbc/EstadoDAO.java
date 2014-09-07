package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Estado;

public class EstadoDAO {
	
	private Connection con = Conexao.getConnection();
	
	public List<Estado> buscarTodos(){
		//monta sql
		String sql = "SELECT * FROM tb_estados";
		//constroi preparestatment com sql
		List<Estado> lista = new ArrayList<Estado>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Estado est = new Estado();
				est.setId_estado(resultado.getInt("id_estado"));
				est.setNm_estado(resultado.getString("nm_estado")); 
				est.setPais_id(resultado.getString("pais_id"));
								
				lista.add(est);
			}
			
			preparador.close();
			
			System.out.println("Lista de estados");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
//	public tb_estados buscaPorId(Integer id){
//		String sql = "SELECT * FROM tb_estados WHERE ID=?";
//		tb_estados tbe = null;
//		try {
//			PreparedStatement preparador = con.prepareStatement(sql);
//			preparador.setInt(1, id);
//			
//			ResultSet resultado = preparador.executeQuery();
//			
//			if(resultado.next()){
//				
//				tbe = new tb_estados();
//				tbe.setId_estados(resultado.getInt("id")); //valor da coluna id
//				tbe.setNome_estados(resultado.getString("nome")); //valor da coluna nome
//				
//			}
//			public tb_estados buscaPorNome(String nome){
//				String sql = "SELECT * FROM tb_estados WHERE NOME=?";
//				tb_estados tbe = null;
//				try {
//					PreparedStatement preparador = con.prepareStatement(sql);
//					preparador.setString(1, nome);
//					
//					ResultSet resultado = preparador.executeQuery();
//					
//					if(resultado.next()){
//						
//						tbe = new tb_estados();
//						tbe.setId_estados(resultado.getInt("id")); //valor da coluna id
//						tbe.setNome_estados(resultado.getString("nome")); //valor da coluna nome
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
//		return tbe;
//		
//	}
}
