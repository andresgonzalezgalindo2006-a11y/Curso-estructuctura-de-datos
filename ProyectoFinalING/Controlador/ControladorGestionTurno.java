package ProyectoFinalING.Controlador;

import ProyectoFinalING.Modelo.Turno;
import ProyectoFinalING.Servicios.ServicioTurno;

import java.util.List;

/**
 * Controlador de la capa de presentación para el módulo de Turnos.
 *
 * CORRECCIÓN: registrarAbandono ahora recibe la cédula del paciente
 * (antes no recibía parámetro y sacaba el primer turno arbitrariamente,
 * lo cual rompía la lógica de HU7).
 *
 * Responsabilidad: delegar a ServicioTurno. No contiene lógica de negocio.
 */
public class ControladorGestionTurno {

    private final ServicioTurno servicioTurno;


    public ControladorGestionTurno(ServicioTurno servicioTurno) {
        this.servicioTurno = servicioTurno;
    }


    // HU6
    public String asignarTurno(String cedula) {
        return servicioTurno.asignarTurno(cedula);
    }


    // HU10
    public String registrarUrgencia(String cedula) {
        return servicioTurno.registrarUrgencia(cedula);
    }


    // HU8
    public List<Turno> verSalaEspera() {
        return servicioTurno.verSalaEspera();
    }


    // HU9
    public String llamarSiguiente() {
        return servicioTurno.llamarSiguiente();
    }


    // HU7
    public String registrarAbandono(String cedula) {
        return servicioTurno.registrarAbandono(cedula);
    }

}
