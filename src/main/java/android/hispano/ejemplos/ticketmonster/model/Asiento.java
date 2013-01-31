package android.hispano.ejemplos.ticketmonster.model;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;


/**
 * Representa un Asiento.
 * 
 * @author Marius Bogoevici
 * @author Pete Muir
 * @translate Javier Hdez
 */
@Embeddable
public class Asiento {

    @Min(1)
    private int numeroFila;

    @Min(1)
    private int numero;

    /**
     * El mapeo JPA @ManyToOne establece esta relación.
     */
    @ManyToOne
    private Seccion seccion;

    /** Constructor para la persistencia */
    public Asiento() {
    }

    /* Boilerplate getters y setters */

    public Asiento(Seccion seccion, int numeroFila, int numero) {
        this.seccion = seccion;
        this.numeroFila = numeroFila;
        this.numero = numero;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public int getnumeroFila() {
        return numeroFila;
    }

    public int getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(getSeccion()).append(" (").append(getnumeroFila()).append(", ").append(getNumero()).append(")").toString();
    }
}
