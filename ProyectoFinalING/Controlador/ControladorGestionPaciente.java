package ProyectoFinalING.Controlador;
import ProyectoFinalING.Servicios.ServicioPaciente;

public class ControladorGestionPaciente {
 
    
    public ServicioPaciente servicioPaciente;

    public ControladorGestionPaciente(ServicioPaciente servicioPaciente2) {
        this.servicioPaciente = servicioPaciente2;
    }

    public String registrarPaciente(String nombre, String cedula, String telefono) {
        String resultado = servicioPaciente.registrarPaciente(nombre, cedula, telefono);
        return resultado;
       
    }
}