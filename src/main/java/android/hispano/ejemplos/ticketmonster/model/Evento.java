package android.hispano.ejemplos.ticketmonster.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * Representa un evento, el cual debería tener múltiples actuaciones con diferentes fechas y lugares.
 * 
 * Los principales miembros del Evento están relacionados con {@link CategoriaEvento}, especificando el
 * tipo de evento que es - y {@link ElementoMultimedia} - proporcionando la disponibilidad para añadir
 * multimedia (como una imagen) para mostrar el evento. Esto también contiene meta-datos acerca del
 * evento, tales como el nombre y/o la descripción.
 * 
 * @author Shane Bryzak
 * @author Marius Bogoevici
 * @author Pete Muir
 * @translate Javier Hdez
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
public class Evento implements Serializable
{
	/* Declaración de campos */
	/**
	 * El id sintético del objeto.
	 */
   @Id
   private @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;
   @Version
   private @Column(name = "version")
   int version = 0;

   
   /**
    * 
    * El nombre del evento.
    * 
    * 
    * El nombre del evento forma la identidad natural y no puede ser compartida entre eventos.
    * 
    * 
    * Son aplicadas dos limitaciones utilizando Bean Validation
    * 
    * 
    * @NotNull el nombre no puede ser null.
    * @Size el nombre debe tener al menos 5 caracteres y no más de 50. Esto permite una mejor
    * consitencia formateando la capa de la vista.
    * 
    */
   @NotNull
   @Column(unique = true)
   private @Size(message = "Debe ser >  y < 50", min = 5, max = 50)
   String nombre;

   /**
    * 
    * Una descripción del evento.
    * 
    * 
    * Son aplicadas dos limitaciones utilizando Bean Validation
    * 
    * 
    * @NotNull la descripción no debe ser null.
    * @Size    el nombre debe tener al menos 20 caracteres y no más de 1000. Esto permite una
    * mejor consistencia formateando la capa de la vista, y tambén asegura que los organizadores
    * del evento proporcionen como mínimo alguna descripción
    * 
    */
   @Column
   private @Size(message = "Debe ser > 20 y < 1000", min = 20, max = 1000)
   String descripcion;
   
   /**
    * 
    * Un elemento multimdeia, como una imagen, la cual puede ser utilizada para atraer a un navegante 
    * a realizar una reserva.
    * 
    * 
    * Elementos multimedia pueden ser compartidos entre enventos, así esto es modelado como una relación @ManyToOne.
    * 
    * 
    * Añadir un elemento multimedia es opcional, y la capa de la vista se adaptará sino se proporciona nada.
    * 
    * 
    */
   @ManyToOne
   private ElementoMultimedia elementoMultimedia;

   


   /**
    * 
    * La categoría del evento
    * 
    * 
    * Categorías de Evento son utilizadas para buscar de manera fácil los eventos disponibles,
    * y por lo tanto esto es modelado como una relación.
    * 
    * 
    * La limitación de Bean Validation @NotNull indica que la categoría del evento se debe especificar.
    */
   @ManyToOne
   @NotNull
   private CategoriaEvento categoria;
   

   

   /* Boilerplate getters y setters */
   
   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Evento) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getNombre()
   {
      return this.nombre;
   }

   public void setNombre(final String nombre)
   {
      this.nombre = nombre;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

   public void setDescripcion(final String descripcion)
   {
      this.descripcion = descripcion;
   }

   public ElementoMultimedia getElementoMultimedia() {
		return elementoMultimedia;
	   }

   public void setElementoMultimedia(ElementoMultimedia imagen) {
	   this.elementoMultimedia = imagen;
	   }
   
   public CategoriaEvento getCategoria() {
	   return categoria;
   }

   public void setCategoria(CategoriaEvento categoria) {
	   this.categoria = categoria;
   }

public String toString()
   {
      return nombre;
   }
}