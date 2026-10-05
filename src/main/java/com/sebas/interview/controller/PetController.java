package com.sebas.interview.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.interview.dto.PetDto;
import com.sebas.interview.dto.PetResponse;
import com.sebas.interview.service.PetService;



@RestController 
@RequestMapping ("api/pet")
public class PetController {

    private PetService service;

    public PetController(PetService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable int id) {

        PetDto dto = service.getPetById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PetResponse> createPet(@RequestBody PetDto request) {
        
        PetResponse response = service.createPet(request);
        
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(response);
    }
    
    
    
}
