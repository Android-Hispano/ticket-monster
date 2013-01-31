package android.hispano.ejemplos.ticketmonster.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


/**
 *
 * Una entrada representa un asiento vendido a un precio en particular.
 * 
 * @author Shane Bryzak
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
public class Entrada {

    /* Declaración de campos */

    /**
     * El ID sintético del objeto.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     *
     * El asiento para el cual este ticket ha sido vendido.
     * 
     *
     * El asiento debe ser especificado, y la limitación Bean Validation @NotNull asegura esto.
     * 
     */
    @NotNull
    private Asiento asiento;

    /**
     * 
     * La categoría del precio de la entrada para el cual ha sido vendida esta entrada.
     * 
     * 
     * La categoría de precio de la entrada debe ser especificada, y la limitación Bean Validation constraint 
     * @NotNull se asegurará de ello.
     * 
     */
    @ManyToOne
    @NotNull
    private CategoriaEntrada categoriaEntrada;

    /**
     * El precio que ha sido cargado a la entrada.
     */
    private float precio;

    /** Contructor para la persistencia */
    public Entrada() {

    }

    public Entrada(Asiento asiento, CategoriaEntrada categoriaEntrada, float precio) {
        this.asiento = asiento;
        this.categoriaEntrada = categoriaEntrada;
        this.precio = precio;
    }

    /* Boilerplate getters y setters */

    public Long getId() {
        return id;
    }

    public CategoriaEntrada getCategoriaEntrada() {
        return categoriaEntrada;
    }

    public float getPrecio() {
        return precio;
    }

    public Asiento getAsiento() {
        return asiento;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(getAsiento()).append(" @ ").append(getPrecio()).append(" (").append(getCategoriaEntrada()).append(")").toString(); 
    }
}
