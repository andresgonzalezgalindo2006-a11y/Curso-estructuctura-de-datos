package excepciones;

public class ColaDeEsperaVaciaException extends RuntimeException {
    public ColaDeEsperaVaciaException() {
        super("La cola de espera está vacía.");
    }
    
}
