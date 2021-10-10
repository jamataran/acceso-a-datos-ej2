package com.cev.prueba.prueba.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PELICULA")
public class Pelicula {

	@ManyToMany
	@JsonIgnoreProperties(value = {"cines", "peliculas"}, allowSetters = true)
	public List<Cine> cines;
	@OneToMany(mappedBy = "peliculas")
	@JsonIgnoreProperties(value = {"reviews", "peliculas"}, allowSetters = true)
	public List<Review> reviews;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "PUNTUACION")
	private long puntuacion;
	@Column(name = "SINOPSIS")
	@Length(min = 10, max = 2000)
	private String sinopsis;
	@Column(name = "DIRECTOR")
	private String director;
	@Column(name = "FECHA_ESTRENO")
	private Date fechaEstreno;

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

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public List<Cine> getCines() {
		return cines;
	}

	public void setCines(List<Cine> cines) {
		this.cines = cines;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pelicula)) return false;
		Pelicula pelicula = (Pelicula) o;
		return id == pelicula.id && puntuacion == pelicula.puntuacion && Objects.equals(titulo, pelicula.titulo) && Objects.equals(sinopsis, pelicula.sinopsis) && Objects.equals(director, pelicula.director) && Objects.equals(fechaEstreno, pelicula.fechaEstreno) && Objects.equals(cines, pelicula.cines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo, puntuacion, sinopsis, director, fechaEstreno, cines);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Pelicula.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("titulo='" + titulo + "'")
				.add("puntuacion=" + puntuacion)
				.add("sinopsis='" + sinopsis + "'")
				.add("director='" + director + "'")
				.add("fechaEstreno=" + fechaEstreno)
				.toString();
	}

}
