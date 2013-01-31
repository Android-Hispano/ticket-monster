package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


/**
 * 
 * Contiene la categoría de precios - cada categoría representa el precio para una entrada en una sección en particular para 
 * un lugar particular, para una categoría de entrada en particular.
 * 
 * La sección, espectáculo y categoría de entrada forman el ID natural de esta entidad, y por lo tanto debe ser único. JPA 
 * nos obliga a utilizar la limitación de nivel de clase @Table.
 * 
 * @author Shane Bryzak
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
// TODO Document @JsonIgnoreProperties
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id_seccion", "id_espectaculo", "id_categoriaentrada" }))
public class PrecioEntrada{

    /* Declaración de campos */

    /**
     * El ID sintético del objeto.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * 
     * El espectáculo a el cual pertenece esta categoría de precio de entrada. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * La limitación Bean Validation @NotNull significa que se debe especificar un espectáculo.
     * 
     */
    @ManyToOne
    @NotNull
    private Espectaculo espectaculo;

    /**
     * 
     * La sección a la cual pertenece esta categoría de precio de entrada. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * La limitación Bean Validation @NotNull significa que se debe especificar la sección.
     * 
     */
    @ManyToOne
    @NotNull
    private Seccion seccion;

    /**
     * 
     * La categoría de entrada a la cual pertenece esta categoría de precio. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * La limitación Bean Validation @NotNull significa que la categoría de entrada debe ser especificada.
     * 
     */
    @ManyToOne
    @NotNull
    private CategoriaEntrada categoriaEntrada;

    /**
     * El precio para esta categoría de entrada.
     */
    private float precio;

    
    /* Boilerplate getters y setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public CategoriaEntrada getTicketCategory() {
        return categoriaEntrada;
    }

    public void setCategoriaEntrada(CategoriaEntrada categoriaEntrada) {
        this.categoriaEntrada = categoriaEntrada;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /* equals() y hashCode() para PrecioEntrada, utilizando la identidad natural del objeto. */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PrecioEntrada that = (PrecioEntrada) o;

        if (seccion != null ? !seccion.equals(that.seccion) : that.seccion != null)
            return false;
        if (espectaculo != null ? !espectaculo.equals(that.espectaculo) : that.espectaculo != null)
            return false;
        if (categoriaEntrada != null ? !categoriaEntrada.equals(that.categoriaEntrada) : that.categoriaEntrada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = espectaculo != null ? espectaculo.hashCode() : 0;
        result = 31 * result + (seccion != null ? seccion.hashCode() : 0);
        result = 31 * result + (categoriaEntrada != null ? categoriaEntrada.hashCode() : 0);
        return result;
    }
}