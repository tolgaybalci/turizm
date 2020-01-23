package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.SoforServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/soforler")
public class SoforController {

    @Autowired
    private SoforServiceImplementation soforServiceImplementation;

    @GetMapping
    public List<Sofor> getSoforler(){
        return soforServiceImplementation.getAllSofor();
    }

    @PostMapping
    public ResponseEntity<Sofor> saveSofor(@RequestBody Sofor sofor){
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

    @GetMapping("get-yasi-büyük-olan-soforler/{yasi}")
    public ResponseEntity<List<Sofor>> findByYasiGreaterThan(@PathVariable("yasi") BigDecimal yasi){
        return new ResponseEntity<List<Sofor>>(soforServiceImplementation.findByYasiGreaterThan(yasi), HttpStatus.OK);
    }

    @GetMapping("yasi-buyuk-olan-soforleri-listele/{yasi}")
    public ResponseEntity<List<Sofor>> findYasiBuyukSoforler(@PathVariable("yasi") BigDecimal yasi){
        return new ResponseEntity<List<Sofor>>(soforServiceImplementation.findYasiBuyukSoforler(yasi), HttpStatus.OK);
    }

    @GetMapping("get-by-yasi-kucuk-maasi-fazla-olan-soforleri-listele/{yasi}/{soforMaasi}")
    public ResponseEntity<List<Sofor>> findByYasiLessThanAndSoforMaasiGreaterThan(@PathVariable("yasi") BigDecimal yasi,
                                                                                  @PathVariable("soforMaasi") BigDecimal soforMaasi){
        return new ResponseEntity<List<Sofor>>(soforServiceImplementation.findByYasiLessThanAndSoforMaasiGreaterThan(yasi, soforMaasi), HttpStatus.OK);
    }

    @GetMapping("yasi-kucuk-maasi-fazla-olan-soforleri-listele/{yas}/{maas}")
    public ResponseEntity<List<Sofor>> yasiKucukMaasiFazlaOlanSoforleriListele(@PathVariable("yas") BigDecimal yas,
                                                                               @PathVariable("maas") BigDecimal maas){
        return new ResponseEntity<List<Sofor>>(soforServiceImplementation.yasiKucukMaasiFazlaOlanSoforleriListele(yas,maas), HttpStatus.OK);
    }

    @GetMapping("get-maasi-belirli-bir-sayidan-buyuk-soforler/{sayi}")
    public ResponseEntity<List<Sofor>> findBySoforMaasiGreaterThan(@PathVariable("sayi") BigDecimal sayi){
        return new ResponseEntity<List<Sofor>>(soforServiceImplementation.findBySoforMaasiGreaterThan(sayi), HttpStatus.OK);
    }

    @GetMapping("maasi-belirli-bir-miktardan-fazla-olanlari-listele/{sayi}")
    public ResponseEntity<List<Sofor>> maasiBelirliBirMiktardanFazlaOlanlarıListele(@PathVariable("sayi") BigDecimal sayi){
        return new ResponseEntity<List<Sofor>>(soforServiceImplementation.maasiBelirliBirMiktardanFazlaOlanlarıListele(sayi), HttpStatus.OK);
    }
}
