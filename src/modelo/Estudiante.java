package src.modelo;

public class  Estudiante extends Persona {
    private String carrera;
    private int semestre;

    public Estudiante(String nombre, int id, String email, String carrera, int semestre) {
        super(nombre, id, email);
        this.carrera = carrera;
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

    
}
