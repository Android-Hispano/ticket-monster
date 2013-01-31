package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


 /**
 * 
 * Un Espectáculo es una instancia de un lugar. Esto consiste en un conjunto de actuaciones del espectáculo.
 * Un Espectáculo contiene la tarifa de entradas disponibles.
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

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id_evento" , "id_lugar" }))
public class Espectaculo {
	
	/* Declaración de campos */
	
	/**
	 * El id sintético del objeto.
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	
	/*
	 * El evento del cual este espectáculo está instanciado. El mapeo JPA  @ManyToOne establece esta relación.
	 * 
	 * La limitación Bean Validation @NotNull significa que el evento debe ser especificado.
	 * 
	 */
	
	@ManyToOne
	@NotNull
	private Evento evento;
	
	
	/*
	 * El lugar donde este espectáculo toma lugar. El mapeo JPA  @ManyToOne establece esta relación.
	 * 
	 * La limitación Bean Validation @NotNull significa que el evento debe ser especificado.
	 * 
	 */
	
	@ManyToOne
	@NotNull
	private Lugar lugar;
	
	
	/**
     * 
     * El conjunto de actuaciones para este espectáculo.
     * 
     * 
     * El mapeo JPA @OneToMany establece esta relación.  
     * Esta relación es bidireccional (una actuación sabe que espectáculo es parte de ella) y el atributo mappedBy
     * establece esto. Tenemos en cascada todas las operaciones de persistencia para el conjunto de actuaciones,
     * así si, por ejemplo, si un espectáculo es eliminado, entonces todas las actuaciones relacionadas serán eliminadas.
     * 
     * 
     * Normalmente una colección se carga desde la base de datos en el orden de las filas, pero aquí tenemos
     * que asegurarnos que las actuaciones son ordenadas por fecha - vamos a dejar que el RDBMS haga el trabajo
     * pesado. La anotación @OrderBy instruye a JPA para hacer esto.
     * 
     */
    @OneToMany(fetch = EAGER, mappedBy = "espectaculo", cascade = ALL)
    @OrderBy("date")
    private Set<Actuacion> actuaciones = new HashSet<Actuacion>();
    
    
    /**
     * 
     * La tarifa disponible para este espectáculo.
     * 
     * 
     * El mapeo JPA @OneToMany establece esta relación.  
     * Esta relación es bidireccional ( una categoría de precios de tickets sabe que espectáculo es parte de ella), 
     * y el atributo mappedBy establece esto. Tenemos todas las operaciones de persistencia en cascada para el 
     * conjunto de actuaciones, así, por ejemplo si un espectáculo es eliminado, entonces todas las categorías de
     * precio de ticket son también eliminadas.
     * 
     */
    @OneToMany(fetch = EAGER, mappedBy = "espectaculo", cascade = ALL)
    private Set<PrecioEntrada> tarifa = new HashSet<PrecioEntrada>();
	

    
    /* Boilerplate getters y setters */
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	public Set<Actuacion> getActuaciones() {
		return actuaciones;
	}


	public void setActuaciones(Set<Actuacion> actuaciones) {
		this.actuaciones = actuaciones;
	}	

	
	public Set<PrecioEntrada> getTarifa() {
		return tarifa;
	}


	public void setTarifa(Set<PrecioEntrada> tarifa) {
		this.tarifa = tarifa;
	}


	/* toString(), equals() y hashCode() para Espectaculo, utilizando la identidad natural del objeto */
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Espectaculo espectaculo = (Espectaculo) o;

        if (evento != null ? !evento.equals(espectaculo.evento) : espectaculo.evento != null)
            return false;
        if (lugar != null ? !lugar.equals(espectaculo.lugar) : espectaculo.lugar != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = evento != null ? evento.hashCode() : 0;
        result = 31 * result + (lugar != null ? lugar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return evento + " como " + lugar;
    }
}
