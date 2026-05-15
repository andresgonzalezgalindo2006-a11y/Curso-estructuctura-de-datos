package excepciones;

public class PreRequisitoNoAprobadoException extends RuntimeException {
    public PreRequisitoNoAprobadoException() {
        super("El estudiante no ha aprobado el pre-requisito.");
    }
    
}
