package com.example.operador.creacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.azure.model.Persona;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Creacion.class);
	
	public void justFrom() {
		Mono.just(new Persona(1,"jhon",25));		
	}
	
	public void empty() {
		Mono.empty();
		Flux.empty();
	}
	
	public void range() {
		Flux.range(0,3).doOnNext(i -> log.info("i: "+i)).subscribe();
	}
	
	public void repeat() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).doOnNext(p -> {
			log.info("repeticion");
			
		} ).repeat(3).subscribe(p -> log.info("persona "+p));
		
	}
	
}
