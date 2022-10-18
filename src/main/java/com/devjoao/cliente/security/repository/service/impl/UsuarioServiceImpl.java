package com.devjoao.cliente.security.repository.service.impl;

import com.devjoao.cliente.security.entities.Usuario;
import com.devjoao.cliente.security.repository.UsuarioRepository;
import com.devjoao.cliente.security.repository.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
