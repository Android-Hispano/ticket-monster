package android.hispano.ejemplos.ticketmonster.model;


/**
 * 
 * El {@link TipoMultimedia} describe el tipo multimedia que esta aplicación puede manejar y renderizar.
 * 
 * El tipo multimedia es un conjunto cerrado - cada diferente tipo multimedia necesita
 * soporte codificado dentro de la capa de la vista, esto no se puede ampliar sin volver
 * a reconstruir la aplicación. Por lo tanto esto se representa con una enumeración. 
 * 
 * 
 * El {@link TipoMultimedia} también describe si este tipo puede ser cacheado localmente, y utilizado cuando no hay conexión
 * a internet. Por ejemplo imágenes y/o un vídeo en formato mpeg puede ser cacheado, mientras que un vídeo streaming a través
 * de Internet no se puede realizar.
 * 
 * 
 * @author Pete Muir
 * @translate Javier Hdez
 * 
 */
public enum TipoMultimedia {

    /**
     * El tipo multimedia que la aplicación puede manejar actualmente. En estos momentos, solo es posible manejar imágenes.
     * Tenemos la intención de añadir streaming de vídeo más adelante.
     */
    IMAGE("Imagen", true);
    
    /**
     * Una descripción legible por un humano del tipo multimedia.
     */
    private final String descripcion;
    
    /**
     * Un flag booleano indicando si el tipo multimedia puede ser cacheado.
     */
    private final boolean cacheable;
    
    /* Boilerplate constructor y getters */

    private TipoMultimedia(String descripcion, boolean cacheable) {
        this.descripcion = descripcion;
        this.cacheable = cacheable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCacheable() {
        return cacheable;
    }

}