package com.crudbasico.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.entity.Competiciones;

public interface CompeticionesRepository extends JpaRepository<Competiciones, Long> {

}