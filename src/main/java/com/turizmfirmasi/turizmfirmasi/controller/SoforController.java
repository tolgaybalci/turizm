package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import com.turizmfirmasi.turizmfirmasi.service.ISoforService;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.SoforServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Soforler")
public class SoforController {

    @Autowired
    private SoforServiceImplementation soforServiceImplementation;

    @GetMapping
    public List<Sofor> getSoforler(){
        return soforServiceImplementation.getAllSofor();
    }

    @PostMapping
    public ResponseEntity<Sofor> saveOtobus(Sofor sofor){
        soforServiceImplementation.saveSofor(sofor);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{soforId}")
    public ResponseEntity<Sofor> getSoforById(@PathVariable("soforId") String soforId){
        Sofor sofor = soforServiceImplementation.getSoforById(soforId);
        return new ResponseEntity(sofor, HttpStatus.OK);
    }

    @PutMapping("/sofor")
    public ResponseEntity<Sofor> updateSofor(@RequestBody Sofor sofor){
        soforServiceImplementation.updateSofor(sofor);
        return new ResponseEntity<Sofor>(sofor, HttpStatus.OK);
    }

    @DeleteMapping("/sofor/{id}")
    public ResponseEntity<Void> deleteSofor(@PathVariable("id") String id){
        soforServiceImplementation.deleteSofor(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
