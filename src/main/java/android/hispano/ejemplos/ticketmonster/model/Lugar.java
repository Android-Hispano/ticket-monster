package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * 
 * Simplemente representa un Lugar.
 * 
 * 
 * @author Shane Bryzak
 * @author Pete Muir
 * @translate Javier Hdez
 *
 *
 **/

 /* 
 * Eliminaremos la advertencia para no especificar un serialVersionUID, ya que aún esta app está en
 * desarrollo, y dejaremos que la JVM genere el serialVersionUID por nosotros. Cuando pongamos esta
 * aplicación en producción, generaremos e incustraremos el serialVersionUID.
 *
 */

@SuppressWarnings("serial")
@Entity
public class Lugar {
	
	/* Declaración de campos */
	/**
	 * El id sintético del objeto.
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
 
 
	/**
	 * 
	 * El nombre del evento.
	 * 
	 * El nombre del evento forma la identidad natural, y no puede ser compartido entre eventos.
	 * 
	 * El nombre no puede ser null y debe tener uno o más caracteres, la limitación Bean Validation @NotEmpty fuerza esto.
	 * 
	 */
	@Column(unique = true)
	@NotEmpty
	private String nombre;
	
	/**
	 * La dirección del lugar.
	 */
	private Direccion direccion = new Direccion();
 	
	/**
	 * La descripción del lugar.
	 */
	private String descripcion;
 	
	
	/**
	 * Un conjunto de secciones en el lugar.
	 * .
	 * El mapeo JPA @OneToMany establece esta relación. Las Colecciones de miembros son recuperadas
	 * con entusiasmo (eagerly), y de esta manera pueden ser accesadas incluso después de que la entidad
	 * haya sido separada. Esta relación es bidireccional ( una sección sabe que el lugar es parte de ella ), y el
	 * atributo mappedBy establece esto. Realizamos las operaciones de persistenia en cascada
	 * para el conjunto de actuaciones, así, por ejemplo si un lugar es eliminado, entonces
	 * todas las secciones son eliminadas también.
	 * 
	 */
	@OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "lugar")
	private Set<Seccion> secciones = new HashSet<Seccion>();
	
	
 	/**
 	 * El aforo del lugar.
 	 */
 	private int aforo;
 	
 	/**
 	 * 
 	 * Un elemento multimedia opcional para atraer clientes al lugar. El mapeo JPA @ManyToOne establece 
 	 * la relación.
 	 */
	@ManyToOne
	private ElementoMultimedia elementoMultimedia;

	
	
	
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(Set<Seccion> secciones) {
		this.secciones = secciones;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public ElementoMultimedia getElementoMultimedia() {
		return elementoMultimedia;
	}

	public void setElementoMultimedia(ElementoMultimedia elementoMultimedia) {
		this.elementoMultimedia = elementoMultimedia;
	}
	
	/* toString(), equals() y hashCode() para Lugar, utilizando la identidad natural del objeto */
	 @Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null || getClass() != o.getClass())
	            return false;

	        Lugar lugar = (Lugar) o;

	        if (direccion != null ? !direccion.equals(lugar.direccion) : lugar.direccion != null)
	            return false;
	        if (nombre != null ? !nombre.equals(lugar.nombre) : lugar.nombre != null)
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = nombre != null ? nombre.hashCode() : 0;
	        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
	        return result;
	    }

	    @Override
	    public String toString() {
	        return nombre;
	    }
	
}