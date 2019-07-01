package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPersona extends Conexion{
	
	public boolean registrar(Persona pe)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		//String sql = "INSERT INTO sistema.Persona (nombre, apellido, fechaNacimiento) VALUES ('" + pe.getNombre() + "', '" + pe.getApellido()+ "', '"+pe.getfechaNacimiento()+"')";
		String sql = "INSERT INTO sistema.Persona (nombre, apellido, fechaNacimiento) VALUES (?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pe.getNombre());
			ps.setString(2, pe.getApellido());
			ps.setString(3, pe.getfechaNacimiento());
			ps.execute();
			
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.err.println(e2);
			}
		}
				
	}
	
	
	public boolean modificar(Persona pe)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "UPDATE sistema.Persona SET nombre = ?, apellido = ?, fechaNacimiento = ? WHERE idPersona = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pe.getNombre());
			ps.setString(2, pe.getApellido());
			ps.setString(3, pe.getfechaNacimiento());
			ps.setInt(4, pe.getIdPersona());
			ps.execute();
			
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.err.println(e2);
			}
		}
				
	}

	
	public boolean eliminar(Persona pe)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "DELETE FROM sistema.persona where idPersona = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pe.getIdPersona());
			ps.execute();
			
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.err.println(e2);
			}
		}
	}
	
	public boolean buscar(Persona pe)
	{
		PreparedStatement ps = null;
		//en rs se guarda el resultado de la query
		ResultSet rs = null;
		Connection con = getConnection();
		
		String sql = "SELECT * FROM sistema.persona WHERE idPersona = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pe.getIdPersona());
			//se usa ps.executeQuery() para que guarde solo el resultado
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				pe.setIdPersona(Integer.parseInt((rs.getString("idPersona"))));
				pe.setNombre(rs.getString("nombre"));
				pe.setApellido(rs.getString("apellido"));
				pe.setfechaNacimiento(rs.getString("fechaNacimiento"));
			}
			
			return true;
			
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.err.println(e2);
			}
		}
	}
}
