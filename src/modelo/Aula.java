package modelo;

public class Aula {

    private String nombre;

    private boolean[][] horario;

    public Aula(String nombre) {

        this.nombre = nombre;

        this.horario = new boolean[7][24];
    }

    public boolean[][] getHorario() {

        return horario;
    }

    public String getNombre() {

        return nombre;
    }
}