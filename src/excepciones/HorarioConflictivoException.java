package excepciones;

public class HorarioConflictivoException extends RuntimeException {
    public HorarioConflictivoException() {
        super("El horario es conflictivo.");
    }
    
}
