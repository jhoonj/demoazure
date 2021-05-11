package com.example.operador.filtrado;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.azure.model.Persona;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Flux;

public class Filtrado {
	private static final Logger log = (Logger) LoggerFactory.getLogger(Filtrado.class);
	
	public void filter() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).filter(p -> p.getEdad() == 28).subscribe(p -> log.info("persona "+p));
		
	}
	
	
	public void disticnt() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (1,"ana ",29));
		
		Flux.fromIterable(personas).distinct().subscribe(p -> log.info("persona "+p));
		
	}

	
	
	public void take() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).take(2).subscribe(p -> log.info("persona "+p));
		
		Flux.fromIterable(personas).takeLast(2).subscribe(p -> log.info("persona "+p));
		
	}

	public void skip() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).skip(2).subscribe(p -> log.info("persona "+p));
		
		Flux.fromIterable(personas).skipLast(2).subscribe(p -> log.info("persona "+p));
		
	}
	
}
