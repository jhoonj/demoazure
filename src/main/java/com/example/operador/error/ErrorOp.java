package com.example.operador.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.azure.model.Persona;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorOp {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(ErrorOp.class);
	
	public void retry() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("este es mi error")))
		.doOnNext(x -> log.info(x.toString()))
		.retry(3).subscribe();
		
	}
	
	
	public void errorReturn() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("este es mi error")))
		.onErrorReturn(new Persona (9999,"xxxxxxxxxx",9999)).subscribe(y -> log.info(y.toString()));
		
	}
	
	public void errorResume() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("este es mi error")))
		.onErrorResume(y -> Mono.just(new Persona (9999,"xxxxxxxxxx",9999))).subscribe(y -> log.info(y.toString()));
		
	}
	
	
	public void errorMap() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		
		Flux.fromIterable(personas)
		.concatWith(Flux.error(new RuntimeException("este es mi error")))
		.onErrorMap(y -> new RuntimeException("este es mi otro error")).subscribe(y -> log.info(y.toString()));
		
	}

}
