package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * A Booking represents a set of tickets purchased for a performance.
 * </p>
 * 
 * <p>
 * Booking's principle members are a <em>set</em> of tickets, and the performance for which the tickets are booked. It also
 * contains meta-data about the booking, including a contact for the booking, a booking date and a cancellation code
 * </p>
 * 
 * @author Marius Bogoevici
 */

/* 
 * Eliminaremos la advertencia para no especificar un serialVersionUID, ya que aún esta app está en
 * desarrollo, y dejaremos que la JVM genere el serialVersionUID por nosotros. Cuando pongamos esta
 * aplicación en producción, generaremos e incustraremos el serialVersionUID.
 *
 */
@SuppressWarnings("serial")
@Entity
public class Reserva {

	/* Declaración de campos */
	
	/**
	 * El ID sintético del objeto.
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	
	
	/**
	 * 
	 * El conjunto de entradas que contiene la reserva.  
	 * 
	 * El conjunto de entradas es cargado con entusiasmo porque FIXME. El mapeo JPA @OneToMany establece esta relación.
	 * 
	 * Esta relación es uni-direccional, así pues necesitaremos informar a JPA para crear un mapeo con una clave foránea. El mapeo
	 * con clave foráreno no es visible en la entidad {@link Entrada} a pesar de estar presente en la base de datos.
	 * 
	 * 
	 */
	@OneToMany(fetch = EAGER, cascade = ALL)
	@JoinColumn
	@NotNull
	@Valid
	private Set<Entrada> entradas = new HashSet<Entrada>();
	
	
	/**
	 * La actuación del espectáculo con el cual la reserva es validada.
	 * El mapeo JPA @ManyToOne establece la relación.
	 * 
	 **/
	@ManyToOne
	private Actuacion actuacion;
	
	
	/**
	 * 
	 * Un código de cancelación, permite al usuario cancelar una reserva.
	 * 
	 *  La limitación Bean Validation @NotEmpty significa que la reserva debe
	 *  contener un código de cancelación de al menos 1 caracter.
	 *   
	 */
	@NotEmpty
	private String codigoCancelacion;
	
	/**
	 * La fecha en que se realizó la reserva.
	 * 
	 * El mapeo JPA @NotNull significa que la reserva debe tener una fecha. Por defecto, se
	 * establece cuando se crea el objeto fecha.
	 * 
	 */
	@NotNull
	private Date creadoEl = new Date();
	
	
	/**
	 * 
	 * Un contacto para la reserva, en caso de que los organizadores necesiten contactar con la
	 * persona que realizó la reserva. En una iteración posterior de esta aplicación de demostración, 
	 * reemplazaremos esto por un completo sistema de gestión de usuarios, pero esto no es parte de
	 * los requerimientos iniciales.
	 * 
	 * Se aplican dos limitaciones utilizando Bean Validation.
	 * 
	 * @NotEmpty, significa que el String no puede ser null, y debe tener al menos un caracter.
	 * @Email, significa que debe tener una dirección de correo electrónico válida.
	 * 
	 */
	@NotNull
	@Email(message = "Formato de Correo Electrónico no válido.")
	private String emailContacto;
	
	/**
	 * Calcula el precio total de todas las entradas de esta reserva.
	 */
	public float getPrecioTotal(){
		float precioTotal = 0.0f;
		for (Entrada entrada : entradas) {
			precioTotal += (entrada.getPrecio());
		}
		
		return precioTotal;
	}
	
	/* Boilerplate getters y setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Actuacion getActuacion() {
		return actuacion;
	}

	public void setActuacion(Actuacion actuacion) {
		this.actuacion = actuacion;
	}

	public String getCodigoCancelacion() {
		return codigoCancelacion;
	}

	public void setCodigoCancelacion(String codigoCancelacion) {
		this.codigoCancelacion = codigoCancelacion;
	}

	public Date getCreadoEl() {
		return creadoEl;
	}

	public void setCreadoEl(Date creadoEl) {
		this.creadoEl = creadoEl;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}
	
	
	/* equals() y hashCode() para Reserva, utilizando la identidad sintética del objeto */
	  @Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null || getClass() != o.getClass())
	            return false;

	        Reserva reserva = (Reserva) o;

	        if (id != null ? !id.equals(reserva.id) : reserva.id != null)
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        return id != null ? id.hashCode() : 0;
	    }
	
}
