package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * Una sección es un área específica con una capa lugar. Una capa lugar debe consistir de múltiples secciones.
 * 
 * 
 * El nombre y lugar forman la identidad natural de esta entidad, y debe ser único. JPA
 * nos obliga a utilizar la limitación de nivel de clase @Table.
 * 
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
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nombre", "id_lugar"}))
// TODO Document @JsonIgnoreProperties
public class Seccion {

    /* Declaracion de campos */

    /**
     * El ID sintético del objeto.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * 
     * El nombre corto de la sección, debe ser un código como A12, G7, etc.
     * 
     * La limitación Bean Validation @NotEmpty significa que el nombre de la sección debe ser 
     * de al menos 1 caracter.
     * 
     */
    @NotEmpty
    private String nombre;

    /**
     * 
     * La descripción de la sección, como 'Rear, Balcony', etc
     * 
     * 
     * La limitación Bean Validation @NotEmpty significa que la descripción de la sección
     * debe contener al menos 1 caracter.
     * 
     */
    @NotEmpty
    private String descripcion;

    /**
     * 
     * El lugar al cual pertenece la sección. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * 
     * La limitación Bean Validation @NotNull quiere decir que hay que especificar el lugar.
     * 
     */
    @ManyToOne
    @NotNull
    private Lugar lugar;

    /**
     * El número de filas que forman la sección.
     */
    private int numeroDeFilas;

    /**
     * El número de asientos en una fila.
     */
    private int aforoFila;

    /* Boilerplate getters y setters */
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public int getNumeroDeFilas() {
		return numeroDeFilas;
	}

	public void setNumeroDeFilas(int numeroDeFilas) {
		this.numeroDeFilas = numeroDeFilas;
	}

	public int getAforoFila() {
		return aforoFila;
	}

	public void setAforoFila(int aforoFila) {
		this.aforoFila = aforoFila;
	}
    
    
    
    
    /* toString(), equals() y hashCode() para Seccion, utilizando la idenditad natural del objeto */
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Seccion seccion = (Seccion) o;

        if (lugar != null ? !lugar.equals(seccion.lugar) : seccion.lugar != null)
            return false;
        if (nombre != null ? !nombre.equals(seccion.nombre) : seccion.lugar != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (lugar != null ? lugar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return nombre;
    }

}