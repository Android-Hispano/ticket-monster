package android.hispano.ejemplos.ticketmonster.service;

import java.util.List;

import android.hispano.ejemplos.ticketmonster.model.Asiento;
import android.hispano.ejemplos.ticketmonster.model.AsignacionSeccion;


/**
 * Un objeto transitorio que representa una colección de asientos pre-asignados
 *
 * @author Marius Bogoevici
 * @translate Javier Hdez
 */
public class AsientosAsignados {

    private final AsignacionSeccion asignacionSeccion;

    private final List<Asiento> asientos;

    public AsientosAsignados(AsignacionSeccion asignacionSeccion, List<Asiento> asientos) {
        this.asignacionSeccion = asignacionSeccion;
        this.asientos = asientos;
    }

    public AsignacionSeccion getAsignacionSeccion() {
        return asignacionSeccion;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void marcaOcupado() {
        asignacionSeccion.marcaOcupado(asientos);
    }
}