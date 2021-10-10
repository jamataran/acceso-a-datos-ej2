package com.cev.prueba.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cev.prueba.prueba.domain.Pelicula;

@Repository
public interface PeliculasRepository extends PagingAndSortingRepository<Pelicula, Long> {

    @Query(value = "SELECT * FROM \"PELICULA\" WHERE ID IN (SELECT \"PELICULAS_ID\" FROM (select sum(\"PUNTUACION\") as SUM, \"PELICULAS_ID\" from \"REVIEW\" group by \"PELICULAS_ID\" order by SUM desc));", nativeQuery = true)
    List<Pelicula> buscarOrdenadasPorSumaDeReview();

}
