package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasUsuario extends Conexion {
	
	
	
	public boolean registrar(Usuario u)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "INSERT INTO sistema.usuario (usuario, contraseña, idPersona) VALUES (?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsuario());
			ps.setString(2, u.getContrasenia());
			ps.setInt(3, u.getIdPersona());
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
	
	
	public boolean modificar(Usuario u)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "UPDATE sistema.usuario SET usuario = ?, contraseña = ?, idPersona = ? WHERE idUsuario = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsuario());
			ps.setString(2, u.getContrasenia());
			ps.setInt(3, u.getIdPersona());
			ps.setInt(4, u.getIdUsuario());
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

	
	public boolean eliminar(Usuario u)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "DELETE FROM sistema.usuario where idUsuario = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getIdUsuario());
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
	
	public boolean buscar(Usuario u)
	{
		PreparedStatement ps = null;
		//en rs se guarda el resultado de la query
		ResultSet rs = null;	
		Connection con = getConnection();
		
		String sql = "SELECT * FROM sistema.usuario WHERE idUsuario = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getIdUsuario());
			//se usa ps.executeQuery() para que guarde solo el resultado
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				u.setIdUsuario(Integer.parseInt((rs.getString("idUsuario"))));
				u.setUsuario(rs.getString("usuario"));
				u.setContrasenia(rs.getString("contraseña"));
				u.setIdPersona(Integer.parseInt(rs.getString("idPersona")));
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
