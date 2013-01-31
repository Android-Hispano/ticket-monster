package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Una tabla de búsqueda contiene varias categorías de entrada. Ejemplo, Adultp, Niño, Pensionista, et..
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
public class CategoriaEntrada {
	
		/* Declaración de campos */
		/**
		 * El id sintético del objeto.
		 */
		@Id
		@GeneratedValue(strategy = IDENTITY)
		private Long id;
	
		/**
		*
		* La descripción de la Categoría Ticket.
		* 
		* La descripción forma la identidad natural de la categoría ticket, y debe ser único.
		* 
		* La descripción no puede ser null y debe tener más de un caracter, la limitación
		* Bean Validation asegura esto.
		*
		*/
		@Column(unique = true)
		@NotEmpty
		private String descripcion;
		
		
		/* Boilerplate getters y setters */
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDescripcion() {
		return descripcion;
		}
		public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		}
		
		
		/* toString(), equals() y hashCode() para CategoriaEntrada, utilizando la identidad natural del objeto. */
		@Override
		public String toString() {
		return descripcion;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((descripcion == null) ? 0 : descripcion.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CategoriaEntrada other = (CategoriaEntrada) obj;
			if (descripcion == null) {
				if (other.descripcion != null)
					return false;
			} else if (!descripcion.equals(other.descripcion))
				return false;
			return true;
		}
		}


