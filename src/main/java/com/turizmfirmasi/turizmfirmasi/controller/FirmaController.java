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

import java.math.BigDecimal;
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

    @GetMapping("/get-firma-by-name/{firmaIsmi}")
    public ResponseEntity<Firma> findByFirmaIsmi(@PathVariable("firmaIsmi") String firmaIsmi){
        return new ResponseEntity<Firma>(firmaServiceImplementation.findByFirmaIsmi(firmaIsmi),HttpStatus.OK);
    }

    @GetMapping("/get-calisan-sayisi-more-than/{sayi}")
    public ResponseEntity<List<Firma>> findByCalisanSayisiGreaterThan(@PathVariable("sayi") BigDecimal sayi){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findByCalisanSayisiGreaterThan(sayi), HttpStatus.OK);
    }

    @GetMapping("get-calisan-sayisi-more-than-and-otobus-sayisi-less-than/{calisanSayisi}/{otobusSayisi}")
    public ResponseEntity<List<Firma>> findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(@PathVariable("calisanSayisi") BigDecimal calisanSayisi,
                                                                                             @PathVariable("otobusSayisi") BigDecimal otobusSayisi){
        return new ResponseEntity<List<Firma>>(
                firmaServiceImplementation.findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(calisanSayisi, otobusSayisi),
                HttpStatus.OK);
    }

    @GetMapping("get-koltuk-sayisi-az-olan-firmalar/{koltukSayisi}")
    public ResponseEntity<List<Firma>> findKoltukSayısıAzOlanFirmalar(@PathVariable("koltukSayisi") BigDecimal koltukSayisi){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findKoltukSayısıAzOlanFirmalar(koltukSayisi), HttpStatus.OK);
    }

    @GetMapping("get-calisan-sayisi-fazla-olanlar/{sayi}")
    public ResponseEntity<List<Firma>> findCalisanSayisiFazlaOlanlar(@PathVariable("sayi") BigDecimal sayi){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findCalisanSayisiFazlaOlanlar(sayi), HttpStatus.OK);
    }

    @GetMapping("get-otobus-sayisi-fazla-olanlar/{sayi}")
    public ResponseEntity<List<Firma>> findOtobusSayisiFazlaOlanlar(@PathVariable("sayi") BigDecimal sayi){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findOtobusSayisiFazlaOlanlar(sayi), HttpStatus.OK);
    }

    @GetMapping("get-calisan-sayisi-az-otobus-sayisi-az-olanlar/{calisanSayisi}/{otobusSayisi}")
    public ResponseEntity<List<Firma>> findCalisanSayisiAzOtobusSayisiAzOLanlar(@PathVariable("calisanSayisi") BigDecimal calisanSayisi,
                                                                                @PathVariable("otobusSayisi") BigDecimal otobusSayisi){
           return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findCalisanSayisiAzOtobusSayisiAzOLanlar(calisanSayisi, otobusSayisi),
                   HttpStatus.OK);
    }

    @GetMapping("get-karakter-icerenler")
    public ResponseEntity<List<Firma>> findAllFirmaIsmiContainsCharacter(@RequestParam() String c, @RequestParam() String d){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findAllFirmaIsmiContainsCharacter(c,d), HttpStatus.OK);
    }

    @GetMapping("yasi-belirli-bir-sayidan-buyuk-soforlerin-oldugu-firmalar/{yas}")
    public ResponseEntity<List<Firma>> findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(@PathVariable("yas") BigDecimal yas){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(yas), HttpStatus.OK);
    }

    /*@GetMapping("maasi-fazla-olan-personeli-listele/{soforMaasi}/{muavinMaas}")
    public ResponseEntity<List<Firma>> findMaasiFazlaOlanPersoneliListele(@PathVariable("soforMaasi") BigDecimal soforMaasi,@PathVariable("muavinMaas") BigDecimal muavinMaas){
        return new ResponseEntity<List<Firma>>(firmaServiceImplementation.findMaasiFazlaOlanPersoneliListele(soforMaasi,muavinMaas), HttpStatus.OK);
    }*/
}

/**
 * TO-DO
 *
 * sofor ve muavin kayıtları yapılsın postman ile + yapıldı
 *
 * yası x den büyük olan soforler listelensin + yapıldı
 * yaşı x den küçük olan muavinler listelensin + yapıldı
 * yaşı x den küçük ve maaşı y den büyük olan şoförler listelensin + yapıldı
 * maaşı y den büyük olan şoförler listelensin + yapıldı
 * terminaller yolcu kapasitesine göre listelensin  (OrderBy ile) + yapıldı
 * maaşı x dolardan büyük olanlar listelensin ? (Yaptım ama deneyemedim çalışıp çalışmadığına emin değilim.)
 * yaşı x den büyük olan şöforlerin firmaları listelensin ? (Yaptım ama deneyemedim çalışıp çalışmadığına emin değilim)
 *
 */
