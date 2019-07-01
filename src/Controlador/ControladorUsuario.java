package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.ConsultasPersona;
import Modelo.ConsultasUsuario;
import Modelo.Persona;
import Modelo.Usuario;
import Vista.framePersona;
import Vista.frameUsuario;

public class ControladorUsuario implements ActionListener {
	
	private Usuario u;
	private ConsultasUsuario cu;
	private frameUsuario frm;
	
	
	public ControladorUsuario(Usuario u, ConsultasUsuario cu, frameUsuario frm)
	{
		this.u = u;
		this.cu = cu;
		this.frm = frm;
		this.frm.bt_guardar.addActionListener(this);
		this.frm.bt_modificar.addActionListener(this);
		this.frm.bt_eliminar.addActionListener(this);
		this.frm.bt_limpiar.addActionListener(this);
		this.frm.bt_buscar.addActionListener(this);
	}
	
	
	public void iniciar()
	{
		frm.setTitle("Usuario");
		frm.setLocationRelativeTo(null);
		frm.setVisible(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("asdfasdfasdf");
		if(e.getSource() == frm.bt_guardar)
		{
			u.setUsuario(frm.tf_usuario.getText());
			u.setContrasenia(frm.tf_contrasenia.getText());
			u.setIdPersona(Integer.parseInt(frm.tf_persona.getText()));
			
			if(cu.registrar(u))
			{
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				limpiar();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Error al guardar");
		}
		
		if(e.getSource() == frm.bt_modificar)
		{
			u.setIdUsuario(Integer.parseInt(frm.tf_idUsuario.getText()));
			u.setUsuario(frm.tf_usuario.getText());
			u.setContrasenia(frm.tf_contrasenia.getText());
			u.setIdPersona(Integer.parseInt(frm.tf_persona.getText()));
			
			if(cu.modificar(u))
			{
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				limpiar();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Error al modificar");
		}
		
		if(e.getSource() == frm.bt_eliminar)
		{
			u.setIdUsuario(Integer.parseInt(frm.tf_idUsuario.getText()));
			
			if(cu.eliminar(u))
			{
				JOptionPane.showMessageDialog(null, "Registro Eliminado");
				limpiar();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
		}
		
		if(e.getSource() == frm.bt_buscar)
		{
			u.setIdUsuario(Integer.parseInt(frm.tf_idUsuario.getText()));
			
			if(cu.buscar(u))
			{
				frm.tf_idUsuario.setText(Integer.toString(u.getIdPersona()));
				frm.tf_usuario.setText(u.getUsuario());
				frm.tf_contrasenia.setText(u.getContrasenia());
				frm.tf_persona.setText(Integer.toString(u.getIdPersona()));
			}
				
			else
				JOptionPane.showMessageDialog(null, "No se encontro registro");
		}
		
		if(e.getSource() == frm.bt_limpiar)
			limpiar();
		
	}
	
	public void limpiar()
	{
		frm.tf_idUsuario.setText(null);
		frm.tf_usuario.setText(null);
		frm.tf_contrasenia.setText(null);
		frm.tf_persona.setText(null);
	}

}
