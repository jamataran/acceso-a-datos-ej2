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

import com.cev.prueba.prueba.domain.Cine;
import com.cev.prueba.prueba.repository.CinesRepository;

@RestController
public class CineController {

    private static final Supplier<RuntimeException> CINE_NO_ENCONTRADO = () -> new RuntimeException("Cine no encontrado");
    private final Logger log = LoggerFactory.getLogger(CineController.class);

    private final CinesRepository cinesRepository;

    public CineController(CinesRepository cinesRepository) {
        this.cinesRepository = cinesRepository;
    }

    @GetMapping("/cines")
    public List<Cine> getAll() {
        log.info("Obteniendo cines");
        return (List<Cine>) cinesRepository.findAll();
    }

    @PostMapping("/cines")
    public Cine addCine(@RequestBody Cine cine) {
        log.info("Guardando cine {}", cine);
        return cinesRepository.save(cine);
    }

    @PutMapping(path = "/cines/{id}")
    public Cine updateCine(@RequestBody Cine cine, @PathVariable Long id) {
        log.info("Actualizando cine con id {}. Datos {}", id, cine);
        Cine cineGuardado = cinesRepository.findById(id).orElseThrow(CINE_NO_ENCONTRADO);
        cineGuardado.setNombre(cine.getNombre());
        cineGuardado.setPoblacion(cine.getPoblacion());
        cineGuardado.setCodigoPostal(cine.getCodigoPostal());
        cineGuardado.setProvincia(cine.getProvincia());
        cineGuardado.setPrecioEntrada(cine.getPrecioEntrada());
        cinesRepository.save(cineGuardado);
        return cine;
    }

    @DeleteMapping(path = "/cines/{id}")
    public void deleteCine(@PathVariable Long id) {
        cinesRepository.delete(cinesRepository.findById(id).orElseThrow(CINE_NO_ENCONTRADO));
    }

    /**
     * Cines en los que se proyecta ordenados por precio, de más barato a más caro.
     *
     * @param pelicula Nombre de la pelicula
     * @return Lista de Cines
     */
    @GetMapping(path = "/cines/pelicula/{titulo}")
    public List<Cine> getByPelicula(@PathVariable("titulo") String pelicula) {
        return cinesRepository.findAllByPeliculasTitulo_OrderByPrecioEntradaAsc(pelicula);
    }

    /**
     * Cines en los que se proyecta ordenados por precio, de más barato a más caro.
     *
     * @param pelicula Nombre de la pelicula
     * @return Lista de Cines
     */
    @GetMapping(path = "/cines/pelicula/{titulo}/cp/{cp}")
    public List<Cine> getByPeliculaAndCP(@PathVariable("titulo") String pelicula, @PathVariable("cp") String cp) {
        return cinesRepository.findAllByPeliculasTituloAndCodigoPostal_OrderById(pelicula, cp);
    }

}
