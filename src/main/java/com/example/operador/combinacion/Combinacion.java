package com.example.operador.combinacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.azure.model.Persona;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Flux;

public class Combinacion {
	
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(Combinacion.class);
	
	public void merge() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		
		List<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona (4,"jhon",28));
		personas2.add(new Persona (5,"juan ",28));
		personas2.add(new Persona (6,"ana ",29));

		Flux<Persona> fx =Flux.fromIterable(personas);
		Flux<Persona> fx2 =Flux.fromIterable(personas2);
 		
		Flux.merge(fx, fx2).subscribe(p-> log.info(p.toString()));
		
		
		
	}

}
