package com.claudiaguzman.canciones.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;

    @NotBlank(message = "El artista es obligatorio")
    @Size(min = 3, message = "El artista debe tener al menos 3 caracteres")
    private String artista;

    @NotBlank(message = "El álbum es obligatorio")
    @Size(min = 3, message = "El álbum debe tener al menos 3 caracteres")
    private String album;

    @NotBlank(message = "El género es obligatorio")
    @Size(min = 3, message = "El género debe tener al menos 3 caracteres")
    private String genero;

    @NotBlank(message = "El idioma es obligatorio")
    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres")
    private String idioma;


    @CreationTimestamp
    @Column(name="fecha_creacion", updatable=false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Cancion(){

    }

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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
    return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    

}
