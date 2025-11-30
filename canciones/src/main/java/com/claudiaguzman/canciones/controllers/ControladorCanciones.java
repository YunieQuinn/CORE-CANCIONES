package com.claudiaguzman.canciones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.claudiaguzman.canciones.models.Cancion;
import com.claudiaguzman.canciones.services.ServicioCanciones;

@Controller
public class ControladorCanciones{
    @Autowired
    private ServicioCanciones servicioCanciones;

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
}
