package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frameUsuario extends JFrame{
	
	JLabel lb_idUsuario, lb_usuario, lb_contrasenia, lb_persona;
	public JTextField tf_idUsuario, tf_usuario, tf_contrasenia, tf_persona;
	public JButton bt_guardar, bt_modificar, bt_eliminar, bt_limpiar, bt_buscar;
	
	
	public frameUsuario()
	{
		super("Usuario");
		setLayout(null);
		
		//Declaracion de labels
		lb_idUsuario = new JLabel("Id");
		lb_usuario = new JLabel("Usuario");
		lb_contrasenia = new JLabel("Contraseña");
		lb_persona = new JLabel("Persona");
		
		lb_idUsuario.setBounds(115, 10, 10, 20);
		lb_usuario.setBounds(80, 30, 45, 20);
		lb_contrasenia.setBounds(60, 50, 70, 20);
		lb_persona.setBounds(75, 70, 50, 20);
		
		add(lb_idUsuario);
		add(lb_usuario);
		add(lb_contrasenia);
		add(lb_persona);
		
		//Declaracion de TextFields
		tf_idUsuario = new JTextField("");
		tf_usuario = new JTextField("");
		tf_contrasenia = new JTextField("");
		tf_persona = new JTextField("");
		
		tf_idUsuario.setBounds(130, 10, 150, 20);
		tf_usuario.setBounds(130, 30, 150, 20);
		tf_contrasenia.setBounds(130, 50, 150, 20);
		tf_persona.setBounds(130, 70, 150, 20);
		
		add(tf_idUsuario);
		add(tf_usuario);
		add(tf_contrasenia);
		add(tf_persona);
		
		
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
