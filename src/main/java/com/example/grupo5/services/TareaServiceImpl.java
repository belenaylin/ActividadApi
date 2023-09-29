package com.example.grupo5.services;

import com.example.grupo5.models.Tarea;
import com.example.grupo5.models.Tarea;
import com.example.grupo5.repositories.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class TareaServiceImpl implements TareaService {

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public List<Tarea> listaDeTareas() {

        return tareaRepository.findAll();
    }

    @Override
    public Tarea guardarTarea(Tarea tareaNueva) {
        return tareaRepository.save(tareaNueva);
    }

    @Override
    public void borrarTarea(long id) {

    }

    @Override
    public Tarea editarTareaPorId(Long id, Tarea tareaActualizada) {
        Boolean existe = tareaRepository.existsById(id);
        if (existe) {
            Tarea tareaSelecccionado = tareaRepository.findById(id).get();
            tareaSelecccionado.setTareaTitulo(tareaActualizada.getTareaTitulo());
            tareaSelecccionado.setTareaDescripcion(tareaActualizada.getTareaDescripcion());
            tareaSelecccionado.setTareaFechaDeVencimiento(tareaActualizada.getTareaFechaDeVencimiento());
            return tareaRepository.save(tareaSelecccionado);
        } else {
            System.out.println("El tarea no existe o el ID es incorrecto.");
            return null;
        }
    }
}
