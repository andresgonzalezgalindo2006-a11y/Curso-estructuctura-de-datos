package ProyectoFinalING.Controlador;

import ProyectoFinalING.Modelo.Paciente;
import ProyectoFinalING.Servicios.ServicioPaciente;

public class ControladorGestionPaciente {

    private ServicioPaciente servicioPaciente;

    public ControladorGestionPaciente(
            ServicioPaciente servicioPaciente) {

        this.servicioPaciente = servicioPaciente;

    }

    public String registrarPaciente(
            String nombre,
            String cedula,
            String telefono) {

        return servicioPaciente
                .registrarPaciente(
                        nombre,
                        cedula,
                        telefono);

    }

    public boolean existePaciente(
            String cedula) {

        return servicioPaciente
                .existePaciente(
                        cedula);

    }

    public String actualizarPaciente(
            String cedula,
            String nombre,
            String telefono) {

        return servicioPaciente
                .actualizarPaciente(
                        cedula,
                        nombre,
                        telefono);

    }

    public Paciente buscarPaciente(
            String cedula) {

        return servicioPaciente
                .buscarPaciente(
                        cedula);

    }


    public String visualizarHistorialBasico(
        String cedula) {

    return servicioPaciente
            .visualizarHistorialBasico(
                    cedula
            );

}

}