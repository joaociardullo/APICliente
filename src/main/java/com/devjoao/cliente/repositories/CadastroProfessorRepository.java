package com.devjoao.cliente.repositories;

import com.devjoao.cliente.domain.entity.CadastroProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroProfessorRepository extends JpaRepository<CadastroProfessor, Long> {

}
