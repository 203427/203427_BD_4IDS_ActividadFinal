package com.example.lorenzo.controller;


import com.example.lorenzo.modelo.Duenio;
import com.example.lorenzo.service.DuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/duenio")
@CrossOrigin("*")
public class ControladorDuenio {

    @Autowired
private DuenioService duenioService;

//listar
@GetMapping("/listar")
public  List <Duenio> readAll() {
    List<Duenio> duenios = StreamSupport.stream(duenioService.findAll().spliterator(), false)
            .collect(Collectors.toList());

    return duenios;

}

//Agregar registro
@PostMapping("/add")
public ResponseEntity<?> create(@RequestBody Duenio duenio){
    return ResponseEntity.status(HttpStatus.CREATED).body(duenioService.save(duenio));
}

    //Encontrar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id")Integer idDuenio){
        Optional<Duenio> oTipo = duenioService.findById(idDuenio);
        if(!oTipo.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oTipo);
    }

//Actualizar un registro
@PutMapping("/update/{id}")
public ResponseEntity<?> update(@RequestBody Duenio duenioDetails, @PathVariable(value = "id")Integer idDuenio){
    Optional<Duenio> tipo =duenioService.findById(idDuenio);
    if(!tipo.isPresent()){
        return ResponseEntity.notFound().build();
    }
    tipo.get().setNombreDuenio(duenioDetails.getNombreDuenio());
    tipo.get().setTelefonoDuenio(duenioDetails.getTelefonoDuenio());
    tipo.get().setDireccionDuenio(duenioDetails.getDireccionDuenio());

    return ResponseEntity.status(HttpStatus.CREATED).body(duenioService.save(tipo.get()));
}


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer idDuenio){
        if(!duenioService.findById(idDuenio).isPresent()){
            return  ResponseEntity.notFound().build();
        }
        duenioService.deletedById(idDuenio);
        return ResponseEntity.ok().build();
    }


}
