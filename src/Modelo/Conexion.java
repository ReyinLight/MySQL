package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private final String base = "sistema";
	private final String user = "root";
	private final String password = "0123";
	//private final String url = "jdbc:mysql://localhost:3306/" + base;
	private final String url = "jdbc:mysql://localhost:3306/sistema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	//Obtiene la conexion para guardarla y retornarla
	private Connection con = null;
	
	
	public Connection getConnection()
	{
		try
		{
			//Controlador para realizar la conecion
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = (Connection)DriverManager.getConnection(this.url, this.user, this.password);
			
			
		}
		catch(SQLException e)
		{
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	

}
