package modelo;

import java.util.LinkedList;
import java.util.Queue;

public class Materia {
    private String codigo;
    private String nombre;
    private int creditos;

    private int cupoMaximo;
    private int cupoActual;

    private LinkedList<Materia> preRequisitos;
    private Queue<Estudiante> colaEspera;

    public Materia(String codigo, String nombre, int creditos, int cupoMaximo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cupoMaximo = cupoMaximo;
        this.cupoActual = 0; // Inicialmente no hay estudiantes inscritos

        this.preRequisitos = new LinkedList<>();

        this.colaEspera = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupoActual() {
        return cupoActual;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public LinkedList<Materia> getPreRequisitos() {
        return preRequisitos;
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
}