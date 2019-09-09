package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.dao.FirmaDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("firmalar")
public class FirmaController {

    @Autowired
    private FirmaDaoImplementation firmaDaoImplementation;

    @GetMapping
    public ResponseEntity<Firma> getFirmalar(){
        return new ResponseEntity(firmaDaoImplementation.getAllFirma(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Firma> addFirma(@RequestBody Firma firma){
        firmaDaoImplementation.saveFirma(firma);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{firmaId}")
    public ResponseEntity<Firma> getFirmaById(@PathVariable("firmaId") String firmaId){
        Firma firma = firmaDaoImplementation.getFirmaById(firmaId);
        return new ResponseEntity(firma, HttpStatus.OK);
    }
}
