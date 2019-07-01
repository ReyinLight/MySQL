package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.ConsultasPersona;
import Modelo.Persona;
import Vista.framePersona;

public class ControladorPersona implements ActionListener {
	
	private Persona p;
	private ConsultasPersona cp;
	private framePersona frm;
	
	
	public ControladorPersona(Persona p, ConsultasPersona cp, framePersona frm)
	{
		this.p = p;
		this.cp = cp;
		this.frm = frm;
		this.frm.bt_guardar.addActionListener(this);
		this.frm.bt_modificar.addActionListener(this);
		this.frm.bt_eliminar.addActionListener(this);
		this.frm.bt_limpiar.addActionListener(this);
		this.frm.bt_buscar.addActionListener(this);
	}
	
	
	public void iniciar()
	{
		frm.setTitle("Persona");
		frm.setLocationRelativeTo(null);
		frm.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frm.bt_guardar)
		{
			p.setNombre(frm.tf_nombre.getText());
			p.setApellido(frm.tf_apellido.getText());
			p.setfechaNacimiento(frm.tf_fecha.getText());
			
			if(cp.registrar(p))
			{
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				limpiar();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Error al guardar");
		}
		
		if(e.getSource() == frm.bt_modificar)
		{
			p.setIdPersona(Integer.parseInt(frm.tf_idPersona.getText()));
			p.setNombre(frm.tf_nombre.getText());
			p.setApellido(frm.tf_apellido.getText());
			p.setfechaNacimiento(frm.tf_fecha.getText());
			
			if(cp.modificar(p))
			{
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				limpiar();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Error al modificar");
		}
		
		if(e.getSource() == frm.bt_eliminar)
		{
			p.setIdPersona(Integer.parseInt(frm.tf_idPersona.getText()));
			
			if(cp.eliminar(p))
			{
				JOptionPane.showMessageDialog(null, "Registro Eliminado");
				limpiar();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
		}
		
		if(e.getSource() == frm.bt_buscar)
		{
			p.setIdPersona(Integer.parseInt(frm.tf_idPersona.getText()));
			
			if(cp.buscar(p))
			{
				frm.tf_idPersona.setText(Integer.toString(p.getIdPersona()));
				frm.tf_nombre.setText(p.getNombre());
				frm.tf_apellido.setText(p.getApellido());
				frm.tf_fecha.setText(p.getfechaNacimiento());
			}
				
			else
				JOptionPane.showMessageDialog(null, "No se encontro registro");
		}
		
		if(e.getSource() == frm.bt_limpiar)
			limpiar();
	}
	
	
	public void limpiar()
	{
		frm.tf_idPersona.setText(null);
		frm.tf_nombre.setText(null);
		frm.tf_apellido.setText(null);
		frm.tf_fecha.setText(null);
	}
	
	

}
