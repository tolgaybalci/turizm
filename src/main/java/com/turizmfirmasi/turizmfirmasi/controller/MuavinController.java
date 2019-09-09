package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.dao.MuavinDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Muavin;
import com.turizmfirmasi.turizmfirmasi.repository.MuavinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Muavinler")
public class MuavinController {

    @Autowired
    private MuavinDaoImplementation muavinDaoImplementation;

    @GetMapping
    public ResponseEntity<Muavin> getMuavinler(){
        return new ResponseEntity(muavinDaoImplementation.getAllMuavin(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Muavin> addMavin(Muavin muavin){
        muavinDaoImplementation.saveMuavin(muavin);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{muavinId}")
    public ResponseEntity<Muavin> getFirmaById(@PathVariable("muavinId") String muavinId){
        Muavin muavin = muavinDaoImplementation.getMuavinById(muavinId);
        return new ResponseEntity(muavin, HttpStatus.OK);
    }
}
