package com.crudbasico.app.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clubes")
public class Clubes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    private Entrenadores entrenador;

    @OneToMany
    @JoinColumn(name = "club_id")
    private List<Jugadores> jugadores;

    @ManyToOne
    private Asociaciones asociacion;

    @ManyToMany
    private List<Competiciones> competiciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenadores getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenadores entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Asociaciones getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociaciones asociacion) {
        this.asociacion = asociacion;
    }

    public List<Competiciones> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competiciones> competiciones) {
        this.competiciones = competiciones;
    }
}