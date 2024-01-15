package com.DI.practica10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public List<Clase> getAll() {
        return claseRepository.findAll();
    }

    @Override
    public Clase getById(int id) {
        return claseRepository.findById(id).orElse(null);
    }

    @Override
    public Clase save(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public void delete(int id) {
        claseRepository.deleteById(id);
    }
}