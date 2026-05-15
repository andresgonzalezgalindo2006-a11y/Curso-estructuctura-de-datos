package excepciones;

public class CupoLlenoException extends RuntimeException {
    public CupoLlenoException() {
        super("El cupo está lleno.");
    }
}