package ProyectoFinalING.Vista;

import ProyectoFinalING.Controlador.ControladorGestionPaciente;
import ProyectoFinalING.Controlador.ControladorGestionTurno;
import ProyectoFinalING.Modelo.Paciente;
import ProyectoFinalING.Modelo.Turno;

import java.util.List;
import java.util.Scanner;

/**
 * Capa de presentación: menú de consola para Recepcionista y Médico.
 *
 * CORRECCIÓN PRINCIPAL: el menú original solo tenía las opciones de
 * Pacientes (HU1–HU5). Se agregan todas las opciones de Turnos (HU6–HU10).
 *
 * También se elimina el constructor vacío que podía provocar
 * NullPointerException al usarse sin inicializar las dependencias.
 */
public class InterfazRecepcionista {

    private final Scanner scanner;
    private final ControladorGestionPaciente controladorGestionPaciente;
    private final ControladorGestionTurno controladorGestionTurno;


    public InterfazRecepcionista(
            ControladorGestionPaciente controladorGestionPaciente,
            ControladorGestionTurno controladorGestionTurno) {

        this.controladorGestionPaciente = controladorGestionPaciente;
        this.controladorGestionTurno    = controladorGestionTurno;
        this.scanner                    = new Scanner(System.in);

    }


    // ════════════════════════════════════════════════════════════════════
    //  MENÚ PRINCIPAL
    // ════════════════════════════════════════════════════════════════════

    public void mostrarMenuRecepcionista() {

        int opcion;

        do {

            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║   SISTEMA DE GESTIÓN - CLÍNICA       ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  ── MÓDULO PACIENTES ──               ║");
            System.out.println("║  1. Registrar paciente                ║");
            System.out.println("║  2. Actualizar información paciente   ║");
            System.out.println("║  3. Buscar paciente por documento     ║");
            System.out.println("║  4. Historial básico del paciente     ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  ── MÓDULO TURNOS (HU6–HU10) ──       ║");
            System.out.println("║  5. Asignar turno (HU6)               ║");
            System.out.println("║  6. Registrar abandono sala (HU7)     ║");
            System.out.println("║  7. Ver sala de espera (HU8)          ║");
            System.out.println("║  8. Llamar siguiente paciente (HU9)   ║");
            System.out.println("║  9. Registrar urgencia (HU10)         ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  0. Salir                             ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {

                case 1 -> menuRegistrarPaciente();
                case 2 -> menuActualizarPaciente();
                case 3 -> menuBuscarPaciente();
                case 4 -> menuHistorialBasico();
                case 5 -> menuAsignarTurno();
                case 6 -> menuRegistrarAbandono();
                case 7 -> menuVerSalaEspera();
                case 8 -> menuLlamarSiguiente();
                case 9 -> menuRegistrarUrgencia();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }


    // ════════════════════════════════════════════════════════════════════
    //  MÓDULO PACIENTES
    // ════════════════════════════════════════════════════════════════════

    private void menuRegistrarPaciente() {

        System.out.println("\n=== Registro de Paciente ===");
        System.out.print("Nombre    : ");
        String nombre   = scanner.nextLine();
        System.out.print("Cédula    : ");
        String cedula   = scanner.nextLine();
        System.out.print("Teléfono  : ");
        String telefono = scanner.nextLine();

        String resultado = controladorGestionPaciente
                .registrarPaciente(nombre, cedula, telefono);

        System.out.println(resultado);

    }


    private void menuActualizarPaciente() {

        System.out.println("\n=== Actualización de Información ===");
        System.out.print("Cédula : ");
        String cedula = scanner.nextLine();

        if (!controladorGestionPaciente.existePaciente(cedula)) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre    : ");
        String nuevoNombre   = scanner.nextLine();
        System.out.print("Nuevo teléfono  : ");
        String nuevoTelefono = scanner.nextLine();

        String resultado = controladorGestionPaciente
                .actualizarPaciente(cedula, nuevoNombre, nuevoTelefono);

        System.out.println(resultado);

    }


    private void menuBuscarPaciente() {

        System.out.println("\n=== Buscar Paciente ===");
        System.out.print("Cédula : ");
        String cedula   = scanner.nextLine();

        Paciente paciente = controladorGestionPaciente.buscarPaciente(cedula);

        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.println(paciente);

    }


    private void menuHistorialBasico() {

        System.out.println("\n=== Historial del Paciente ===");
        System.out.print("Cédula : ");
        String cedula = scanner.nextLine();

        String historial = controladorGestionPaciente
                .visualizarHistorialBasico(cedula);

        System.out.println(historial);

    }


    // ════════════════════════════════════════════════════════════════════
    //  MÓDULO TURNOS  (HU6–HU10)
    // ════════════════════════════════════════════════════════════════════

    /** HU6 – Asignar turno normal a un paciente existente */
    private void menuAsignarTurno() {

        System.out.println("\n=== Asignar Turno (HU6) ===");
        System.out.print("Cédula del paciente : ");
        String cedula = scanner.nextLine();

        String resultado = controladorGestionTurno.asignarTurno(cedula);

        System.out.println(resultado);

    }


    /** HU7 – Registrar que un paciente abandona la sala de espera */
    private void menuRegistrarAbandono() {

        System.out.println("\n=== Registrar Abandono (HU7) ===");
        System.out.print("Cédula del paciente que abandona : ");
        String cedula = scanner.nextLine();

        String resultado = controladorGestionTurno.registrarAbandono(cedula);

        System.out.println(resultado);

    }


    /** HU8 – Visualizar lista de pacientes en espera (médico) */
    private void menuVerSalaEspera() {

        System.out.println("\n=== Sala de Espera (HU8) ===");

        List<Turno> lista = controladorGestionTurno.verSalaEspera();

        if (lista.isEmpty()) {
            System.out.println("La sala de espera está vacía.");
            return;
        }

        System.out.println("Pacientes en espera (orden de atención):");
        System.out.println("─".repeat(40));

        int posicion = 1;
        for (Turno turno : lista) {
            System.out.println(posicion++ + ". " + turno);
            System.out.println("─".repeat(40));
        }

    }


    /** HU9 – Llamar al siguiente paciente de la lista */
    private void menuLlamarSiguiente() {

        System.out.println("\n=== Llamar Siguiente Paciente (HU9) ===");

        String resultado = controladorGestionTurno.llamarSiguiente();

        System.out.println(resultado);

    }


    /** HU10 – Registrar paciente urgente (prioridad alta) */
    private void menuRegistrarUrgencia() {

        System.out.println("\n=== Registrar Urgencia (HU10) ===");
        System.out.print("Cédula del paciente urgente : ");
        String cedula = scanner.nextLine();

        String resultado = controladorGestionTurno.registrarUrgencia(cedula);

        System.out.println(resultado);

    }


    // ════════════════════════════════════════════════════════════════════
    //  UTILIDADES
    // ════════════════════════════════════════════════════════════════════

    /**
     * Lee un entero de forma segura.
     * Si el usuario ingresa texto, evita que el programa explote
     * con InputMismatchException.
     */
    private int leerEntero() {

        try {
            int valor = Integer.parseInt(scanner.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            return -1;
        }

    }

}
