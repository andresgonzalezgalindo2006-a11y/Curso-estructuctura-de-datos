package principal;

import modelo.Aula;
import modelo.Estudiante;
import modelo.Materia;

import util.GestorDeshacer;
import util.GestorEstudiantes;
import util.GestorHorarios;
import util.GestorMaterias;
import util.GestorRutas;

import java.util.Scanner;

import excepciones.EstudianteNoEncontradoException;

public class Menu {

    private final Scanner scanner;

    private final GestorEstudiantes gestorEstudiantes;

    private final GestorMaterias gestorMaterias;

    private final GestorHorarios gestorHorarios;

    private final GestorRutas gestorRutas;

    private final GestorDeshacer gestorDeshacer;

    private final Aula aula101;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gestorEstudiantes = new GestorEstudiantes();
        this.gestorMaterias = new GestorMaterias();
        this.gestorHorarios = new GestorHorarios();
        this.gestorRutas = new GestorRutas();
        this.gestorDeshacer = new GestorDeshacer();
        this.aula101 = new Aula("101");

        inicializarCampus();
    }

    public void mostrarMenu() {

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
        System.out.println("║   21. Procesar archivo CSV                               ║");
        System.out.println("║  ── SALIR──                                              ║");
        System.out.println("║   22. Salir                                              ║");
        System.out.println("║   Seleccione una opcion:                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    private void inicializarCampus() {

        gestorRutas.conectar(0, 1, 100);

        gestorRutas.conectar(0, 2, 150);

        gestorRutas.conectar(1, 3, 300);

        gestorRutas.conectar(2, 3, 180);

        gestorRutas.conectar(2, 4, 90);

        gestorRutas.conectar(4, 3, 120);
    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();

            opcion = Integer.parseInt(
                    scanner.nextLine());

            ejecutarOpcion(opcion);

        } while (opcion != 22);
    }

    private void ejecutarOpcion(int opcion) {

        switch (opcion) {

            case 1:
                registrarEstudiante();
                break;
            case 2:
                buscarEstudiante();
                break;
            case 3:
                listarEstudiantes();
                break;
            case 4:
                eliminarEstudiante();
                break;
            case 5:
                crearMateria();
                break;
            case 6:
                // agregarPreRequisito();
                System.out.println("No implementado");
                break;
            case 7:
                // mostrarPreRequisitos();
                System.out.println("No implementado");
                break;
            case 8:
                inscribirMateria();
                break;
            case 9:
                // cancelarMateria();
                System.out.println("No implementado");
                break;
            case 10:
                // mostrarColaEspera();
                System.out.println("No implementado");
                break;
            case 11:
                reservarHorario();
                break;
            case 12:
                // liberarHorario();
                System.out.println("No implementado");
                break;
            case 13:
                // consultarHorario();
                System.out.println("No implementado");
                break;
            case 14:
                // agregarConexion();
                System.out.println("No implementado");
                break;
            case 15:
                calcularRuta();
                break;
            case 16:
                // registrarNota();
                System.out.println("No implementado");
                break;
            case 17:
                // verReporte();
                System.out.println("No implementado");
                break;
            case 18:
                // navegadorReportes();
                System.out.println("No implementado");
                break;
            case 19:
                gestorDeshacer.deshacer();
                break;
            case 20:
                gestorDeshacer.rehacer();
                break;
            case 21:
                System.out.println("BONUS NO IMPLEMENTADO");
                break;
            case 22:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    private void registrarEstudiante() {

        System.out.print("ID: ");
        int id = Integer.parseInt(
                scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Semestre: ");
        int semestre = Integer.parseInt(
                scanner.nextLine());

        Estudiante e = new Estudiante(
                nombre,
                id,
                email,
                semestre);

        gestorEstudiantes.registrar(e);

        gestorDeshacer.registrar(
                "Registrar estudiante");
    }

    private void buscarEstudiante() throws EstudianteNoEncontradoException {

        System.out.print("Ingrese ID del estudiante a buscar: ");

        int id = Integer.parseInt(
                scanner.nextLine());

        Estudiante e = gestorEstudiantes.buscar(id);

        if (e != null) {

            e.mostrarInformacion();
        } else {
            throw new EstudianteNoEncontradoException("Estudiante no encontrado");
        }
    }

    private void listarEstudiantes() {

        gestorEstudiantes.listar();
    }

    private void eliminarEstudiante() throws EstudianteNoEncontradoException {
        System.out.println("Ingrese el ID del estudiante a eliminar:");
        int id = Integer.parseInt(scanner.nextLine());

        Estudiante estudiante = gestorEstudiantes.buscar(id);

        if (estudiante != null) {
            gestorEstudiantes.eliminar(id);
            System.out.println("Estudiante eliminado exitosamente.");
        } else {
            throw new EstudianteNoEncontradoException("EL estudiante que desea eliminar no fue encontrado");
        }
    }

    
    private void crearMateria() {

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Créditos: ");
        int creditos = Integer.parseInt(scanner.nextLine());

        System.out.print("Cupo máximo: ");
        int cupoMaximo = Integer.parseInt(scanner.nextLine());

        Materia materia = new Materia(
                codigo,
                nombre,
                creditos,
                cupoMaximo);

        gestorMaterias.crearMateria(
                materia);
    }

    private void inscribirMateria() {

        System.out.print("ID estudiante: ");

        int id = Integer.parseInt(
                scanner.nextLine());

        Estudiante estudiante = gestorEstudiantes.buscar(id);

        System.out.print("Código materia: ");

        String codigo = scanner.nextLine();

        gestorMaterias.inscribir(
                estudiante,
                codigo);

        gestorDeshacer.registrar(
                "Inscripción");
    }

    private void reservarHorario() {

        boolean ok = gestorHorarios.reservar(
                aula101,
                1,
                8,
                2);

        if (ok) {

            System.out.println(
                    "Reserva exitosa");
        }
    }

    private void calcularRuta() {

        gestorRutas.dijkstra(
                0,
                3);
    }

}
