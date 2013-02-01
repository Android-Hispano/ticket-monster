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

import javax.ejb.Remote;

/**
 * Un servicio utilizado para el bot.
 * 
 * La anotación Errai @Remote indica que el servicio implementado puede
 * ser utilizado como un endpoint RPC y que esta interfaz puede ser utilizada
 * sobre el cliente para el método de invocación de tipo seguro de ese endpoint.
 *
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 * @author Pete Muir
 * @translate Javier Hdez
 */
@Remote
public interface BotService {
  
    /**
     * Inicia el bot. 
     * 
     */
    public void start();
    
    /**
     * Detiene el bot.
     */
    public void stop();
    
    /**
     * Borra todas las reservas
     */
    public void deleteAll();

    /**
     * Obtiene un log para el bot
     */
    public List<String> fetchLog(); 
}
