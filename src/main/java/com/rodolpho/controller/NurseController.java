package com.rodolpho.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolpho.payload.NurseDto;
import com.rodolpho.service.NurseService;

@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    private NurseService nurseService;

    public NurseController(NurseService nurseService){
        
        this.nurseService = nurseService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<NurseDto> createNurse(@RequestBody NurseDto nurseDto){

        return new ResponseEntity<>(nurseService.createNurse(nurseDto), HttpStatus.CREATED); //48
    }
    
}
