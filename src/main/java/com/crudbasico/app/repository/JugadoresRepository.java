package com.crudbasico.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.entity.Jugadores;

public interface JugadoresRepository extends JpaRepository<Jugadores, Long> {

}