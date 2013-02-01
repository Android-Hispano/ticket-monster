package android.hispano.ejemplos.ticketmonster.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.errai.bus.server.annotations.Service;

import android.hispano.ejemplos.ticketmonster.model.Espectaculo;
import android.hispano.ejemplos.ticketmonster.monitor.client.shared.MonitorReservaService;

/**
 * Implementación de {@link MonitorReservaService}.
 * 
 * Anotación Errai @Service que expone este servicio como un endpoint RPC.
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 * @translate Javier Hdez
 */
@ApplicationScoped 
@Service
@SuppressWarnings("unchecked")
public class MonitorReservaServiceImpl implements MonitorReservaService {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Espectaculo> recuperaEspectaculos() {
        Query showQuery = entityManager.createQuery(
            "select DISTINCT s from Espectaculo s JOIN s.actuaciones p WHERE p.date > current_timestamp");
        return showQuery.getResultList();
    }

    @Override
    public Map<Long, Long> recuperaNumerosOcupados() {
        Map <Long, Long> numerosOcupados = new HashMap<Long, Long>();
  
        Query numerosOcupadosQuery = entityManager.createQuery("" +
            		"select s.performance.id, SUM(s.occupiedCount) from AsignacionSeccion s " +
            		"WHERE s.performance.date > current_timestamp GROUP BY s.performance.id");
        
        List<Object[]> results = numerosOcupadosQuery.getResultList();
        for (Object[] result : results) {
            numerosOcupados.put((Long) result[0], (Long) result[1]); 
        }
        
        return numerosOcupados;
    }
}
