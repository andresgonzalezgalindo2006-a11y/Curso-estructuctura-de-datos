package util;

import modelo.Aula;

public class GestorHorarios {

    public boolean reservar(
            Aula aula,
            int dia,
            int hora,
            int duracion) {

        boolean[][] h = aula.getHorario();

        for (int i = hora; i < hora + duracion; i++) {

            if (h[dia][i]) {

                return false;
            }
        }

        for (int i = hora; i < hora + duracion; i++) {

            h[dia][i] = true;
        }

        return true;
    }

    public void liberar(
            Aula aula,
            int dia,
            int hora,
            int duracion) {

        boolean[][] h = aula.getHorario();

        for (int i = hora; i < hora + duracion; i++) {

            h[dia][i] = false;
        }
    }

    public boolean disponible(
            Aula aula,
            int dia,
            int hora) {

        return !aula.getHorario()[dia][hora];
    }
}