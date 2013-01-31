package android.hispano.ejemplos.ticketmonster.model;

import javax.persistence.Embeddable;


/**
 * 
 * Una representación de una Dirección reutilizable.
 * 
 * Las direcciones son utilizadas en muchos lugares de la aplicación, así que
 * ten en cuenta el principio de DRY, modelaremos Direccion como una entidad
 * integrable. Una entidad integrable aparece como un hijo en el modelo objeto,
 * pero no se establece relación en el RDBMS...
 * 
 * @author Marius Bogoevici
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
@Embeddable
public class Direccion {

	/* Declaración de campos */
	private String calle;
	private String ciudad;
	private String pais;
	
	
	/* Declaración de Boilerplate getters y setters */
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	/* toString(), equals() y hashCode() para Direccion, utilizando la identidad natural del objeto */
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Direccion direccion = (Direccion) o;

        if (ciudad != null ? !ciudad.equals(direccion.ciudad) : direccion.ciudad != null)
            return false;
        if (pais != null ? !pais.equals(direccion.pais) : direccion.pais != null)
            return false;
        if (calle != null ? !calle.equals(direccion.calle) : direccion.calle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = calle != null ? calle.hashCode() : 0;
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return calle + ", " + ciudad + ", " + pais;
    }
	
	
}
