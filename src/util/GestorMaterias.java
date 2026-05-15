package util;

import modelo.Estudiante;
import modelo.Materia;

import java.util.HashMap;

public class GestorMaterias {

    private HashMap<String, Materia> materias;

    public GestorMaterias() {

        materias = new HashMap<>();
    }

    public void crearMateria(Materia materia) {

        materias.put(
                materia.getCodigo(),
                materia);
    }

    public Materia buscar(String codigo) {

        return materias.get(codigo);
    }

    public boolean inscribir(
            Estudiante estudiante,
            String codigoMateria) {

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return false;
        }

        Materia materia = materias.get(codigoMateria);

        if (materia == null) {
            System.out.println("Materia no encontrada: " + codigoMateria);
            return false;
        }

        if (materia.tieneCupo()) {

            materia.ocuparCupo();

            System.out.println("Inscripción exitosa.");
            return true;
        } else {

            materia.getColaEspera()
                    .offer(estudiante);

            System.out.println(
                    "Materia llena. Enviado a cola.");
            return true;
        }
    }

    public void cancelar(String codigoMateria) {

        Materia materia = materias.get(codigoMateria);

        materia.liberarCupo();

        if (!materia.getColaEspera().isEmpty()) {

            Estudiante siguiente = materia.getColaEspera().poll();

            materia.ocuparCupo();

            System.out.println(
                    "Asignado automáticamente a: "
                            + siguiente.getNombre());
        }
    }

    /**
     * Agrega un pre-requisito a una materia (LinkedList interna de Materia).
     */
    public void agregarPreRequisito(String codigoMateria, String codigoReq) {
        Materia m = materias.get(codigoMateria);
        Materia req = materias.get(codigoReq);
        if (m == null) {
            System.out.println("Materia no encontrada: " + codigoMateria);
            return;
        }
        if (req == null) {
            System.out.println("Pre-requisito no encontrado: " + codigoReq);
            return;
        }
        m.agregarPreRequisito(req);
        System.out.println("Pre-requisito " + codigoReq + " agregado a " + codigoMateria);
    }
}