package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.URL;

/**
 *
 * Una referencia a un objeto multimedia como una imagen, tono, grabación de vídeo, que puede ser utilizada en 
 * la aplicación.
 * 
 * Un elemento multimedia contiene el tipo de multimedia, el cual es necesario para renderizarlo correctamente,
 * así como la URl en el que el objeto multimedia debe ser recuperado.
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
public class ElementoMultimedia {
	
	/* Declaración de campos */
	
	/**
	 * El ID sintético del objeto.
	 */
	@Id 
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	
	/**
	* 
	* El tipo multimedia, necesario para renderizar el elemento multimedia correctamente.
	* 
	* El tipo multimedia es un conjunto cerrado - cada diferente tipo multimedia necesita
	* soporte codificado dentro de la capa de la vista, esto no se puede ampliar sin volver
	* a reconstruir la aplicación. Por lo tanto esto se representa con una enumeración. 
	* 
	* Encomendamos JPA para almacenar los valores enum utilizando un String, de modo que más tarde
	* pueda cambiar el orden de los miembros enum, sin cambiar los datos. De momento, esto significa
	* que no puede cambiar los nombres de los elementos multimedia hasta que la aplicación sea puesta 
	* en producción. 
	**/
	@Enumerated(STRING)
	private TipoMultimedia tipoMultimedia;
	
	
	 /**
     * 
     * La URL desde la cual puede obtenerse el elemento multimedia.
     *
     * La url de elemento multimeda forma el id natural y no puede ser compartido entre
     * categorías de evento.
     * 
     * La limitación Bean Validation @URL asegura que la URL es, verdaderamente , una URL válida
     * 
     */
    @Column(unique = true)
    @URL
    private String url;

    
    
    
    /* Boilerplate getters y setters */
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TipoMultimedia getTipoMultimedia() {
		return tipoMultimedia;
	}


	public void setTipoMultimedia(TipoMultimedia tipoMultimedia) {
		this.tipoMultimedia = tipoMultimedia;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

    
   
	/* toString(), equals() y hashCode() para ElementoMultimeda, utilizando la identidad natural del objeto */

    @Override
    public String toString() {
        return "[" + tipoMultimedia.getDescripcion() + "] " + url;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        ElementoMultimedia other = (ElementoMultimedia) obj;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }
    
    
}
