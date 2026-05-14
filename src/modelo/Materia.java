package modelo;

import java.util.LinkedList;
import java.util.Queue;

public class Materia {
    private String codigo;
    private String nombre;
    private int creditos;
    private int cupoMaximo;
    private int cupoActual;

    private LinkedList<Materia> prerequisitos;
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

    private boolean tieneCupo() {
        return cupoActual < cupoMaximo;
    }

    public void aumentarCupoActual() {
        cupoActual++;
    }

    public void disminuirCupoActual() {
        cupoActual--;
    }

    public LinkedList<Materia> getPreRequisitos() {
        return preRequisitos;
    }
    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}