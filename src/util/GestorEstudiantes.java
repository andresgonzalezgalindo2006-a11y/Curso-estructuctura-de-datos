package util;

import modelo.Estudiante;

import java.util.HashMap;

public class GestorEstudiantes {

    private HashMap<Integer, Estudiante> estudiantes;

    public GestorEstudiantes() {

        estudiantes = new HashMap<>();
    }

    public void registrar(Estudiante e) {

        estudiantes.put(e.getId(), e);
    }

    public Estudiante buscar(int id) {

        return estudiantes.get(id);
    }

    public void eliminar(int id) {

        estudiantes.remove(id);
    }

    public void listar() {

        for (Estudiante e : estudiantes.values()) {

            e.mostrarInformacion();

            System.out.println("----------------");
        }
    }

    public void crearMateria(String nombre, String codigo, int creditos, int cupoMaximo) {
        
    }
}