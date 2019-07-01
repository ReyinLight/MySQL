import java.awt.PageAttributes;

import javax.swing.table.DefaultTableModel;

import Controlador.ControladorConsultas;
import Controlador.ControladorPersona;
import Controlador.ControladorUsuario;
import Modelo.Consultas;
import Modelo.ConsultasPersona;
import Modelo.ConsultasUsuario;
import Modelo.Persona;
import Modelo.Usuario;
import Vista.frameConsultas;
import Vista.framePersona;
import Vista.frameUsuario;

public class Sistema {
	
	static public void main(String[] args)
	{
		Persona p = new Persona();
		ConsultasPersona cp = new ConsultasPersona();
		framePersona frmP = new framePersona();
		ControladorPersona ctrP = new ControladorPersona(p, cp, frmP);
		
		
		Usuario u = new Usuario();
		ConsultasUsuario cu = new ConsultasUsuario();
		frameUsuario frmU = new frameUsuario();
		ControladorUsuario ctrU = new ControladorUsuario(u, cu, frmU); 
		
		
		DefaultTableModel modelPersonas = null;
		Consultas c = new Consultas();
		frameConsultas frmC = new frameConsultas();
		ControladorConsultas ctrC = new ControladorConsultas(modelPersonas,c,frmC);
		
		
		ctrP.iniciar();
		ctrU.iniciar();
		ctrC.iniciar();
		
		
		frmC.setVisible(true);
		frmU.setVisible(true);
		frmP.setVisible(true);
		
		
	}
	

}
