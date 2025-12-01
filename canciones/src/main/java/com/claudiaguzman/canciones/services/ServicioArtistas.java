package com.claudiaguzman.canciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiaguzman.canciones.models.Artista;
import com.claudiaguzman.canciones.repositories.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorioArtistas;

    public List<Artista> obtenerTodosLosArtistas() {
        return repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaPorId(Long id) {
        return repositorioArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista) {
        return repositorioArtistas.save(artista);
    }
}