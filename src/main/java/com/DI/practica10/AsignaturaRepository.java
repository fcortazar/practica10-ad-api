package com.DI.practica10;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    List<Asignatura> findByNombre(String nombre);
}