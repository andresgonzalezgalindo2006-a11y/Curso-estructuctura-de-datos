package ProyectoFinalING.Modelo;

/**
 * Entidad del dominio que representa un turno de atención.
 * Asocia un Paciente existente con una prioridad y un estado.
 *
 * CORRECCIÓN: se agrega número de turno correlativo para
 * identificar cada turno de forma única y mostrarlo en pantalla.
 */
public class Turno {

    private static int contadorTurnos = 1;

    private final int numeroTurno;

    private final Paciente paciente;

    private final PrioridadTurno prioridad;

    private EstadoTurno estado;


    public Turno(
            Paciente paciente,
            PrioridadTurno prioridad) {

        this.numeroTurno = contadorTurnos++;

        this.paciente  = paciente;

        this.prioridad = prioridad;

        this.estado    = EstadoTurno.EN_ESPERA;

    }


    public int getNumeroTurno() {
        return numeroTurno;
    }


    public Paciente getPaciente() {
        return paciente;
    }


    public PrioridadTurno getPrioridad() {
        return prioridad;
    }


    public EstadoTurno getEstado() {
        return estado;
    }


    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {

        return "\n=== TURNO N° " + numeroTurno + " ==="
                + "\nPaciente  : " + paciente.getNombre()
                + "\nDocumento : " + paciente.getCedula()
                + "\nPrioridad : " + prioridad
                + "\nEstado    : " + estado;

    }

}
