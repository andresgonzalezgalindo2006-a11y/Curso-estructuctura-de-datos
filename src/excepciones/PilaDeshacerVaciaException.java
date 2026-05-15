package excepciones;

public class PilaDeshacerVaciaException extends RuntimeException {

    public PilaDeshacerVaciaException() {
        super("La pila de deshacer está vacía.");
    }
    
}
