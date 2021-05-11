package com.example.operador.transformacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.azure.model.Persona;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Transformacion {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(Transformacion.class);
	
	public void map() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.map(p-> {
			p.setEdad(p.getEdad()+10);
			return p;
		}).subscribe(p-> log.info(p.toString()));
		
	}

	// el retorno es otro flujo
	public void flatmap() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.flatMap(p-> {
			p.setEdad(p.getEdad()+10);
			return Mono.just(p);
		}).subscribe(p-> log.info(p.toString()));
		
	}
	

	
	public void groupby() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (1,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.groupBy(Persona::getIdPersona)
		.flatMap(idFlux -> idFlux.collectList())
		.subscribe(p-> log.info(p.toString()));
		
	}

	public void doonnext() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.doOnNext(p-> {
			p.setEdad(p.getEdad()+10);			
		}).subscribe(p-> log.info(p.toString()));
		
	}
	
}
