package com.devjoao.cliente.controller;


import com.devjoao.cliente.domain.entity.CadastroProfessor;
import com.devjoao.cliente.service.CadastroProfessorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "cadastroProfessor/v2")
public class CadastroProfessorController {

    @Autowired
    private CadastroProfessorService cadastroProfessorService;

    @GetMapping
    public List<ResponseEntity<CadastroProfessor>> findAll() {

        List<CadastroProfessor> listaCliente = cadastroProfessorService.findAll();

        return (List<ResponseEntity<CadastroProfessor>>) ResponseEntity.ok().body(listaCliente);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroProfessor> findById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok().body(cadastroProfessorService.findById(id).get());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(CadastroProfessor.builder().build());

        }
    }
}
