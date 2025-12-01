package com.claudiaguzman.canciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.claudiaguzman.canciones.models.Artista;
import com.claudiaguzman.canciones.models.Cancion;
import com.claudiaguzman.canciones.services.ServicioArtistas;
import com.claudiaguzman.canciones.services.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones{
    @Autowired
    private ServicioCanciones servicioCanciones;

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        List<Cancion> lista = servicioCanciones.obtenerTodasLasCanciones();
        modelo.addAttribute("canciones", lista);
        return "canciones.jsp"; 
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion( @PathVariable("idCancion") Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion == null) {
            // si no existe, vuelve a la lista
            return "redirect:/canciones";
        }
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
    }

    // Mostrar formulario para agregar
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model modelo) {
        modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
    }

    // Procesar formulario
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult resultadoValidacion,
            @RequestParam("artistaId") Long artistaId,
            Model modelo) {

        if (resultadoValidacion.hasErrors()) {
            modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion.jsp";
        }
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        if (artista == null) {
            resultadoValidacion.rejectValue("artista", null, "Debe seleccionar un artista válido");
            modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion.jsp";
        }
        cancion.setArtista(artista);
        servicioCanciones.agregarCancion(cancion);

        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion == null) {
            return "redirect:/canciones";
        }
        modelo.addAttribute("cancion", cancion);
        modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "editarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
        @PathVariable("idCancion") Long idCancion,
        @Valid @ModelAttribute("cancion") Cancion cancion,
        BindingResult resultadoValidacion,
        @RequestParam("artistaId") Long artistaId,
        Model modelo) {

        if (resultadoValidacion.hasErrors()) {
            modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion.jsp"; 
        }
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        if (artista == null) {
            resultadoValidacion.rejectValue("artista", null, "Debe seleccionar un artista válido");
            modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion.jsp";
        }
        cancion.setId(idCancion);
        cancion.setArtista(artista);      
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
}
