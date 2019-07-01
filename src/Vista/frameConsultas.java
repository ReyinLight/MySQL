package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frameConsultas extends JFrame {
	
	public JButton bt_mostrarUsuarios, bt_mostrarPersonas;
	
	public DefaultTableModel modelPersonas;
	//String datosPersonas[][]={};
	public JTable t;
	
	public frameConsultas()
	{
		super("Consultas");
		setLayout(null);
		
		bt_mostrarPersonas = new JButton("Mostrar Personas");
		bt_mostrarUsuarios = new JButton("Mostrar Usuarios");
		
		bt_mostrarPersonas.setBounds(10,10,150,20);
		bt_mostrarUsuarios.setBounds(170,10,150,20);
		
		add(bt_mostrarPersonas);
		add(bt_mostrarUsuarios);
		
		//modelPersonas = new DefaultTableModel(datosPersonas,indicesPersonas);
		t = new JTable();
		
		t.setBounds(10,60,750,500);
		
		add(t);
		
		//codigo que cierra la ventana con el boton X
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we){
						System.exit(0);
					}
				});
		setSize(800,800);
		setVisible(true);
	}

}
