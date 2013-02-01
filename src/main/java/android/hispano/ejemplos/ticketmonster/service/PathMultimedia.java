package android.hispano.ejemplos.ticketmonster.service;

import android.hispano.ejemplos.ticketmonster.model.TipoMultimedia;

public class PathMultimedia {
    
    private final String url;
    private final boolean cached;
    private final TipoMultimedia tipoMultimedia;
    
    public PathMultimedia(String url, boolean cached, TipoMultimedia tipoMultimedia) {
        this.url = url;
        this.cached = cached;
        this.tipoMultimedia = tipoMultimedia;
    }
    
    public String getUrl() {
        return url;
    }
    
    public boolean isCached() {
        return cached;
    }

	public TipoMultimedia getTipoMultimedia() {
		return tipoMultimedia;
	}
}
