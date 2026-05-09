package ProyectoFinalING.Servicios;
import ProyectoFinalING.Persistencia.RepositorioPaciente;
import ProyectoFinalING.Modelo.Paciente;
public class ServicioPaciente {

    RepositorioPaciente repositorioPaciente;

    public ServicioPaciente(RepositorioPaciente repositorioPaciente2) {
        this.repositorioPaciente = repositorioPaciente2;
    }
    
  
        
    
    public String registrarPaciente( String nombre, String cedula, String telefono) {
        boolean resultado = repositorioPaciente.ExisteporDocumento(cedula);

        if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty()) {
            return "Error: Todos los campos son obligatorios.";
        }
        else if (resultado == true ) {
            return "El paciente con el documento " + cedula + " ya existe.";
        } else {
            Paciente paciente = new Paciente(nombre, cedula, telefono);
            repositorioPaciente.guardarPaciente(paciente);
            return "Paciente registrado exitosamente.";
        }
        
    }






}
