package com.cev.prueba.prueba.web;


import java.util.List;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cev.prueba.prueba.domain.Pelicula;
import com.cev.prueba.prueba.repository.PeliculasRepository;

@RestController
public class PeliculasController {

    private static final Supplier<RuntimeException> PELICULA_NO_ENCONTRADA = () -> new RuntimeException("Pelicula no encontrada");
    private final Logger log = LoggerFactory.getLogger(PeliculasController.class);

    private final PeliculasRepository peliculasRepository;

    public PeliculasController(PeliculasRepository peliculasRepository) {
        this.peliculasRepository = peliculasRepository;
    }


    /**
     * Obtiene todas las peliculas
     *
     * @return Listado de peliculas
     */
    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        log.info("Obteniendo todas las peliculas");
        return (List<Pelicula>) this.peliculasRepository.findAll();
    }

    /**
     * Obtiene todas las peliculas ordenadas por mayores reviews
     *
     * @return Listado de peliculas
     */
    @GetMapping("/peliculas/ordenadas")
    public List<Pelicula> getPeliculasOrdenadas() {
        log.info("Obteniendo todas las peliculas, ordendas");
        return this.peliculasRepository.buscarOrdenadasPorSumaDeReview();
    }

    /**
     * Guarda una nueva pelicula
     *
     * @param pelicula Pelicula a guardar
     * @return Pelicula guardada.
     */
    @PostMapping("/peliculas")
    public Pelicula addPelicula(@RequestBody Pelicula pelicula) {
        log.info("Guardando nueva pelicula {}", pelicula);
        return this.peliculasRepository.save(pelicula);
    }

    /**
     * Actaulzia una pelicula
     *
     * @param pelicula Pelicula a actualizar
     * @param id       Id de la pelicula
     * @return Pelicula actualizada.
     */
    @PutMapping(path = "/peliculas/{id}")
    public Pelicula updatePelicula(@RequestBody Pelicula pelicula, @PathVariable Long id) {
        log.info("Actualizando pelicula con id {} a {}", id, pelicula);
        final Pelicula pelicula1 = this.peliculasRepository.findById(id).orElseThrow(PELICULA_NO_ENCONTRADA);
        pelicula1.setCines(pelicula.getCines());
        pelicula1.setDirector(pelicula.getDirector());
        pelicula1.setFechaEstreno(pelicula.getFechaEstreno());
        pelicula1.setSinopsis(pelicula.getSinopsis());
        pelicula1.setPuntuacion(pelicula.getPuntuacion());
        this.peliculasRepository.save(pelicula1);
        return pelicula;
    }

    @DeleteMapping(path = "/peliculas/{id}")
    public void deletePelicula(@PathVariable Long id) {
        this.peliculasRepository.delete(this.peliculasRepository.findById(id).orElseThrow(PELICULA_NO_ENCONTRADA));
    }

}
