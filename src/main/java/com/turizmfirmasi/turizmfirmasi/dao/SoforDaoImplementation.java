package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import com.turizmfirmasi.turizmfirmasi.repository.SoforRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.awt.image.PixelConverter;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.List;

@Component
public class SoforDaoImplementation {

    @Autowired
    private SoforRepository soforRepository;

    public void saveSofor(Sofor sofor){ soforRepository.save(sofor); }

    public void updateSofor(Sofor sofor) {
        Sofor sfr = soforRepository.findById(sofor.getId()).orElse(null);
        sfr.setSoforIsmi(sofor.getSoforIsmi());
        sfr.setSoforSoyismi(sofor.getSoforSoyismi());
        sfr.setYasi(sofor.getYasi());
        sfr.setSoforDogumYili(sofor.getSoforDogumYili());
        soforRepository.save(sofor);
    }

    public void deleteSofor(String id) {
        soforRepository.delete(getSoforById(id));
    }

    public List<Sofor> getAllSofor(){ return soforRepository.findAll(); }

    public Sofor getSoforById(String id){ return soforRepository.findById(id).orElse(null); }

    public List<Sofor> findByYasiGreaterThan(BigDecimal yasi){
        return soforRepository.findByYasiGreaterThan(yasi);
    }

    public List<Sofor> findYasiBuyukSoforler(BigDecimal sayi){
        return soforRepository.findYasiBuyukSoforler(sayi);
    }

    public List<Sofor> findByYasiLessThanAndSoforMaasiGreaterThan(BigDecimal yas, BigDecimal soforMaasi){
        return soforRepository.findByYasiLessThanAndSoforMaasiGreaterThan(yas, soforMaasi);
    }

    public List<Sofor> yasiKucukMaasiFazlaOlanSoforleriListele(BigDecimal yas, BigDecimal maas){
        return soforRepository.yasiKucukMaasiFazlaOlanSoforleriListele(yas, maas);
    }

    public List<Sofor> findBySoforMaasiGreaterThan(BigDecimal sayi){
        return soforRepository.findBySoforMaasiGreaterThan(sayi);
    }

    public List<Sofor> maasiBelirliBirMiktardanFazlaOlanlarıListele(BigDecimal sayi){
        return soforRepository.maasiBelirliBirMiktardanFazlaOlanlarıListele(sayi);
    }
}
