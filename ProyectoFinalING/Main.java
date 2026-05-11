package ProyectoFinalING;

import ProyectoFinalING.Persistencia.RepositorioPaciente;
import ProyectoFinalING.Servicios.ServicioPaciente;
import ProyectoFinalING.Vista.InterfazRecepcionista;
import ProyectoFinalING.Controlador.ControladorGestionPaciente;

public class Main {
    public static void main(String[] args) {
        // Capa de persistencia
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
        // Capa de servicios
        ServicioPaciente servicioPaciente = new ServicioPaciente(repositorioPaciente);
        // capa de controlador
        ControladorGestionPaciente controladorGestionPaciente = new ControladorGestionPaciente(servicioPaciente);
        // capa de vista
        InterfazRecepcionista interfazRecepcionista = new InterfazRecepcionista(controladorGestionPaciente);
        interfazRecepcionista.mostrarMenuRecepcionista();
    }
}