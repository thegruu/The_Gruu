package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Grupo;

public class GrupoDAO {
	
	private Connection conexao = Conexao.getConnection();
	
	public void cadastrar(Grupo grupo) {
	
		String insertSQL = "INSERT INTO tb_grupos (nm_grupo, id_administrador, interesse_id, dt_criacao, fl_ativo) VALUES (?,?,?,?,'S')";
		
		try {
			
			PreparedStatement preparador = conexao.prepareStatement(insertSQL);
			
			preparador.setString(1, grupo.getNmGrupo()); 
			preparador.setString(2, grupo.getIdAdministrador());
			preparador.setString(3, grupo.getIdInteresse());
			preparador.setString(4, grupo.getDtCriacao());
			
			preparador.execute();
			
			preparador.close();
			
			System.out.println("Grupo cadastrado com sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void alterar(Grupo grupo){
		
		String updateSQL = "UPDATE TB_GRUPOS NM_GRUPO=?, ID_ADMINISTRADOR=?, INTERESSE_ID=?, DT_CRIACAO=?, FL_ATIVO) VALUES (?,?,?,?,?)";
		
		try {
			
			PreparedStatement preparador = conexao.prepareStatement(updateSQL);
			
			preparador.setString(1, grupo.getNmGrupo()); 
			preparador.setString(2, grupo.getIdAdministrador());
			preparador.setString(3, grupo.getIdInteresse());
			preparador.setString(4, grupo.getDtCriacao());
			preparador.setString(5, grupo.getFlAtivo());
			
			preparador.execute();
			
			preparador.close();
			
			System.out.println("Grupo atualizado com sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Grupo> buscarTodos(){
		
		String selectSQL = "SELECT id_grupo, nm_grupo, id_administrador, interesse_id, dt_criacao, fl_ativo FROM tb_grupos";
		
		List<Grupo> lista = new ArrayList<Grupo>();
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(selectSQL);
			
			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){
				
				Grupo grupo = new Grupo();
				
				grupo.setIdGrupo(resultado.getInt("id_grupo")); 
				grupo.setNmGrupo(resultado.getString("nm_grupo")); 
				grupo.setIdAdministrador(resultado.getString("id_administrador")); 
				grupo.setIdInteresse(resultado.getString("interesse_id")); 
				grupo.setDtCriacao(resultado.getString("dt_criacao"));
				grupo.setFlAtivo(resultado.getString("fl_ativo"));
				
				lista.add(grupo);
			}
			
			preparador.close();
			
			System.out.println("Lista de Grupos");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}

}
