package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class framePersona extends JFrame{
	
	JLabel lb_idPersona, lb_nombre, lb_apellido, lb_fecha;
	public JTextField tf_idPersona, tf_nombre, tf_apellido, tf_fecha;
	public JButton bt_guardar, bt_modificar, bt_eliminar, bt_limpiar, bt_buscar;
	
	
	public framePersona()
	{
		super("Persona");
		setLayout(null);
		
		//Declaracion de labels
		lb_idPersona = new JLabel("Id");
		lb_nombre = new JLabel("Nombre");
		lb_apellido = new JLabel("Apellido");
		lb_fecha = new JLabel("Fecha de nacimiento");
		
		lb_idPersona.setBounds(115, 10, 10, 20);
		lb_nombre.setBounds(80, 30, 45, 20);
		lb_apellido.setBounds(80, 50, 45, 20);
		lb_fecha.setBounds(10, 70, 120, 20);
		
		add(lb_idPersona);
		add(lb_nombre);
		add(lb_apellido);
		add(lb_fecha);
		
		//Declaracion de TextFields
		tf_idPersona = new JTextField("");
		tf_nombre = new JTextField("");
		tf_apellido = new JTextField("");
		tf_fecha = new JTextField("");
		
		tf_idPersona.setBounds(130, 10, 150, 20);
		tf_nombre.setBounds(130, 30, 150, 20);
		tf_apellido.setBounds(130, 50, 150, 20);
		tf_fecha.setBounds(130, 70, 150, 20);
		
		add(tf_idPersona);
		add(tf_nombre);
		add(tf_apellido);
		add(tf_fecha);
		
		
		//Declaracion de Buttons
		bt_guardar = new JButton("Guardar");
		bt_modificar = new JButton("Modificar");
		bt_eliminar = new JButton("Eliminar");
		bt_limpiar = new JButton("Limpiar");
		bt_buscar = new JButton("Buscar");
		
		bt_guardar.setBounds(10, 100, 90, 20);
		bt_modificar.setBounds(120, 100, 90, 20);
		bt_eliminar.setBounds(230, 100, 90, 20);
		bt_limpiar.setBounds(340, 100, 90, 20);
		bt_buscar.setBounds(340, 10, 90, 20);
		
		add(bt_guardar);
		add(bt_modificar);
		add(bt_eliminar);
		add(bt_limpiar);
		add(bt_buscar);
		
				
		
		//codigo que cierra la ventana con el boton X
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		setSize(500, 200);
		setVisible(true);
		
	}
	
	
	

}
