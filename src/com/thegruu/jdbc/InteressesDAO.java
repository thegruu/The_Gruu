package com.thegruu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thegruu.entidades.Interesses;



public class InteressesDAO {
	//cria a conexao com o banco de dados
		private Connection con = Conexao.getConnection();
		
		//método que cadastra o usuário no banco de dados
		public void cadastrar(Interesses interesse){
			
			//string sql recebe o comando INSERT, com os campos da tabela e os valores como variáveis, que serão atribuídas pelo java
			String sql = "INSERT INTO tb_interesses (ds_interesse, ds_imagem_interesse, fl_ativo) "
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
				preparador.setString(1, interesse.getDsInteresse());
				preparador.setString(2, interesse.getDsImagenInteresse());
				preparador.setBoolean(3, interesse.getFlAtivos());
				
				
				//executa o preparador
				preparador.execute();
				
				//fecha o preparador
				preparador.close();
				
				System.out.println("Cadastrado com sucesso!");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		public List<Interesses> buscarTodos(){
			//monta sql
			String sql = "SELECT * FROM tb_interesses";
			//constroi preparestatment com sql
			List<Interesses> lista = new ArrayList<Interesses>();
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()){
					
					Interesses inte = new Interesses();
					
					inte.setIdInteresse(resultado.getInt("id_interesse"));
					inte.setDsInteresse(resultado.getString("ds_interesse"));
					inte.setDsImagenInteresse(resultado.getString("ds_interesse"));
					
					
					lista.add(inte);
				}
				
				preparador.close();
				
				System.out.println("Lista de Usuários");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return lista;
		}

}
