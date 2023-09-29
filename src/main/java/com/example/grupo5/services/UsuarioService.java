package com.example.grupo5.services;

import com.example.grupo5.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> ListaDeUsuarios();

    Usuario guardarUsuario(Usuario usuarioNuevo);

    void borrarUsuario(Long id);

    Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado);
}
