package com.cev.prueba.prueba.domain;

import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "REVIEW")
public class Review {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "PUNTUACION")
    private long puntuacion;

    @Column(name = "REVIEW_TEXT")
    @Length(min = 10, max = 2000)
    private String review;

    @ManyToOne
    @JsonIgnoreProperties(value = {"reviews"}, allowSetters = true)
    private Pelicula peliculas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Pelicula getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula peliculas) {
        this.peliculas = peliculas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review1 = (Review) o;
        return id == review1.id && puntuacion == review1.puntuacion && Objects.equals(titulo, review1.titulo) && Objects.equals(review, review1.review) && Objects.equals(peliculas, review1.peliculas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, puntuacion, review, peliculas);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Review.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("titulo='" + titulo + "'")
                .add("puntuacion=" + puntuacion)
                .toString();
    }
}
