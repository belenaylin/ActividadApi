package com.example.grupo5.controllers;

import com.example.grupo5.models.Tarea;
import com.example.grupo5.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {

    @Autowired
    TareaServiceImpl tareaService;

    @GetMapping("/lista")
    public List<Tarea> listaDeTarea(){
        List<Tarea> listaMostrar = tareaService.listaDeTareas();
        return  listaMostrar;
    }

    @PostMapping("/nuevo")
    public Tarea crearTarea(@RequestBody Tarea tareaNueva) {
        return  tareaService.guardarTarea(tareaNueva);
    }

    @PutMapping("/editar")
    public Tarea editarTareaPorId(@RequestParam Long id, @RequestBody Tarea tareaActualizada){
        Tarea tareaEditado = tareaService.editarTareaPorId(id, tareaActualizada);
        return  tareaEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarTareaPorId(@RequestParam Long id) {
        tareaService.borrarTarea(id);
        return  "La tarea ha sido borrada.";
    }

}