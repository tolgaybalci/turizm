package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import com.turizmfirmasi.turizmfirmasi.repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FirmaDaoImplementation {

    @Autowired
    private FirmaRepository firmaRepository;

    public void saveFirma(Firma firma){
       firmaRepository.save(firma);
    }

    public List<Firma> getAllFirma(){
        return firmaRepository.findAll();
    }

    public Firma getFirmaById(String id){
        return firmaRepository.findById(id).orElse(null);
    }

    public void updateFirma(Firma firma) {
        Firma frm = firmaRepository.findById(firma.getId()).orElse(null);
            frm.setFirmaIsmi(firma.getFirmaIsmi());
            frm.setFirmaAdresi(firma.getFirmaAdresi());
            frm.setCalisanSayisi(firma.getCalisanSayisi());
            frm.setOtobusSayisi(firma.getOtobusSayisi());
            firmaRepository.save(firma);
    }

    public void deleteFirma(String id) {
        firmaRepository.delete(getFirmaById(id));
    }

    public Firma findByFirmaIsmi(String firmaIsmi){
       return firmaRepository.findByFirmaIsmi(firmaIsmi);
    }

    public List<Firma> findByCalisanSayisiGreaterThan(BigDecimal sayi){
        return firmaRepository.findByCalisanSayisiGreaterThan(sayi);
    }

    public List<Firma> findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(BigDecimal calisanSayisi, BigDecimal otobusSayisi){
        return firmaRepository.findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(calisanSayisi, otobusSayisi);
    }

    public List<Firma> findKoltukSayısıAzOlanFirmalar(BigDecimal koltukSayisi){
        return firmaRepository.findKoltukSayısıAzOlanFirmalar(koltukSayisi);
    }

    public List<Firma> findCalisanSayisiFazlaOlanlar(BigDecimal sayi){
        return firmaRepository.findCalisanSayisiFazlaOlanlar(sayi);
    }

    public List<Firma> findOtobusSayisiFazlaOlanlar(BigDecimal sayi){
        return firmaRepository.findOtobusSayisiFazlaOlanlar(sayi);
    }

    public List<Firma> findCalisanSayisiAzOtobusSayisiAzOLanlar(BigDecimal calisanSayisi, BigDecimal otobusSayisi){
        return firmaRepository.findCalisanSayisiAzOtobusSayisiAzOLanlar(calisanSayisi, otobusSayisi);
    }

    public List<Firma> findAllFirmaIsmiContainsCharacter(String c, String d){
        return firmaRepository.findAllFirmaIsmiContainsCharacter(c,d);
    }

    public List<Firma> findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(BigDecimal yas){
        return firmaRepository.findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(yas);
    }

    /*public List<Firma> findMaasiFazlaOlanPersoneliListele(BigDecimal soforMaasi, BigDecimal muavinMaas){
        return firmaRepository.findMaasiFazlaOlanPersoneliListele(soforMaasi, muavinMaas);
    }*/
}
