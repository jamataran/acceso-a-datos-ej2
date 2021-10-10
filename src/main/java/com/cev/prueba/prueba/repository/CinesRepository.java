package com.cev.prueba.prueba.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cev.prueba.prueba.domain.Cine;

@Repository
public interface CinesRepository extends PagingAndSortingRepository<Cine, Long> {

    /**
     * Consulta a)
     * Teniendo una película determinada, (por ejemplo Django Desencadenado) queremos obtener la siguiente información:
     * Cines en los que se proyecta ordenados por precio, de más barato a más caro.
     *
     * @return Lista de cines
     */
    List<Cine> findAllByPeliculasTitulo_OrderByPrecioEntradaAsc(String p);

    /**
     * Consulta b)
     * Teniendo una película determinada, (por ejemplo Django Desencadenado) queremos obtener la siguiente información:
     * Cines en los que se proyecta con un determinado código postal.
     *
     * @param tituloPelicula Titulo Pelicula
     * @param codigoPostal   Codigo postal
     * @return Listado de cines
     */
    List<Cine> findAllByPeliculasTituloAndCodigoPostal_OrderById(String tituloPelicula, String codigoPostal);


}
