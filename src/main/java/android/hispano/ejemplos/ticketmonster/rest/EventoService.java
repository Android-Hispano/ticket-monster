package android.hispano.ejemplos.ticketmonster.rest;


import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;

import javax.persistence.EntityManager;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import android.hispano.ejemplos.ticketmonster.model.Evento;



@Path("/eventos")

@RequestScoped

public class EventoService {

 @Inject

 private EntityManager em;

 @GET

 @Produces(MediaType.APPLICATION_JSON)

public List<Evento> getAllEvents() {

  @SuppressWarnings("unchecked")

  final List<Evento> resultados =

    em.createQuery(

      "select e from Evento e order by e.nombre").getResultList();

  return resultados;

 }

}