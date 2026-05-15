package util;

import modelo.Aula;

public class GestorHorarios {

    public void reservar(
            Aula aula,
            int dia,
            int hora,
            int duracion) {

        boolean[][] h = aula.getHorario();

        for (int i = hora; i < hora + duracion; i++) {

            h[dia][i] = true;
        }
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
}