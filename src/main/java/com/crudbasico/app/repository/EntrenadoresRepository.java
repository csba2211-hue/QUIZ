package com.crudbasico.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.entity.Entrenadores;

public interface EntrenadoresRepository extends JpaRepository<Entrenadores, Long> {

}