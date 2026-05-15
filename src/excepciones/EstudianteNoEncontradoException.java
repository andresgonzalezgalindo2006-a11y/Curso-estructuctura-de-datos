package excepciones;

public class EstudianteNoEncontradoException extends RuntimeException {
    public EstudianteNoEncontradoException() {
        super("El estudiante no fue encontrado.");
    }
    
}
