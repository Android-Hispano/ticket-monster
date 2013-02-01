package android.hispano.ejemplos.ticketmonster.monitor.client.shared;
/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import android.hispano.ejemplos.ticketmonster.model.Espectaculo;


/**
 * Un servicio utilizado por el monitor de reservas para recuperar información de estado.
 * 
 * La anotacion Errai @Remote indica que la implementacion del Service puede ser
 * utilizada como un endpoint RPC y que esta interfaz puede ser utilizada sobre
 * el cliente para invocar el tipo de método seguro sobre este endpoint.
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 * @translate Javier Hdez
 */
@Remote
public interface MonitorReservaService {
  
    /**
     * Lista todos los {@link Espectaculo} activos (espectáculos con actuaciones futuras). 
     * 
     * @return una lista de espectáculos encontrados.
     */
    public List<Espectaculo> recuperaEspectaculos();
    
    /**
     * Construye un mapa de IDs de actuaciones para el número total de entradas vendidas.
     * 
     * @return un mapa de IDs de espectáculos para el número total de entradas vendidas.
     */
    public Map<Long, Long> recuperaNumerosOcupados(); 
}
