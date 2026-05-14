package ProyectoFinalING.Persistencia;

import ProyectoFinalING.Modelo.EstadoTurno;
import ProyectoFinalING.Modelo.Turno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implementación en memoria del repositorio de turnos.
 *
 * CORRECCIÓN PRINCIPAL: el nombre de la clase ahora es
 * RepositorioTurnoMemoria (antes el archivo tenía "public class RepositorioTurno"
 * lo que generaba el error de compilación porque el nombre no coincidía
 * con el nombre del archivo).
 *
 * ESTRUCTURA DE DATOS: PriorityQueue<Turno>
 * - Ordena automáticamente por el ordinal del enum PrioridadTurno.
 * - URGENTE (ordinal 0) siempre sale antes que NORMAL (ordinal 1).
 * - Complejidad: inserción O(log n), extracción O(log n), lectura O(n).
 * - Ventaja: prioridad automática sin recorrer toda la lista manualmente.
 *
 * CORRECCIÓN DE LÓGICA: se usa Comparator.comparingInt con el ordinal
 * del enum para garantizar que URGENTE tenga menor valor y salga primero.
 */
public class RepositorioTurnoMemoria implements RepositorioTurno {

    private final PriorityQueue<Turno> cola;


    public RepositorioTurnoMemoria() {

        // Ordena por ordinal del enum: URGENTE=0 < NORMAL=1 → URGENTE sale primero
        this.cola = new PriorityQueue<>(
                Comparator.comparingInt(
                        turno -> turno.getPrioridad().ordinal()
                )
        );

    }


    @Override
    public void agregarTurno(Turno turno) {
        cola.offer(turno);
    }


    @Override
    public Turno siguienteTurno() {
        return cola.poll();
    }


    @Override
    public List<Turno> listar() {
        // Retorna copia ordenada para no exponer la cola interna
        List<Turno> lista = new ArrayList<>(cola);
        lista.sort(Comparator.comparingInt(
                turno -> turno.getPrioridad().ordinal()
        ));
        return lista;
    }


    @Override
    public boolean estaVacia() {
        return cola.isEmpty();
    }


    /**
     * Verifica si un paciente ya tiene un turno EN_ESPERA activo,
     * para evitar turnos duplicados (validación HU6).
     */
    @Override
    public boolean tieneTurnoActivo(String cedula) {

        for (Turno turno : cola) {

            boolean mismaCedula = turno.getPaciente()
                    .getCedula()
                    .equals(cedula);

            boolean enEspera = turno.getEstado()
                    == EstadoTurno.EN_ESPERA;

            if (mismaCedula && enEspera) {
                return true;
            }

        }

        return false;

    }

}
