package com.claudiaguzman.canciones.repositories;

import org.springframework.stereotype.Repository;

import com.claudiaguzman.canciones.models.Cancion;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface RepositorioCanciones extends CrudRepository <Cancion, Long>{
    List<Cancion> findAll();
}
