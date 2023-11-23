package br.com.detran.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DAO {
	private static SqlMapClient sqlMapClient;
	private static Connection connection;
	public  static SqlMapClient conectar() {
		try {
			Reader reader = Resources.getResourceAsReader("ibatis-config.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sqlMapClient;
	}
	public static Connection conectarJDBC() throws SQLException {
		String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "123456";
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password );
			if(connection != null) {
				System.out.println("Conexão bem-sucedida!");
			}
		} catch (SQLException e) {
			System.out.println("Falha na conexão: " + e.getMessage());
			
		} 
		return connection;
	}
	

}
