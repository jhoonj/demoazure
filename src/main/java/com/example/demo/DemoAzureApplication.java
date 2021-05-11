package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.model.Persona;
import com.example.operador.condicional.Condicional;
import com.example.operador.error.ErrorOp;
import com.example.operador.matematicos.Matematicos;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoAzureApplication implements CommandLineRunner {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(DemoAzureApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoAzureApplication.class, args);
	}
	
	public void reactor() {
		Mono.just(new Persona(1,"MITO",26))
		.doOnNext(p -> {
			p.setIdPersona(8028578);
			
		} )
		.subscribe(p -> log.info("persona "+p) );
	}
	
	public void mono() {
		Mono.just(new Persona(1,"MITO",26))
		.doOnNext(p -> {
			p.setIdPersona(8028578);
			
		} )
		.subscribe(p -> log.info("persona "+p) );
	}
	
	public void flux() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",27));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		Flux.fromIterable(personas).doOnNext(p -> {
			p.setIdPersona(8028578);
			
		} ).subscribe(p -> log.info("persona "+p));
		
			
	}

	
	public void fluxMono() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona (1,"jhon",28));
		personas.add(new Persona (2,"juan ",28));
		personas.add(new Persona (3,"ana ",29));
		Flux<Persona> fx = Flux.fromIterable(personas);
		fx.collectList().subscribe(lista -> log.info(lista.toString()));
		
			
	}
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("metodo reactor");
//		reactor();
//		// TODO Auto-generated method stub
//		System.out.println("metodo mono");
//		mono();
//		System.out.println("metodo flux");
//		flux();
//		System.out.println("metodo flux mono");
//		fluxMono();
//		

//		Creacion app = new Creacion();
//		app.repeat();
		
//		Transformacion app = new Transformacion();
//		System.out.println("metodo map");
//		app.map();
//		
//		
//		System.out.println("metodo do on next");
//		app.doonnext();
//		
//		System.out.println("metodo do group by");
//		app.groupby();
//		
		
		//Filtrado app = new Filtrado();
		//app.disticnt();
		
		//app.skip();
		
	//	Combinacion app = new Combinacion();
	//	app.merge();
		
//		ErrorOp app = new ErrorOp();
//		app.errorReturn();
//		
//		app.errorResume();
		
		//Condicional app = new Condicional();
		//app.defaultIsEmpty();
		//app.timeout();
		
		Matematicos app = new Matematicos();
		app.promedio();
		app.count();
		app.minimo();
		
		
	}

}
