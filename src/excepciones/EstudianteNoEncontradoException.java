package excepciones;

public class EstudianteNoEncontradoException extends RuntimeException {
    public EstudianteNoEncontradoException(String string) {
        super("El estudiante no fue encontrado.");
    }
    
}
