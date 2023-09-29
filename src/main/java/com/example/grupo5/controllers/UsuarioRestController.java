package com.example.grupo5.controllers;

import com.example.grupo5.models.Usuario;
import com.example.grupo5.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaDeUsuarios() {
        List<Usuario> listaMostrar = usuarioService.ListaDeUsuarios();
        return listaMostrar;
    }

    @PostMapping("/nuevo")
    public Usuario crearUsuario(@RequestBody Usuario usuarioNuevo) {
        return usuarioService.guardarUsuario(usuarioNuevo);
    }

    @PutMapping("/editar")
    public Usuario editarUsuarioPorId(@RequestParam Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id, usuarioActualizado);
        return usuarioEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarUsuarioPorId(@RequestParam Long id) {
        usuarioService.borrarUsuario(id);
        return "El usuario ha sido borrado.";
    }
}
