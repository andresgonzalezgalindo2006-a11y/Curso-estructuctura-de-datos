package Taller Pilas;
import java.util.Stack;
import java.util.Scanner;

public class VerificarExpresion {
   
    public static boolean estaEquilibrado(String expresion) {
        Stack<Character> pila = new Stack<>();

        for( int i = 0;  i<expresion.length(); i++) {
          char caracter = expresion.charAt(i);
          
          if (caracter == '(' || caracter == '{' || caracter == '[') {
            pila.push(caracter);
          }

          else if ( caracter == ')' || caracter == '}' || caracter == ']') {
            if (pila.isEmpty()) {
                return false;
            }

            char tope = pila.pop();
            if ((caracter == ')' && tope != '(') ||
                (caracter == '}' && tope != '{') ||
                (caracter == ']' && tope != '[')) {
                return false;
            }
          }

        }

        
        return pila.isEmpty();
    }

 


















}
