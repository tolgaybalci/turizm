package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Otobus;
import com.turizmfirmasi.turizmfirmasi.service.IOtobusService;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.OtobusServiceImplemetation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Otobusler")
public class OtobusController {

    @Autowired
    private OtobusServiceImplemetation otobusServiceImplemetation;

    @GetMapping
    public List<Otobus> getOtobusler(){
        return otobusServiceImplemetation.getAllOtobus();
    }

    @PostMapping
    public ResponseEntity<Otobus> saveOtobus(@Valid @RequestBody Otobus otobus){
        otobusServiceImplemetation.saveOtobus(otobus);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{otobusId}")
    public ResponseEntity<Otobus> getOtobusById(@PathVariable("otobusId") String otobusId){
        Otobus otobus = otobusServiceImplemetation.getOtobusById(otobusId);
        return new ResponseEntity(otobus, HttpStatus.OK);
    }

    @PutMapping("/otobus")
    public ResponseEntity<Otobus> updateFirma(@RequestBody Otobus otobus){
        otobusServiceImplemetation.updateOtobus(otobus);
        return new ResponseEntity<Otobus>(otobus, HttpStatus.OK);
    }

    @DeleteMapping("/otobus/{id}")
    public ResponseEntity<Void> deleteOtobus(@PathVariable("id") String id){
        otobusServiceImplemetation.deleteOtobus(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
