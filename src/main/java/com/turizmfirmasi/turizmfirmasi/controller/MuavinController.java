package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Muavin;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.MuavinServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Muavinler")
public class MuavinController {

    @Autowired
    private MuavinServiceImplementation muavinServiceImplementation;

    @GetMapping
    public List<Muavin> getMuavinler(){
        return muavinServiceImplementation.getAllMuavin();
    }

    @PostMapping
    public ResponseEntity<Muavin> saveMavin(Muavin muavin){
        muavinServiceImplementation.saveMuavin(muavin);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{muavinId}")
    public ResponseEntity<Muavin> getFirmaById(@PathVariable("muavinId") String muavinId){
        Muavin muavin = muavinServiceImplementation.getMuavinById(muavinId);
        return new ResponseEntity(muavin, HttpStatus.OK);
    }

    @PutMapping("/muavin")
    public ResponseEntity<Muavin> updateFirma(@RequestBody Muavin muavin){
        muavinServiceImplementation.updateMuavin(muavin);
        return new ResponseEntity<Muavin>(muavin, HttpStatus.OK);
    }

    @DeleteMapping("/muavin/{id}")
    public ResponseEntity<Void> deleteMuavin(@PathVariable("id") String id){
        muavinServiceImplementation.deleteMuavin(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
