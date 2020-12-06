package ec.ups.edu.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ContextJDBC {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/jee?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	private static ContextJDBC jdbc = null;
	private Statement statement = null;
	
	public ContextJDBC() {
		this.connect();
	}
	
	protected static ContextJDBC getJDBC(){
		if(jdbc==null) jdbc=new ContextJDBC();
		return jdbc;
	}
	
	private void connect(){
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			this.statement = connection.createStatement();
		}catch(ClassNotFoundException e){
			System.out.println(">>>WARNING (JDBC:connect)...problemas con el driver");
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con la BD");
		}
	}
	
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		}catch(SQLException e) {
			System.out.println(">>>Warning (JDBC:query): ---"+sql+"---"+e);
		}
		return null;
	}
	
	public boolean update (String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBC:query): ---actualizacion"+sql+"---"+e);
		}
		return false;
	}
	
}
