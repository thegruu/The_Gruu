package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.GrupoUsuario;

public class GrupoUsuarioDAO {
	
	private Connection conexao = Conexao.getConnection();
	
	public void cadastrar(GrupoUsuario grupoUsuario){
	
		String insertSQL = "INSERT INTO TB_GRUPOS_USUARIOS (grupo_id, usuario_id, fl_ativo) VALUES (?, ?, ?)";
		
		try {
			
			PreparedStatement preparador = conexao.prepareStatement(insertSQL);

			preparador.setInt(1, grupoUsuario.getIdGrupo());
			preparador.setInt(2, grupoUsuario.getIdUsuario());
			preparador.setString(3, grupoUsuario.getFlAtivo());
			
			preparador.execute();
			
			preparador.close();
			
			System.out.println("GrupoUsuario cadastrado com sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void alterar(GrupoUsuario grupoUsuario){
		
		String updateSQL = "UPDATE TB_GRUPOS_USUARIOS SET FL_ATIVO=? WHERE GRUPO_ID=? AND USUARIO_ID=?";
		
		try {
			
			PreparedStatement preparador = conexao.prepareStatement(updateSQL);
			
			preparador.setString(1, grupoUsuario.getFlAtivo());
			preparador.setInt(2, grupoUsuario.getIdGrupo());
			preparador.setInt(3, grupoUsuario.getIdUsuario());
			
			preparador.execute();
			
			preparador.close();
			
			System.out.println("GrupoUsuario atualizado com sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<GrupoUsuario> buscarTodos(){
		
		String selectSQL = "SELECT grupo_id, usuario_id, FL_ATIVO FROM TB_GRUPOS_USUARIOS";
		
		List<GrupoUsuario> lista = new ArrayList<GrupoUsuario>();
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(selectSQL);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				GrupoUsuario grupoUsuario = new GrupoUsuario();
				
				grupoUsuario.setIdGrupo(resultado.getInt("grupo_id")); 
				grupoUsuario.setIdUsuario(resultado.getInt("usuario_id")); 
				grupoUsuario.setFlAtivo(resultado.getString("FL_ATIVO"));
				
				lista.add(grupoUsuario);
			}
			
			preparador.close();
			
			System.out.println("Lista de GruposUsuarios");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}

}
