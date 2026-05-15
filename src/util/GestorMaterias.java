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

    public void agregarPreRequisito(
            String codigoMateria,
            Materia requisito) {

        Materia materia = materias.get(codigoMateria);

        materia.getPreRequisitos()
                .add(requisito);
    }

    public void inscribir(
            Estudiante estudiante,
            String codigoMateria) {

        Materia materia = materias.get(codigoMateria);

        if (materia.tieneCupo()) {

            materia.ocuparCupo();

            System.out.println("Inscripción exitosa.");
        }
        else {

            materia.getColaEspera()
                    .offer(estudiante);

            System.out.println(
                    "Materia llena. Enviado a cola.");
        }
    }

    public void cancelar(String codigoMateria) {

        Materia materia = materias.get(codigoMateria);

        materia.liberarCupo();

        if (!materia.getColaEspera().isEmpty()) {

            Estudiante siguiente =
                    materia.getColaEspera().poll();

            materia.ocuparCupo();

            System.out.println(
                    "Asignado automáticamente a: "
                            + siguiente.getNombre());
        }
    }
}