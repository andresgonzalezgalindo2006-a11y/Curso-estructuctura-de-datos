package ProyectoFinalING.Servicios;

import ProyectoFinalING.Modelo.EstadoTurno;
import ProyectoFinalING.Modelo.Paciente;
import ProyectoFinalING.Modelo.PrioridadTurno;
import ProyectoFinalING.Modelo.Turno;
import ProyectoFinalING.Persistencia.RepositorioTurno;

import java.util.List;

/**
 * Servicio de negocio para la gestión de turnos y sala de espera.
 *
 * CORRECCIÓN PRINCIPAL: los imports de PrioridadTurno y EstadoTurno
 * apuntaban a ProyectoFinalING.Servicios.PrioridadTurno (clase vacía
 * generada por NetBeans) en lugar del enum real en ProyectoFinalING.Modelo.
 * Eso causaba los errores:
 *   - "cannot find symbol: variable NORMAL"
 *   - "cannot find symbol: variable URGENTE"
 *   - "incompatible types: Servicios.PrioridadTurno vs Modelo.PrioridadTurno"
 *
 * También se agregan validaciones completas para HU6–HU10.
 */
public class ServicioTurno {

    private final RepositorioTurno repositorioTurno;

    private final ServicioPaciente servicioPaciente;


    public ServicioTurno(
            RepositorioTurno repositorioTurno,
            ServicioPaciente servicioPaciente) {

        this.repositorioTurno  = repositorioTurno;
        this.servicioPaciente  = servicioPaciente;

    }


    // ── HU6: Asignar turno normal ─────────────────────────────────────────

    public String asignarTurno(String cedula) {
        return registrar(cedula, PrioridadTurno.NORMAL);
    }


    // ── HU10: Registrar urgencia ──────────────────────────────────────────

    public String registrarUrgencia(String cedula) {
        return registrar(cedula, PrioridadTurno.URGENTE);
    }


    // ── Lógica compartida de registro ────────────────────────────────────

    private String registrar(
            String cedula,
            PrioridadTurno prioridad) {

        if (cedula == null || cedula.isBlank()) {
            return "Error: la cédula no puede estar vacía.";
        }

        cedula = cedula.replaceAll("[^\\d]", "");

        // Validar existencia del paciente (integración con módulo Pacientes)
        Paciente paciente = servicioPaciente.buscarPaciente(cedula);

        if (paciente == null) {
            return "Error: el paciente con cédula "
                    + cedula + " no existe en el sistema.";
        }

        // Validar que no tenga turno activo duplicado
        if (repositorioTurno.tieneTurnoActivo(cedula)) {
            return "Error: el paciente "
                    + paciente.getNombre()
                    + " ya tiene un turno activo en la sala de espera.";
        }

        Turno turno = new Turno(paciente, prioridad);

        repositorioTurno.agregarTurno(turno);

        return "Turno N° " + turno.getNumeroTurno()
                + " asignado a " + paciente.getNombre()
                + " con prioridad " + prioridad + ".";

    }


    // ── HU8: Ver sala de espera ───────────────────────────────────────────

    public List<Turno> verSalaEspera() {
        return repositorioTurno.listar();
    }


    // ── HU9: Llamar siguiente paciente ────────────────────────────────────

    public String llamarSiguiente() {

        if (repositorioTurno.estaVacia()) {
            return "La sala de espera está vacía. No hay pacientes pendientes.";
        }

        Turno turno = repositorioTurno.siguienteTurno();

        turno.setEstado(EstadoTurno.EN_ATENCION);

        return "Llamando al siguiente paciente:"
                + turno.toString();

    }


    // ── HU7: Registrar abandono ───────────────────────────────────────────

    public String registrarAbandono(String cedula) {

        if (cedula == null || cedula.isBlank()) {
            return "Error: debe ingresar la cédula del paciente.";
        }

        cedula = cedula.replaceAll("[^\\d]", "");

        List<Turno> lista = repositorioTurno.listar();

        for (Turno turno : lista) {

            boolean mismaCedula = turno.getPaciente()
                    .getCedula()
                    .equals(cedula);

            boolean enEspera = turno.getEstado()
                    == EstadoTurno.EN_ESPERA;

            if (mismaCedula && enEspera) {
                turno.setEstado(EstadoTurno.ABANDONADO);
                return "El paciente "
                        + turno.getPaciente().getNombre()
                        + " ha sido registrado como ABANDONADO.";
            }

        }

        return "No se encontró un turno activo para la cédula: " + cedula;

    }

}
