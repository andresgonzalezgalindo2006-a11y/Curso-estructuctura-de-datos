package util;

import java.util.Stack;

public class GestorDeshacer {

    private Stack<String> deshacer;

    private Stack<String> rehacer;

    public GestorDeshacer() {

        deshacer = new Stack<>();

        rehacer = new Stack<>();
    }

    public void registrar(String accion) {

        deshacer.push(accion);

        rehacer.clear();
    }

    public void deshacer() {

        if (!deshacer.isEmpty()) {

            String accion = deshacer.pop();

            rehacer.push(accion);

            System.out.println(
                    "Deshecha: " + accion);
        }
    }

    public void rehacer() {

        if (!rehacer.isEmpty()) {

            String accion = rehacer.pop();

            deshacer.push(accion);

            System.out.println(
                    "Rehecha: " + accion);
        }
    }
}