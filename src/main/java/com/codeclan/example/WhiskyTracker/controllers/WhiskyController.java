package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhiskyController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity getAllWhiskies(@RequestParam(name = "year", required = false) Integer year,
                                         @RequestParam(name = "age", required = false) Integer age,
                                         @RequestParam(name = "distillery_id", required = false) Long distillery_id,
                                         @RequestParam(name = "region", required = false) String region) {
        if (region != null) {
            return new ResponseEntity(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        if (distillery_id != null && age != null) {
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryIdAndAge(distillery_id, age), HttpStatus.OK);
        }
        if (year != null) {
            return new ResponseEntity(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }





}
