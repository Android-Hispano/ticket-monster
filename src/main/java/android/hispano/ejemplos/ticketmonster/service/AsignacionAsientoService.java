package android.hispano.ejemplos.ticketmonster.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import android.hispano.ejemplos.ticketmonster.model.Asiento;
import android.hispano.ejemplos.ticketmonster.model.AsignacionSeccion;
import android.hispano.ejemplos.ticketmonster.model.Espectaculo;
import android.hispano.ejemplos.ticketmonster.model.ExceptionAsignacionAsiento;
import android.hispano.ejemplos.ticketmonster.model.Seccion;


/**
 * @author Marius Bogoevici
 * @translate Javier Hdez
 */
@SuppressWarnings("serial")
public class AsignacionAsientoService implements Serializable {

    @Inject
    EntityManager entityManager;

    public AsientosAsignados asignacionAsientos(Seccion seccion, Espectaculo espectaculo, int numeroAsiento, boolean contiguo) {
        AsignacionSeccion asignacionSeccion = recuperaExclusivamenteAsignacionSeccion(seccion, espectaculo);
        List<Asiento> asientos = asignacionSeccion.repartoAsientos(numeroAsiento, contiguo);
        return new AsientosAsignados(asignacionSeccion, asientos);
    }

    public void desasignarAsientos(Seccion seccion, Espectaculo espectaculo, List<Asiento> asientos) {
        AsignacionSeccion asignacionSeccion = recuperaExclusivamenteAsignacionSeccion(seccion, espectaculo);
        for (Asiento asiento : asientos) {
            if (!asiento.getSeccion().equals(seccion)) {
                throw new ExceptionAsignacionAsiento("Todos los asientos deben estar en la misma sección!");
            }
            asignacionSeccion.desasignar(asiento);
        }
    }

    private AsignacionSeccion recuperaExclusivamenteAsignacionSeccion(Seccion seccion, Espectaculo espectaculo) {
        AsignacionSeccion estadoAsignacionSeccion = (AsignacionSeccion) entityManager.createQuery(
													"select s from AsignacionSeccion where " +
													"s.espectaculo.id = :performanceId and " +
													"s.seccion.id = :sectionId")
													.setParameter("performanceId", espectaculo.getId())
													.setParameter("sectionId", seccion.getId())
													.getSingleResult();
        entityManager.lock(estadoAsignacionSeccion, LockModeType.PESSIMISTIC_WRITE);
        return estadoAsignacionSeccion;
    }
}
