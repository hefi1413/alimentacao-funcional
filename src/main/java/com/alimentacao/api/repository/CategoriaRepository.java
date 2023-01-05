package com.alimentacao.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alimentacao.api.domain.Sinonimos;


public interface CategoriaRepository extends JpaRepository<Sinonimos, Long> {

}
