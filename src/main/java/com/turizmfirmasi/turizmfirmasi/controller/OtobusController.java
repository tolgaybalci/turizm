package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.dao.OtobusDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Otobus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Otobusler")
public class OtobusController {

    @Autowired
    private OtobusDaoImplementation otobusDaoImplementation;

    @GetMapping
    public ResponseEntity<Otobus> getOtobusler(){
        return new ResponseEntity(otobusDaoImplementation.getAllOtobus(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Otobus> addOtobus(Otobus otobus){
        otobusDaoImplementation.saveOtobus(otobus);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{otobusId}")
    public ResponseEntity<Otobus> getOtobusById(@PathVariable("otobusId") String otobusId){
        Otobus otobus = otobusDaoImplementation.getOtobusById(otobusId);
        return new ResponseEntity(otobus, HttpStatus.OK);
    }
}
