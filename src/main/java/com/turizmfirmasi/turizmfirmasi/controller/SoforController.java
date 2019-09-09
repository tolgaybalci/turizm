package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.dao.SoforDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Soforler")
public class SoforController {

    @Autowired
    private SoforDaoImplementation soforDaoImplementation;

    @GetMapping
    public ResponseEntity<Sofor> getSoforler(){
        return new ResponseEntity(soforDaoImplementation.getAllSofor(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sofor> addOtobus(Sofor sofor){
        soforDaoImplementation.saveSofor(sofor);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{soforId}")
    public ResponseEntity<Sofor> getSoforById(@PathVariable("soforId") String soforId){
        Sofor sofor = soforDaoImplementation.getSoforById(soforId);
        return new ResponseEntity(sofor, HttpStatus.OK);
    }
}
