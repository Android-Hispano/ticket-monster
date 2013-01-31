package android.hispano.ejemplos.ticketmonster.model;

import javax.ejb.ApplicationException;

/**
 * Excepción que se lanza cuando se produce un error en la asignación de un asiento.
 * 
 * Lo marcamos como {@link ApplicationException} porque es parte de la lógica de la aplicación. También,
 * queremos el contenedor para retroceder automáticamente cuando se lanza.
 * 
 * @author Marius Bogoevici
 * @translate Javier Hdez
 */
@SuppressWarnings("serial")
@ApplicationException(rollback = true)
public class ExceptionAsignacionAsiento extends RuntimeException {

    public ExceptionAsignacionAsiento() {
    }

    public ExceptionAsignacionAsiento(String s) {
        super(s);
    }

    public ExceptionAsignacionAsiento(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ExceptionAsignacionAsiento(Throwable throwable) {
        super(throwable);
    }
}
