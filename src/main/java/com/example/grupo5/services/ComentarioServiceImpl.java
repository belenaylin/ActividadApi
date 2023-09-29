package com.example.grupo5.services;


import com.example.grupo5.models.Comentarios;
import com.example.grupo5.repositories.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService{


    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public List<Comentarios> listaDeComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentarios guardarComentarios(Comentarios comentarioNuevo) {
        return comentarioRepository.save(comentarioNuevo);
    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);

    }

    public Comentarios editarComentarioPorId(Long id, Comentarios comentarioActualizado) {
        Boolean existe = comentarioRepository.existsById(id);
        if (existe) {
            Comentarios comentarioSelecionado = comentarioRepository.findById(id).get();
            comentarioSelecionado.setComentarioTexto(comentarioActualizado.getComentarioTexto());
            return comentarioRepository.save(comentarioSelecionado);
        } else {
            System.out.println("El comentario no existe o el ID es incorrecto");
            return null;
        }
    }
}
