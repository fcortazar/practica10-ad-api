package com.DI.practica10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    // GET: Obtener todas las clases
    @GetMapping
    public ResponseEntity<List<Clase>> getAllClases() {
        List<Clase> clases = claseService.getAll();
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    // GET: Obtener una clase por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Clase> getClaseById(@PathVariable int id) {
        Clase clase = claseService.getById(id);
        if (clase != null) {
            return new ResponseEntity<>(clase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: Crear una nueva clase
    @PostMapping
    public ResponseEntity<Clase> createClase(@RequestBody Clase clase) {
        Clase nuevaClase = claseService.save(clase);
        return new ResponseEntity<>(nuevaClase, HttpStatus.CREATED);
    }

    // PUT: Actualizar una clase existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Clase> updateClase(@PathVariable int id, @RequestBody Clase clase) {
        Clase existente = claseService.getById(id);

        if (existente != null) {
            clase.setId(id);
            Clase actualizada = claseService.save(clase);
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Eliminar una clase por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable int id) {
        Clase existente = claseService.getById(id);

        if (existente != null) {
            claseService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

