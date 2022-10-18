package com.devjoao.cliente.service;

import com.devjoao.cliente.domain.entity.CadastroProfessor;
import com.devjoao.cliente.repositories.CadastroProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroProfessorService {

    @Autowired
    private CadastroProfessorRepository cadastroProfessorRepository;


    public List<CadastroProfessor> findAll() {
        return cadastroProfessorRepository.findAll();
    }

    public Optional<CadastroProfessor> findById(Long id) {
        return cadastroProfessorRepository.findById(id);
    }
}
