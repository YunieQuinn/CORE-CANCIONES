package com.claudiaguzman.canciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.claudiaguzman.canciones.models.Artista;
import com.claudiaguzman.canciones.services.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo) {
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
        return "artistas.jsp"; 
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model modelo) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        if (artista == null) {
            return "redirect:/artistas";
        }
        modelo.addAttribute("artista", artista);
        return "detalleArtista.jsp"; 
    }

    // Formulario para agregar artista
    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista.jsp"; 
    }

    // Procesar agregar artista
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult resultadoValidacion) {
        if (resultadoValidacion.hasErrors()) {
            return "agregarArtista.jsp";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}
