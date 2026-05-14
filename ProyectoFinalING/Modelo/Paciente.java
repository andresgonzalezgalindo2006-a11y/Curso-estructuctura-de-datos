package ProyectoFinalING.Modelo;

public class Paciente {
    private String nombre;
    private String cedula;
    private String telefono;
    private String estado;
private String fechaRegistro;

   public Paciente(
        String nombre,
        String cedula,
        String telefono) {

    this.nombre = nombre;
    this.cedula = cedula;
    this.telefono = telefono;

    this.estado = "ACTIVO";

    this.fechaRegistro =
            java.time.LocalDate.now()
                    .toString();

}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente {" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';

    }


    public String mostrarHistorialBasico() {

    return "\n=== HISTORIAL BÁSICO ==="
            + "\nNombre: " + nombre
            + "\nCédula: " + cedula
            + "\nTeléfono: " + telefono
            + "\nEstado: " + estado
            + "\nFecha de registro: " + fechaRegistro;

}

}
