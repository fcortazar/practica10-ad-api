package com.DI.practica10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    // GET: Obtener todas las asignaturas
    @GetMapping
    public ResponseEntity<List<Asignatura>> getAllAsignaturas() {
        List<Asignatura> asignaturas = asignaturaService.getAll();
        return new ResponseEntity<>(asignaturas, HttpStatus.OK);
    }

    // GET: Obtener una asignatura por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable int id) {
        Asignatura asignatura = asignaturaService.getById(id);
        if (asignatura != null) {
            return new ResponseEntity<>(asignatura, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: Crear una nueva asignatura
    @PostMapping
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura nuevaAsignatura = asignaturaService.save(asignatura);
        return new ResponseEntity<>(nuevaAsignatura, HttpStatus.CREATED);
    }

    // PUT: Actualizar una asignatura existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable int id, @RequestBody Asignatura asignatura) {
        Asignatura existente = asignaturaService.getById(id);

        if (existente != null) {
            asignatura.setId(id);
            Asignatura actualizada = asignaturaService.save(asignatura);
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Eliminar una asignatura por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable int id) {
        Asignatura existente = asignaturaService.getById(id);

        if (existente != null) {
            asignaturaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}