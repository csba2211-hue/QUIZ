package com.crudbasico.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crudbasico.app.entity.Jugadores;
import com.crudbasico.app.repository.JugadoresRepository;

@Controller
@RequestMapping("/jugadores")
public class JugadoresController {

    private final JugadoresRepository jugadoresRepository;

    public JugadoresController(
            JugadoresRepository jugadoresRepository) {

        this.jugadoresRepository = jugadoresRepository;
    }

    @GetMapping("/nuevo")
    public String nuevoJugador(Model model){

        model.addAttribute(
                "jugador",
                new Jugadores());

        return "formJugador";
    }

    @PostMapping("/guardar")
    public String guardarJugador(
            @ModelAttribute Jugadores jugador){

        jugadoresRepository.save(jugador);

        return "redirect:/jugadores/lista";
    }

    @GetMapping("/lista")
    public String listarJugadores(Model model){

        model.addAttribute(
                "jugadores",
                jugadoresRepository.findAll());

        return "listaJugadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(
            @PathVariable Long id){

        jugadoresRepository.deleteById(id);

        return "redirect:/jugadores/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarJugador(
            @PathVariable Long id,
            Model model){

        Jugadores jugador =
                jugadoresRepository
                .findById(id)
                .orElse(null);

        model.addAttribute(
                "jugador",
                jugador);

        return "formJugador";
    }
}