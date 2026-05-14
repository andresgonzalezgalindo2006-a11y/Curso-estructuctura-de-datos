package src.principal;

import java.util.Scanner;

public class Menu {
     
    private static Scanner scanner = new Scanner(System.in);
    public static void mostrarMenu() {
        int opcion = 0;

        do {

            System.out.println();
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║                     MENÚ PRINCIPAL                       ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║  ── GESTIÓN DE ESTUDIANTES ──                            ║");
            System.out.println("║   1. Registrar estudiante                                ║");
            System.out.println("║   2. Buscar estudiante por ID                            ║");
            System.out.println("║   3. Listar todos los estudiantes                        ║");
            System.out.println("║   4. Eliminar estudiante                                 ║");
            System.out.println("║  ── GESTIÓN DE MATERIAS ──                               ║");
            System.out.println("║   5. Crear materia                                       ║");
            System.out.println("║   6. Agregar pre-requisito a materia                     ║");
            System.out.println("║   7. Mostrar pre-requisitos de una materia               ║");
            System.out.println("║   8. Inscribir estudiante                                ║");
            System.out.println("║   9. Cancelar inscripción                                ║");
            System.out.println("║  10. Mostrar cola de espera                              ║");
            System.out.println("║  ── GESTIÓN DE HORARIOS ──                               ║");
            System.out.println("║  11. Reservar horario en aula                            ║");
            System.out.println("║  12. Liberar horario de aula                             ║");
            System.out.println("║  13. Consultar disponibilidad                            ║");
            System.out.println("║  ── RUTAS ENTRE EDIFICIOS ──                             ║");
            System.out.println("║  14. Agregar conexión entre edificios                    ║");
            System.out.println("║  15. Calcular ruta mas corta                             ║");
            System.out.println("║  ── REPORTES ACADÉMICOS ──                               ║");
            System.out.println("║  16. Registrar nota                                      ║");
            System.out.println("║  17. Ver reporte academico                               ║");
            System.out.println("║  18. Navegador de reportes(atras/adelante)               ║");
            System.out.println("║  ── DESHACER / REHACER ──                                ║");
            System.out.println("║  19. Deshacer última acción                              ║");
            System.out.println("║  20. Rehacer ultima operacion                            ║");
            System.out.println("║   ── PROCESAMIENTO POR LOTES ──                          ║");
            System.out.println("║  ── SALIR──                                              ║");
            System.out.println("║   22. Salir                                              ║");
            System.out.println("║   Seleccione una opcion                                  ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    RegistrarEstudiante();
                    break;
                case 2:
                    // Lógica para buscar estudiante por ID
                    break;
                // ... otros casos
                case 3:
                    // MenuregistrarPaciente();
                    break;
                case 4:
                    // MenuActualizarInformacionPaciente();
                    break;
                case 5:
                    // MenuBuscarPaciente();
                    break;
                case 6:
                    // MenuVisualizarHistorialBasico();
                    break;
                case 7:
                    // Lógica para registrar estudiante
                    break;
                case 8:
                    // Lógica para buscar estudiante por ID
                    break;
                // ... otros casos
                case 9:
                    // MenuregistrarPaciente();
                    break;
                case 10:
                    // MenuActualizarInformacionPaciente();
                    break;
                case 11:
                    // MenuBuscarPaciente();
                    break;
                case 12:
                    // MenuVisualizarHistorialBasico();
                    break;
                case 13:
                    // Lógica para registrar estudiante
                    break;
                case 14:
                    // Lógica para buscar estudiante por ID
                    break;
                // ... otros casos
                case 15:
                    // MenuregistrarPaciente();
                    break;
                case 16:
                    // MenuActualizarInformacionPaciente();
                    break;
                case 17:
                    // MenuBuscarPaciente();
                    break;
                case 18:
                    // MenuVisualizarHistorialBasico();
                    break;
                case 19:
                    // Lógica para registrar estudiante
                    break;
                case 20:
                    // Lógica para buscar estudiante por ID
                    break;
                // ... otros casos
                case 21:
                    // MenuregistrarPaciente();
                    break;

                case 22:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    break;
            }
        } while (opcion != 22);

    }


    private static void RegistrarEstudiante() {
        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID del estudiante:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el email del estudiante:");
        String email = scanner.nextLine();
        System.out.println("Ingrese el semestre del estudiante:");
        int semestre = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Aquí se podría agregar lógica para crear un nuevo objeto Estudiante y guardarlo en una lista o base de datos
    }

}
