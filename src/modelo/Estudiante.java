package modelo;

import java.util.LinkedList;

public class Estudiante extends Persona {
    private int semestre;
    // Matriz para almacenar las calificaciones de cada semestre
    private Double[][] notas;
    // Lista para almacenar el historial de materias cursadas por el estudiante
    private LinkedList<Materia> historial;

    // Constructor que llama al constructor de la clase padre y además inicializa los atributos propios de Estudiante
    public Estudiante(String nombre, int id, String email, int semestre) {
        super(nombre, id, email);

        this.semestre = semestre;
        // son 10 semestres x 20 materias
        this.notas = new Double[10][20];

        this.historial = new LinkedList<>();
    }

    public Double[][] getNotas() {
        return notas;
    }

    public void setNotas(Double[][] notas) {
        this.notas = notas;
    }

    public LinkedList<Materia> getHistorial() {
        return historial;
    }

    public void setHistorial(LinkedList<Materia> historial) {
        this.historial = historial;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Semestre: " + semestre);
    }
}
