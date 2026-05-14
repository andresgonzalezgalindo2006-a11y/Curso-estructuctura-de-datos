package ProyectoFinalING.Persistencia;

import java.util.HashMap;
import java.util.Map;

import ProyectoFinalING.Modelo.Paciente;

public class RepositorioPaciente {

    private Map<String, Paciente> pacientes;

    public RepositorioPaciente() {

        this.pacientes = new HashMap<>();

    }

    // Validar existencia
    public boolean ExisteporDocumento(String documento) {

        return pacientes.containsKey(documento);

    }

    // Guardar
    public void guardarPaciente(Paciente paciente) {

        pacientes.put(
                paciente.getCedula(),
                paciente);

    }

    // Buscar
    public Paciente buscarPorCedula(String cedula) {

        return pacientes.get(cedula);

    }

    // Actualizar
    public boolean actualizarPaciente(String cedula,
            String nuevoNombre,
            String nuevoTelefono) {

        Paciente paciente = pacientes.get(cedula);

        if (paciente == null) {

            return false;

        }

        paciente.setNombre(nuevoNombre);
        paciente.setTelefono(nuevoTelefono);

        return true;
    }

}