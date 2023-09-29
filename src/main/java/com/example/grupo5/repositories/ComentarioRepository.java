package com.example.grupo5.repositories;

import com.example.grupo5.models.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentarios, Long> {

}