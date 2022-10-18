package com.devjoao.cliente.security.repository.service;

import com.devjoao.cliente.security.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> findByEmail(String email);

    Usuario save(Usuario usuario);
}
