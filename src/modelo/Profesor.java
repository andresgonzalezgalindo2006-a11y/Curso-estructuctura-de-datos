package modelo;

public class Profesor extends Persona {

    private String departamento;

    public Profesor(
            String nombre,
            int id,
            String email,
            String departamento) {

        super(nombre, id, email);

        this.departamento = departamento;

    }

    @Override
    public void mostrarInformacion() {

        System.out.println("Profesor: " + getNombre());
      
    }
}