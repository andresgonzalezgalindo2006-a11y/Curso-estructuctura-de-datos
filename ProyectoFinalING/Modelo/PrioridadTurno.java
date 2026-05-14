package ProyectoFinalING.Modelo;

/**
 * Prioridad del turno en la sala de espera.
 *
 * El orden de declaración importa: la PriorityQueue de Java usa
 * el orden natural del enum (ordinal). URGENTE se declara primero
 * para que tenga ordinal 0 y salga ANTES que NORMAL (ordinal 1)
 * al hacer poll() en la cola de prioridad.
 */
public enum PrioridadTurno {

    URGENTE,
    NORMAL

}
