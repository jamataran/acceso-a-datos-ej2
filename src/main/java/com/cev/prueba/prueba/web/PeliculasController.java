package com.cev.prueba.prueba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cev.prueba.prueba.domain.Pelicula;
import com.cev.prueba.prueba.service.PeliculasService;
import com.cev.prueba.prueba.web.error.CustomError;

@RestController
public class PeliculasController {
	
	@Autowired 
	PeliculasService peliculasService;			

	@GetMapping(path = "/peliculas")
	List<Pelicula> getPeliculas(@RequestParam(required = false) String titulo, @RequestParam(required = false, name = "puntuacion.min", defaultValue = "2") int puntuacionMinima ){	
		
		if (puntuacionMinima<2) {
			throw new CustomError("La puntuacion no puede ser menor que 2");			
		}			
		if( titulo!= null) {						
			return peliculasService.buscaPorTitulo(titulo);			
		}else return peliculasService.getPeliculas();		
	}
	
	
	@GetMapping(path = "/peliculas/{id}")
	Pelicula getPeliculas(@PathVariable int id){			
		return peliculasService.getPelicula(id);		
	}
	
	@PostMapping(path = "/peliculas")
	int altaPelicula(@RequestBody Pelicula pelicula ) {				
		return peliculasService.add(pelicula);		
	}
	
	@PutMapping(path = "/peliculas/{id}")
	Pelicula modificaPelicula(@RequestBody Pelicula pelicula,@PathVariable int id) {
		peliculasService.guarda(id, pelicula);			
		return pelicula;		
	}
	
	@DeleteMapping(path="/peliculas/{id}")
	String borraPelicula(@PathVariable int id) {	
		peliculasService.borra(id);	
		return("OK");
	}
	
	@GetMapping(path = "/peliculasHeader")
	ResponseEntity<List<Pelicula>> getPeliculasHeader(){		
		HttpHeaders headers = new HttpHeaders();
		headers.add("MiHeaderRespuesta", "HeaderRespuesta");
		
		return ResponseEntity.ok().headers(headers).body(peliculasService.getPeliculas());
	}
	
	
	

}

