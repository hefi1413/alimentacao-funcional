package com.alimentacao.api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.alimentacao.api.domain.Alimentos;


public interface AlimentosRepository extends JpaRepository<Alimentos, Long> {

	//busca por alimentos relacionados a doenças
	@Query("select a.*" +
			 "from alimentos a " +
			 "where a.id in ( select pa.id" +
			 "				   from principios_ativos pa, indicacoes i" +
			 "				   where pa.id = i.id )" )
	Page<Alimentos> FindByDoencasOrPrincipiosAtivos(@Param("search") String search, Pageable pageable);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("update Promocao p set p.likes = p.likes + 1 where p.id = :id")
	void updateSomarLikes(@Param("id") Long id);
}
 