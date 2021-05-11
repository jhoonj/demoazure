package com.example.operador.condicional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class Condicional {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(Condicional.class);
	
	public void defaultIsEmpty() {
		Mono.just("casa").defaultIfEmpty("burro").subscribe(x-> log.info(x.toString()));
		Mono.empty().defaultIfEmpty("burro").subscribe(x-> log.info(x.toString()));
	}
	
	public void timeout() throws InterruptedException {
		List<Persona> personas = new ArrayList<>();
	
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas).delayElements(Duration.ofSeconds(1))
		.timeout(Duration.ofSeconds(5))
		.subscribe(p -> log.info(p.toString()));
		
		Thread.sleep(10000);
	}	
		

}
