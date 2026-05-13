package src.modelo;
import java.util.LinkedList;

public class  Estudiante extends Persona {
    private String carrera;
    private int semestre;
 // Matriz para almacenar las calificaciones de cada semestre
    private Double [][] notas; 
    // Lista para almacenar el historial de materias cursadas por el estudiante
    private LinkedList<materia> historialMaterias;
   

    // Constructor que llama al constructor de la clase padre (Persona) y además inicializa los atributos propiosde Estudiante
    public Estudiante(String nombre, int id, String email, String carrera, int semestre) {
        super(nombre, id, email);
        this.carrera = carrera;
        this.semestre = semestre;
        // son 10 semestres x 20 materias
        this.notas = new Double[10][20]; 
        this.historialMaterias = new LinkedList<>();
    }

    
  

    public Double[][] getNotas() {
        return notas;
    }



    public void setNotas(Double[][] notas) {
        this.notas = notas;
    }



    public LinkedList<materia> getHistorialMaterias() {
        return historialMaterias;
    }




    public void setHistorialMaterias(LinkedList<materia> historialMaterias) {
        this.historialMaterias = historialMaterias;
    }




    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    
      @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("ID: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
    }
}
