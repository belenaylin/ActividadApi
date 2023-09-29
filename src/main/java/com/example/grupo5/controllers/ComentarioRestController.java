package com.example.grupo5.controllers;

import com.example.grupo5.models.Comentarios;
import com.example.grupo5.services.ComentarioService;
import com.example.grupo5.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioRestController{

    @Autowired
    ComentarioServiceImpl comentarioService;

    @GetMapping("/lista")
    public List<Comentarios> listaDeComentarios(){
        List<Comentarios> listaComentarios = comentarioService.listaDeComentarios();
        return listaComentarios;
    }

    @PostMapping("/nuevo")
    public  Comentarios crearComentarios(@RequestBody Comentarios comentarioNuevo) {
        return comentarioService.guardarComentarios(comentarioNuevo);
    }

    @PutMapping("/editar")
    public Comentarios editarComentarioPorId(@RequestParam Long id, @RequestBody Comentarios comentarioActualizado){
        Comentarios comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizado);
        return comentarioEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarComentarioPorId(@RequestParam Long id) {
        comentarioService.borrarComentario(id);
        return  "El comentario ha sido borrado.";
    }
}

