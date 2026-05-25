package com.crudbasico.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crudbasico.app.entity.Entrenadores;
import com.crudbasico.app.repository.EntrenadoresRepository;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadoresController {

    private final EntrenadoresRepository entrenadoresRepository;

    public EntrenadoresController(
            EntrenadoresRepository entrenadoresRepository) {

        this.entrenadoresRepository = entrenadoresRepository;
    }

    @GetMapping("/nuevo")
    public String nuevoEntrenador(Model model){

        model.addAttribute(
                "entrenador",
                new Entrenadores());

        return "formEntrenador";
    }

    @PostMapping("/guardar")
    public String guardarEntrenador(
            @ModelAttribute Entrenadores entrenador){

        entrenadoresRepository.save(entrenador);

        return "redirect:/entrenadores/lista";
    }

    @GetMapping("/lista")
    public String listarEntrenadores(Model model){

        model.addAttribute(
                "entrenadores",
                entrenadoresRepository.findAll());

        return "listaEntrenadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEntrenador(
            @PathVariable Long id){

        entrenadoresRepository.deleteById(id);

        return "redirect:/entrenadores/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarEntrenador(
            @PathVariable Long id,
            Model model){

        Entrenadores entrenador =
                entrenadoresRepository
                .findById(id)
                .orElse(null);

        model.addAttribute(
                "entrenador",
                entrenador);

        return "formEntrenador";
    }
}