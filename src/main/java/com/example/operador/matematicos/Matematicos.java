package com.example.operador.matematicos;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.model.Persona;
import com.example.operador.creacion.Creacion;

import reactor.core.publisher.Flux;

public class Matematicos {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Creacion.class);
	
	public void promedio() {
		List<Persona> personas = new ArrayList<>();
	
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).collect(Collectors.averagingInt(p->p.getEdad()))
		.subscribe(p-> log.info(p.toString()));
	}
	
	public void minimo() {
		List<Persona> personas = new ArrayList<>();
	
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
       
		Flux.fromIterable(personas).collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
		.subscribe(p-> log.info(p.toString()));
		
		Flux.fromIterable(personas).collect(Collectors.minBy(Comparator.comparing(p->p.getEdad())))
		.subscribe(p-> log.info(p.toString()));
		
	}
	
	public void count() {
		List<Persona> personas = new ArrayList<>();
	
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).count().subscribe(p-> log.info(p.toString()));

	}
	
	
}
