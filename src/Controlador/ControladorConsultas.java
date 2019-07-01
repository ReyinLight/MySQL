package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Consultas;
import Modelo.ConsultasPersona;
import Modelo.Persona;
import Vista.frameConsultas;
import Vista.framePersona;

public class ControladorConsultas implements ActionListener {
	
	private DefaultTableModel model;
	private Consultas c;
	private frameConsultas frm;
	
	public ControladorConsultas(DefaultTableModel model, Consultas c, frameConsultas frmC)
	{
		this.model = model;
		this.c = c;
		frm = frmC;
		
		this.frm.bt_mostrarPersonas.addActionListener(this);
		this.frm.bt_mostrarUsuarios.addActionListener(this);
		
	}
	
	public void iniciar()
	{
		frm.setTitle("Consultas");
		frm.setLocationRelativeTo(null);
		frm.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frm.bt_mostrarPersonas)
		{
			//Instancia de model
			String indicesPersonas[] = {"idPersona", "Nombre", "Apellido", "Fecha de Nacimiento"};
			String data[][] = {};
			model = new DefaultTableModel(data, indicesPersonas);
			
			if(c.selectPersonas(model))
			{
				frm.t.setModel(model);		
			}
				
			else
				JOptionPane.showMessageDialog(null, "No se encontro registro");
		}
		
		if(e.getSource() == frm.bt_mostrarUsuarios)
		{
			//Instancia de model
			String indicesUsuarios[] = {"idUsuario","usuario","contraseña","idPersona", "Nombre", "Apellido", "Fecha de Nacimiento"};
			String data[][] = {};
			model = new DefaultTableModel(data, indicesUsuarios);
			
			if(c.selectUsuarios(model))
			{
				frm.t.setModel(model);		
			}
				
			else
				JOptionPane.showMessageDialog(null, "No se encontro registro");
		}
	}
}
