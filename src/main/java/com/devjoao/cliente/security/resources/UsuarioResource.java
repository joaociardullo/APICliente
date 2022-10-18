package com.devjoao.cliente.security.resources;


import com.devjoao.cliente.security.entities.Usuario;
import com.devjoao.cliente.security.request.UserRequest;
import com.devjoao.cliente.security.request.UsuarioJwtRequest;
import com.devjoao.cliente.security.response.UserResponse;
import com.devjoao.cliente.security.response.UsuarioJwtResponse;
import com.devjoao.cliente.security.repository.service.impl.UserDetailServiceImpl;
import com.devjoao.cliente.security.repository.service.UsuarioService;
import com.devjoao.cliente.security.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    public UserResponse save(@RequestBody @Valid UserRequest userRequest){

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(userRequest, usuario);
        usuario.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        usuarioService.save(usuario);
        log.info("Usuario cadastrado com sucesso: {}", usuario );

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(usuario, userResponse);

        return userResponse;
    }

    @PostMapping("/autenticacao")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioJwtResponse getAutenticacao(@RequestBody UsuarioJwtRequest usuarioJwtRequest){
        try{
            UserDetails userDetails = userDetailServiceImpl.autenticar(usuarioJwtRequest);
            String token = jwtUtil.obterToken(usuarioJwtRequest);
            return  UsuarioJwtResponse.builder()
                    .email(userDetails.getUsername())
                    .token(token)
                    .build();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }



}