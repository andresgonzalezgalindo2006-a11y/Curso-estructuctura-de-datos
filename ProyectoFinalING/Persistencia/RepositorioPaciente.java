package ProyectoFinalING.Persistencia;

import java.util.ArrayList;
import java.util.List;
import ProyectoFinalING.Modelo.Paciente;
public class RepositorioPaciente {

    private List<Paciente> pacientes;

    public RepositorioPaciente() {
        this.pacientes = new ArrayList<>();
        
    }
        
        public boolean ExisteporDocumento(String documento) {
            for (Paciente paciente : pacientes) {
                if (paciente.getCedula().equals(documento)) {
                    return true;
                }
            }
            return false;
        }

       public void guardarPaciente(Paciente paciente) {
     
            pacientes.add(paciente);
       }
}
