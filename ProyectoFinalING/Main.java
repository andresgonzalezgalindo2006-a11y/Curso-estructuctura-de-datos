package ProyectoFinalING;

import ProyectoFinalING.Controlador.ControladorGestionPaciente;
import ProyectoFinalING.Controlador.ControladorGestionTurno;
import ProyectoFinalING.Persistencia.RepositorioPaciente;
import ProyectoFinalING.Persistencia.RepositorioTurno;
import ProyectoFinalING.Persistencia.RepositorioTurnoMemoria;
import ProyectoFinalING.Servicios.ServicioPaciente;
import ProyectoFinalING.Servicios.ServicioTurno;
import ProyectoFinalING.Vista.InterfazRecepcionista;

/**
 * Punto de entrada del sistema.
 *
 * CORRECCIÓN: RepositorioTurno es ahora una interfaz, por lo que
 * la variable se declara del tipo interfaz (RepositorioTurno) y se
 * instancia con la implementación concreta (RepositorioTurnoMemoria).
 * Esto aplica el principio de inversión de dependencias (SOLID-D).
 */
public class Main {

    public static void main(String[] args) {

        // ── Capa Persistencia ─────────────────────────────────────────
        RepositorioPaciente repositorioPaciente =
                new RepositorioPaciente();

        RepositorioTurno repositorioTurno =
                new RepositorioTurnoMemoria();

        // ── Capa Servicios ────────────────────────────────────────────
        ServicioPaciente servicioPaciente =
                new ServicioPaciente(repositorioPaciente);

        ServicioTurno servicioTurno =
                new ServicioTurno(repositorioTurno, servicioPaciente);

        // ── Capa Controlador ──────────────────────────────────────────
        ControladorGestionPaciente controladorPaciente =
                new ControladorGestionPaciente(servicioPaciente);

        ControladorGestionTurno controladorTurno =
                new ControladorGestionTurno(servicioTurno);

        // ── Capa Vista ────────────────────────────────────────────────
        InterfazRecepcionista interfaz =
                new InterfazRecepcionista(controladorPaciente, controladorTurno);

        interfaz.mostrarMenuRecepcionista();

    }

}
