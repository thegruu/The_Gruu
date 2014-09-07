package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.InteressesUsuarios;

public class InteressesUsuariosDAO {

	//cria a conexao com o banco de dados
	private Connection con = Conexao.getConnection();
	
	//método que cadastra o usuário no banco de dados
	public void cadastrar(InteressesUsuarios intUsu){
		
		//string sql recebe o comando INSERT, com os campos da tabela e os valores como variáveis, que serão atribuídas pelo java
		String sql = "INSERT INTO tb_interesses_usuarios (usuario_id, interesse_id, fl_Ativo) "
				+ "values (?, ?, ?)";
		
		//constroi preparestatment com sql
		
		/*
		 * try/catch para tratamento de eventuais erros de inserção no banco
		 */
		try {
			//método prepareStatement de con recebe todos os parametros da busca sql e atibui-os à variável preparador
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//método setString de preparador "seta" nas variáveis ? do código INSERT sql com os dados obtidos pelos metodos GET 
			//do objeto usuario recebido como parâmetro no método cadastrar
			preparador.setString(1, intUsu.getIdUsuario());
			preparador.setString(2, intUsu.getIdInteresses());
			preparador.setBoolean(3, intUsu.isFlAtivo());
			
			
			//executa o preparador
			preparador.execute();
			
			//fecha o preparador
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public List<InteressesUsuarios> buscarTodos(){
		//monta sql
		String sql = "SELECT * FROM tb_interesses_usuarios";
		//constroi preparestatment com sql
		List<InteressesUsuarios> lista = new ArrayList<InteressesUsuarios>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				InteressesUsuarios intUsu = new InteressesUsuarios();
				
				intUsu.setIdUsuario(resultado.getString("usuario_id")); //valor da coluna id
				intUsu.setIdInteresses(resultado.getString("interesse_id")); //valor da coluna nome
				intUsu.setFlAtivo(resultado.getBoolean("fl_ativo")); //valor da coluna login
				
				
				lista.add(intUsu);
			}
			
			preparador.close();
			
			System.out.println("Lista de Usuários");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}


}

