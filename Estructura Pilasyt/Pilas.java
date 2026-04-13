
import java.util.Stack;

public class Pilas {
    
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();

        System.out.println("Pila vacía: " + pila);
        System.out.println("Está vacía? " + pila.isEmpty());

        // Agregar elementos a la pila
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        for (Integer pilita : pila) {
            System.out.println(pilita);
        }

        // mostrar
        System.out.println("Pila: " + pila);
        System.out.println("Está vacía? " + pila.isEmpty());

        


    }

}