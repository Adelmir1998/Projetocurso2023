package com.projeto.spring.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.spring.curso.domain.Sala;

public interface SalaRepository extends JpaRepository<Sala,Long> {

}
