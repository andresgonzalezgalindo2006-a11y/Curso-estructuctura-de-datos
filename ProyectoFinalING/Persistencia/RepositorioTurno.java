package ProyectoFinalING.Persistencia;

import ProyectoFinalING.Modelo.Turno;
import java.util.List;

/**
 * Interfaz del repositorio de turnos.
 *
 * CORRECCIÓN: debe ser una INTERFAZ para respetar la arquitectura
 * en capas y el principio de inversión de dependencias (SOLID-D).
 * El servicio depende de esta abstracción, no de la implementación
 * concreta (RepositorioTurnoMemoria).
 *
 * En el proyecto original existían DOS archivos con la misma clase
 * RepositorioTurno lo que causaba el error de compilación:
 * "class RepositorioTurno is public, should be declared in RepositorioTurno.java"
 */
public interface RepositorioTurno {

    void agregarTurno(Turno turno);

    Turno siguienteTurno();

    List<Turno> listar();

    boolean estaVacia();

    boolean tieneTurnoActivo(String cedula);

}
