package PilasYcolas;
import java.util.Stack;


public class EjecutarPila {
    
    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();


        System.out.println(pila.isEmpty()); // true

        // Insertar elementos a la pila
        pila.push("Maria Jose");
        pila.push("Dalmar");
        pila.push("Samuel");
        pila.push("Yolian");

        // mostar la pila
        System.out.println(pila);

        // Mostar el tope de la pila sin eliminar el elemento
        System.out.println(pila.peek()); // Yolian

        // eliminar el tope de la pila
        System.out.println("Elemento eliminado: " + pila.pop());

        // mostrar la pila despues de eliminar tope
        System.out.println(pila); // [Maria Jose, Dalmar, Samuel]


        System.out.println("Buscar: " + pila.search("Samuel"));
        System.out.println("Buscar: " + pila.search("Dalmar"));
        System.out.println("Buscar: " + pila.search("Maria Jose"));


        System.out.println("Capacidad: " + pila.capacity());
        System.out.println("Elemento en la posición especificada: " + pila.get(2));
        System.out.println("clonar la pila: " + pila.clone());
        System.out.println(""+ containsAll(pila, "Samuel", "Dalmar", "Maria Jose"));

        

        






    }







































    
    public static boolean containsAll(Stack<String> pila, String... elementos) {
        for (String elemento : elementos) {
            if (!pila.contains(elemento)) {
                return false;
            }
        }
        return true;
    }
}
