package com.crudbasico.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crudbasico.app.entity.*;
import com.crudbasico.app.repository.*;

@Controller
@RequestMapping("/clubes")
public class ClubesController {

    @Autowired
    private ClubesRepository clubesRepository;

    @Autowired
    private EntrenadoresRepository entrenadoresRepository;

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @Autowired
    private AsociacionesRepository asociacionesRepository;

    @Autowired
    private CompeticionesRepository competicionesRepository;

    // LISTAR CLUBES
    @GetMapping
    public String listarClubes(Model model) {
        model.addAttribute("clubes", clubesRepository.findAll());
        return "clubes";
    }

    // MOSTRAR FORMULARIO
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("club", new Clubes());

        model.addAttribute("entrenadores",
                entrenadoresRepository.findAll());

        model.addAttribute("jugadores",
                jugadoresRepository.findAll());

        model.addAttribute("asociaciones",
                asociacionesRepository.findAll());

        model.addAttribute("competiciones",
                competicionesRepository.findAll());

        return "formClub";
    }

    // GUARDAR CLUB
    @PostMapping("/guardar")
    public String guardarClub(@ModelAttribute Clubes club) {

        clubesRepository.save(club);

        return "redirect:/clubes";
    }

    // VER DETALLE
    @GetMapping("/{id}")
    public String verDetalle(
            @PathVariable Long id,
            Model model) {

        Clubes club =
                clubesRepository.findById(id).orElse(null);

        model.addAttribute("club", club);

        return "detalleClub";
    }
}