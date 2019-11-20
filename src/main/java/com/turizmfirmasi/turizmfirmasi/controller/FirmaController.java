package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import com.turizmfirmasi.turizmfirmasi.entity.Otobus;
import com.turizmfirmasi.turizmfirmasi.service.IFirmaService;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.FirmaServiceImplementation;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.OtobusServiceImplemetation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firmalar")
public class FirmaController {

    @Autowired
    private FirmaServiceImplementation firmaServiceImplementation;

    @Autowired
    private OtobusServiceImplemetation otobusServiceImplemetation;

    @GetMapping
    public List<Firma> getFirmalar(){
        return firmaServiceImplementation.getAllFirma();
    }

    @PostMapping
    public ResponseEntity<Firma> saveFirma(@RequestBody Firma firma){
        for(Otobus otobus: firma.getOtobus()){
            if(otobus.getId() == null)
            otobusServiceImplemetation.saveOtobus(otobus);
        }
        firmaServiceImplementation.saveFirma(firma);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PostMapping("/Multiple")
    public ResponseEntity<Firma> saveFirma(@RequestBody List<Firma> firmalar){

        for (Firma firma: firmalar){
            firmaServiceImplementation.saveFirma(firma);
        }
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{firmaId}")
    public ResponseEntity<Firma> getFirmaById(@PathVariable("firmaId") String firmaId){
        Firma firma = firmaServiceImplementation.getFirmaById(firmaId);
        return new ResponseEntity(firma, HttpStatus.OK);
    }

    @PutMapping("/firma")
    public ResponseEntity<Firma> updateFirma(@RequestBody Firma firma){
        firmaServiceImplementation.updateFirma(firma);
        return new ResponseEntity<Firma>(firma, HttpStatus.OK);
    }

    @DeleteMapping("/firma/{id}")
    public ResponseEntity<Void> deleteFirma(@PathVariable("id") String id){
        firmaServiceImplementation.deleteFirma(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
