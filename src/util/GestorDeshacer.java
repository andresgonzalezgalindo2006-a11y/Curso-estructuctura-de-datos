package util;

import java.util.Stack;

public class GestorDeshacer {

    private Stack<String> pilaDeshacer;

    private Stack<String> pilaRehacer;

    public GestorDeshacer() {

        pilaDeshacer = new Stack<>();

        pilaRehacer = new Stack<>();
    }

    public void registrar(String operacion) {

        pilaDeshacer.push(operacion);
    }

    public void deshacer() {

        if (!pilaDeshacer.isEmpty()) {

            pilaRehacer.push(
                    pilaDeshacer.pop());
        }
    }

    public void rehacer() {

        if (!pilaRehacer.isEmpty()) {

            pilaDeshacer.push(
                    pilaRehacer.pop());
        }
    }
}