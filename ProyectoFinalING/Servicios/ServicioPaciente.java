package ProyectoFinalING.Servicios;

import ProyectoFinalING.Modelo.Paciente;
import ProyectoFinalING.Persistencia.RepositorioPaciente;

public class ServicioPaciente {

    private RepositorioPaciente repositorioPaciente;

    public ServicioPaciente(
            RepositorioPaciente repositorioPaciente) {

        this.repositorioPaciente = repositorioPaciente;

    }

    // Registrar
    public String registrarPaciente(
            String nombre,
            String cedula,
            String telefono) {

        if (nombre.isBlank()
                || cedula.isBlank()
                || telefono.isBlank()) {

            return "Todos los campos son obligatorios.";

        }

        if (!nombreValido(nombre)) {

            return "Nombre inválido. Solo se permiten letras.";

        }

        // Limpiar la cédula de todo carácter que no sea dígito
        cedula = cedula.replaceAll("[^\\d]", "");

        String errorCedula = validarCedula(cedula);
        if (errorCedula != null) {
            return errorCedula;
        }

        if (!telefonoValido(telefono)) {

            return "Teléfono inválido. Debe tener 10 dígitos.";

        }

        if (existePaciente(cedula)) {

            return "El paciente ya existe.";

        }

        Paciente paciente = new Paciente(
                nombre,
                cedula,
                telefono);

        repositorioPaciente.guardarPaciente(
                paciente);

        return "Paciente registrado exitosamente.";

    }

    // EXISTE
    public boolean existePaciente(
            String cedula) {

        cedula = cedula.replaceAll("[^\\d]", "");
        return repositorioPaciente
                .ExisteporDocumento(
                        cedula);

    }

    // BUSCAR
    public Paciente buscarPaciente(
            String cedula) {

        cedula = cedula.replaceAll("[^\\d]", "");
        return repositorioPaciente
                .buscarPorCedula(
                        cedula);

    }
// ACTUALIZAR

    public String actualizarPaciente(
            String cedula,
            String nuevoNombre,
            String nuevoTelefono) {

        // LIMPIAR CÉDULA
        cedula = cedula.trim();
        cedula = cedula.replaceAll("[^\\d]", "");

        // VALIDAR CÉDULA
        String errorCedula = validarCedula(cedula);

        if (errorCedula != null) {

            return errorCedula;

        }

        // VALIDAR NOMBRE
        if (!nombreValido(nuevoNombre)) {

            return "Nombre inválido. Solo se permiten letras.";

        }

        // VALIDAR TELÉFONO
        if (!telefonoValido(nuevoTelefono)) {

            return "Teléfono inválido. Debe contener 10 dígitos.";

        }

        // ACTUALIZAR PACIENTE
        boolean actualizado = repositorioPaciente
                .actualizarPaciente(
                        cedula,
                        nuevoNombre,
                        nuevoTelefono);

        if (actualizado) {

            return "Paciente actualizado correctamente.";

        }

        return "Paciente no encontrado.";

    }

    private boolean nombreValido(String nombre) {

        return nombre.matches(
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");

    }

    /**
     * Valida la cédula ya limpia (solo dígitos) y retorna un mensaje de error o
     * null si es válida.
     */
    private String validarCedula(String cedulaLimpia) {
        if (cedulaLimpia.isEmpty()) {
            return "Cédula inválida. Solo se permiten números.";
        }
        if (cedulaLimpia.length() < 6 || cedulaLimpia.length() > 12) {
            return "Cédula inválida. Debe tener entre 6 y 12 dígitos.";
        }
        return null; // válida
    }

    private boolean telefonoValido(String telefono) {

        return telefono.matches(
                "^\\d{10}$");

    }

public String visualizarHistorialBasico(
        String cedula) {

    Paciente paciente =
            repositorioPaciente
                    .buscarPorCedula(
                            cedula
                    );

    if (paciente == null) {

        return "Paciente no encontrado.";

    }

    return paciente
            .mostrarHistorialBasico();

}

}
