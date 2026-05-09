package ProyectoFinalING.Vista;

import ProyectoFinalING.Controlador.*;
import java.util.Scanner;


public class InterfazRecepcionista {
    private Scanner scanner;
    ControladorGestionPaciente controladorGestionPaciente;

    public InterfazRecepcionista(ControladorGestionPaciente controladorGestionPaciente) {
        this.controladorGestionPaciente = controladorGestionPaciente;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuRecepcionista() {
        int opcion;
        do {

            System.out.println("=== Menú de Recepcionista ===");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Actualizar informacion de Paciente");
            System.out.println("3. Buscar paciente por documento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    MenuregistrarPaciente();
                    break;
                case 2:
                    MenuActualizarInformacionPaciente();
                    break;
                case 3:
                    // Lógica para buscar paciente por documento
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);

    }

    private void MenuregistrarPaciente() {
        System.out.println("=== Registro de Paciente ===");
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del paciente: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese el teléfono del paciente: ");
        String telefono = scanner.nextLine();

        String resultado = controladorGestionPaciente.registrarPaciente(nombre, cedula, telefono);
        System.out.println(resultado);
    }
    // Lógica para actualizar información de paciente
    private void MenuActualizarInformacionPaciente() {
        System.out.println("=== Actualización de Información de Paciente ===");
        System.out.print("Ingrese la cédula del paciente a actualizar: ");
        String cedula = scanner.nextLine();

            boolean existe = controladorGestionPaciente.servicioPaciente.existePaciente(cedula);

        if (existe) {
            System.out.println("Paciente encontrado. Ingrese la nueva información:");
            System.out.print("Ingrese el nuevo nombre del paciente: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo teléfono del paciente: ");
            String nuevoTelefono = scanner.nextLine();
        } else {
            System.out.println("Paciente no encontrado con la cédula proporcionada.");
            
        }
        
    }





}
