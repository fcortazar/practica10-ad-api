package com.DI.practica10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> getAll() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura getById(int id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void delete(int id) {
        asignaturaRepository.deleteById(id);
    }
}
