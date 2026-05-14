package src.modelo;

public class Facultad {
    private String nombre;
    private String decano;
    private int codigo;


    
    public Facultad(String nombre, String decano, int codigo) {
        this.nombre = nombre;
        this.decano = decano;
        this.codigo = codigo;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDecano() {
        return decano;
    }



    public void setDecano(String decano) {
        this.decano = decano;
    }



    public int getCodigo() {
        return codigo;
    }



    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



    
    
}
