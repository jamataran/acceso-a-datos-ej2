package com.cev.prueba.prueba.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CINE")
public class Cine {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "POBLACION")
    private String poblacion;

    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "PRECIO_ENTRADA")
    private Double precioEntrada;

    @ManyToMany(mappedBy = "cines")
    @JsonIgnoreProperties(value = {"cines"}, allowSetters = true)
    private List<Pelicula> peliculas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cine)) return false;
        Cine cine = (Cine) o;
        return id == cine.id && Objects.equals(nombre, cine.nombre) && Objects.equals(poblacion, cine.poblacion) && Objects.equals(codigoPostal, cine.codigoPostal) && Objects.equals(provincia, cine.provincia) && Objects.equals(precioEntrada, cine.precioEntrada) && Objects.equals(peliculas, cine.peliculas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, poblacion, codigoPostal, provincia, precioEntrada, peliculas);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cine.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nombre='" + nombre + "'")
                .add("poblacion='" + poblacion + "'")
                .add("codigoPostal='" + codigoPostal + "'")
                .add("provincia='" + provincia + "'")
                .add("precioEntrada=" + precioEntrada)
                .toString();
    }
}
