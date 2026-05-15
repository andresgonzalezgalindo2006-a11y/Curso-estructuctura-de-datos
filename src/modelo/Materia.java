package modelo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa una materia del sistema universitario. Usa LinkedList para
 * pre-requisitos e historial, y Queue para cola de espera.
 */
public class Materia {

    private String codigo;
    private String nombre;
    private int creditos;

    private int cupoMaximo;
    private int cupoActual;
    /**
     * Pre-requisitos: lista enlazada de otras materias
     */
    private LinkedList<Materia> preRequisitos;
    /**
     * Cola de espera cuando el cupo está lleno
     */
    private Queue<Estudiante> colaEspera;

    public Materia(
            String codigo,
            String nombre,
            int creditos,
            int cupoMaximo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;

        this.cupoMaximo = cupoMaximo;

        this.cupoActual = 0;

        this.preRequisitos = new LinkedList<>();

        this.colaEspera = new LinkedList<>();
    }

    public boolean tieneCupo() {

        return cupoActual < cupoMaximo;
    }

    public void ocuparCupo() {

        cupoActual++;
    }

    public void liberarCupo() {

        cupoActual--;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Materia> getPreRequisitos() {
        return preRequisitos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public void agregarPreRequisito(Materia m) {
        preRequisitos.add(m);
    }

}