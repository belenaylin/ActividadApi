package com.example.grupo5.services;

import com.example.grupo5.models.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> listaDeTareas();

    Tarea guardarTarea(Tarea tareaNueva);

    void borrarTarea(long id);

    Tarea editarTareaPorId(Long id, Tarea tareaActualizada);
}
