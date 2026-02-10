package semana2;

public class Ejercicio1 {

    public static void main(String[] args) {
        // forma.1 -> Definiendo directamente los valores del arreglo
        int[] a = { 4, 8, 9, 6, 1, 2, 10 };
        // iterar o recorrer los elementos del arreglo
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + ")= " + a[i]);

           // sumar los numeros pares e impares y mostrar el resultado
            int sumaPar = 0;
            int sumaImpares = 0;
            for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sumaPar += a[i];
                
            } else {
                sumaImpares += a[i];  
            }

            System.out.println("la suma de los pares es " + sumaPar);
            System.out.println("la suma de los impares es " + sumaImpares);

        


          
                
            }
            
        }

    }

}
