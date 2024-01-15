package com.DI.practica10;

import java.util.List;

public interface ClaseService {
    List<Clase> getAll();
    Clase getById(int id);
    Clase save(Clase clase);
    void delete(int id);
}
