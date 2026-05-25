package com.crudbasico.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudbasico.app.entity.Clubes;

public interface ClubesRepository extends JpaRepository<Clubes, Long> {

}