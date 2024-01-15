package com.DI.practica10;

import java.util.List;

public interface AsignaturaService {
    List<Asignatura> getAll();
    Asignatura getById(int id);
    Asignatura save(Asignatura asignatura);
    void delete(int id);
}
