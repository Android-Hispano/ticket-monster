package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Categoría del evento.
 * 
 * 
 * {@link CategoriaEvento} en una entidad simple, utilizada para facilitar a los usuarios el filtrado de información.
 * 
 * @author Shane Bryzak
 * @author Pete Muir
 * @translate Javier Hdez
 * 
 */
/* 
 * Eliminaremos la advertencia para no especificar un serialVersionUID, ya que aún esta app está en
 * desarrollo, y dejaremos que la JVM genere el serialVersionUID por nosotros. Cuando pongamos esta
 * aplicación en producción, generaremos e incustraremos el serialVersionUID.
 *
 */
@SuppressWarnings("serial")
@Entity
public class CategoriaEvento implements Serializable {

    /* Declaración de los campos */
    
    /**
     * La identidad sintética del objeto.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * 
     * Una descripción de la categoría evento.
     * 
     * 
     * La descripción de una categoría de evento está formada por un id de identidad natural y no puede ser 
     * compartido entre categorías de eventos.
     * 
     * 
     * La limitación Bean Valitadion @NotEmpty significa que la categoría evento debe tener al menos 1 caracter
     * y no puede ser null.
     * 
     */
    @Column(unique=true)
    @NotEmpty
    private String descripcion;

    /* Boilerplate getters y setters */
    
    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /* toString(), equals() y hashCode() para la CategoriaEvento, utilizando la identidad natural del objeto */
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CategoriaEvento that = (CategoriaEvento) o;

        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return descripcion != null ? descripcion.hashCode() : 0;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}