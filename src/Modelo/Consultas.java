package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Consultas extends Conexion{
	
	
	public boolean selectPersonas(DefaultTableModel model)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "SELECT * FROM sistema.persona";
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			//se usa ps.executeQuery() para que guarde solo el res
			rs = ps.executeQuery();
			//en rs se guarda el res de la query
			
			
			String idPersona, nombre, apellido, fecha;
			
			while(rs.next())
			{
				idPersona = rs.getString("idPersona");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				fecha = rs.getString("fechaNacimiento");
				
				Object datos[]={idPersona, nombre, apellido, fecha};
				model.addRow(datos);
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
	
	public boolean selectUsuarios(DefaultTableModel model)
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		String sql = "SELECT * FROM sistema.usuario INNER JOIN sistema.persona WHERE sistema.usuario.idPersona = sistema.persona.idPersona";
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			//se usa ps.executeQuery() para que guarde solo el res
			rs = ps.executeQuery();
			//en rs se guarda el res de la query
			
			
			String idUsuario, usuario, contrasenia, idPersona, nombre, apellido, fecha;
			
			while(rs.next())
			{
				idUsuario = rs.getString("idUsuario");
				usuario = rs.getString("usuario");
				contrasenia = rs.getString("contraseña");
				idPersona = rs.getString("idPersona");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				fecha = rs.getString("fechaNacimiento");
				
				Object datos[]={idUsuario,usuario,contrasenia, idPersona, nombre, apellido, fecha};
				model.addRow(datos);
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
