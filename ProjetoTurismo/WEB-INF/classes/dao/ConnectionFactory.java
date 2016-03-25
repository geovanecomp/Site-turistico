package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException{
		Connection conexao = null;
		DataSource ds = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/projeto_turismo");
			if(ds == null){
				throw new RuntimeException("DataSource não encontrado");
			}
			conexao = ds.getConnection();
		}
		catch(NamingException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		//System.out.println("Conectou da maneira nova!");
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_turismo","root","");
		System.out.println("Conectou da maneira velha!");*/
		return conexao;
	}
	
}
