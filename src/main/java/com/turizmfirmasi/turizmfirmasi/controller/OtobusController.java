package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Otobus;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.OtobusServiceImplemetation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/otobusler")
public class OtobusController {

    @Autowired
    private OtobusServiceImplemetation otobusServiceImplementation;

    @GetMapping
    public List<Otobus> getOtobusler(){
        return otobusServiceImplementation.getAllOtobus();
    }

    @PostMapping
    public ResponseEntity<Otobus> saveOtobus(@RequestBody Otobus otobus){
        otobusServiceImplementation.saveOtobus(otobus);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{otobusId}")
    public ResponseEntity<Otobus> getOtobusById(@PathVariable("otobusId") String otobusId){
        Otobus otobus = otobusServiceImplementation.getOtobusById(otobusId);
        return new ResponseEntity(otobus, HttpStatus.OK);
    }

    @PutMapping("/otobus")
    public ResponseEntity<Otobus> updateFirma(@RequestBody Otobus otobus){
        otobusServiceImplementation.updateOtobus(otobus);
        return new ResponseEntity<Otobus>(otobus, HttpStatus.OK);
    }

    @DeleteMapping("/otobus/{id}")
    public ResponseEntity<Void> deleteOtobus(@PathVariable("id") String id){
        otobusServiceImplementation.deleteOtobus(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
