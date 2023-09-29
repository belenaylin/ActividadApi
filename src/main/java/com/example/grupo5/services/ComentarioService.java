package com.example.grupo5.services;

import com.example.grupo5.models.Comentarios;

import java.util.List;

public interface ComentarioService {

    List<Comentarios> listaDeComentarios();

    Comentarios guardarComentarios(Comentarios comentarioNuevo);

    void borrarComentario(Long id);

    Comentarios editarComentarioPorId(Long id, Comentarios comentarioActualizada);
}
