package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistilleryController {

    @Autowired
    private DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity getAllDistilleries() {
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }


}
