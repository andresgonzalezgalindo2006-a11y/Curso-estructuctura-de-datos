package util;

import modelo.Estudiante;
import java.util.HashMap;

public class GestorEstudiantes {
    private HashMap<String, Estudiante> estudiantes;

    public GestorEstudiantes() {
        this.estudiantes = new HashMap<>();
    }


    public void registrar(Estudiante e) {

        estudiantes.put(e.getId(), e);
    }

    public Estudiante buscar(String id) {

        return estudiantes.get(id);
    }

    public void eliminar(String id) {

        estudiantes.remove(id);
    }

    public void listar() {

        for (Estudiante e : estudiantes.values()) {

            e.mostrarInformacion();
        }
    }
}
