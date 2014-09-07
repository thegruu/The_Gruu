package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Cidade;

public class CidadeDAO {

	private Connection con = Conexao.getConnection();
	
	public List<Cidade> buscarTodos() {
		
		String sql = "SELECT * FROM tb_cidades";
		
		List<Cidade> lista = new ArrayList<Cidade>();

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			ResultSet resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				Cidade cit = new Cidade();
				cit.setId_cidade(resultado.getInt("id_cidade"));
				cit.setNm_cidade(resultado.getString("nm_cidade"));
				cit.setEstado_id(resultado.getString("estado_id"));

				lista.add(cit);
			}

			preparedStatement.close();

			System.out.println("Lista de cidades");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	public Cidade buscaPorId(int id) {
		String sql = "SELECT * FROM tb_cidades WHERE ID=?";
		
		Cidade cit = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				cit = new Cidade();
				cit.setId_cidade(resultado.getInt("id_cidade"));
				cit.setNm_cidade(resultado.getString("nm_cidade"));
				cit.setEstado_id(resultado.getString("estado_id"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cit;

	}

	public Cidade buscaPorNome(String nome) {
		String sql = "SELECT * FROM tb_cidades WHERE NOME=?";
		Cidade cit = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, nome);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				cit = new Cidade();
				cit.setId_cidade(resultado.getInt("id_cidade"));
				cit.setNm_cidade(resultado.getString("nm_cidade"));
				cit.setEstado_id(resultado.getString("estado_id"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cit;

	}
}