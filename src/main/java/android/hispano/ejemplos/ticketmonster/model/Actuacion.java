package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


/**
 * 
 * Una actuación representa una simple instancia de espectáculo.
 * 
 * 
 * El espectáculo y la fecha forman la identidad natural de esta entidad, y debe ser única. JPA nos obliga a utilizar
 * la limitación @Table
 * 
 * 
 * @author Marius Bogoevici
 * @author Pete Muir
 * @translate Javier Hdez
 */
/* 
 * Eliminaremos la advertencia para no especificar un serialVersionUID, ya que aún esta app está en
 * desarrollo, y dejaremos que la JVM genere el serialVersionUID por nosotros. Cuando pongamos esta
 * aplicación en producción, generaremos e incustraremos el serialVersionUID.
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "fecha", "id_espectaculo" }))
public class Actuacion {

    /* Declaración de campos */

    /**
     * La identida sintética del objeto.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * 
     * La fecha y la hora de inicio de la actuación.
     * 
     * 
     * Un objeto Java {@link Date} representa tanto la fecha y la hora, mientras un RDBMS extrae la Fecha, Hora y Timestamp.
     * Por lo tanto instruimos a JPA para que almacene esta fecha como un timestamp utilizando la anotación @Temporal(TIMESTAMP).
     * 
     * 
     * La fecha y hora de una actuación es obligatoria, y la limitación Bean Validation @NotNull fuerza esto.
     * 
     */
    @Temporal(TIMESTAMP)
    @NotNull
    private Date fecha;

    /**
     * 
     * El espectáculo del cual es esta actuación. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * 
     * El espectáculo al que pertenece esta actuación es obligatorio, y la limitación Bean Validation @NotNull fuerza esto.
     * 
     */
    @ManyToOne
    @NotNull
    private Espectaculo espectaculo;

    /* Boilerplate getters y setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /* toString(), equals() y hashCode() para Actuacion, utilizando la identidad natural del objeto */

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Actuacion that = (Actuacion) o;

        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null)
            return false;
        if (espectaculo != null ? !espectaculo.equals(that.espectaculo) : that.espectaculo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fecha != null ? fecha.hashCode() : 0;
        result = 31 * result + (espectaculo != null ? espectaculo.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return espectaculo + " el " + fecha.toString(); 
    }
}