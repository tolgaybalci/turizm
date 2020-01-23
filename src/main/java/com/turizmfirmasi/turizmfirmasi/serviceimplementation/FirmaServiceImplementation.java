package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.FirmaDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import com.turizmfirmasi.turizmfirmasi.service.IFirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FirmaServiceImplementation implements IFirmaService {

    @Autowired
    private FirmaDaoImplementation firmaDaoImplementation;

    @Override
    public List<Firma> getAllFirma() {
        return firmaDaoImplementation.getAllFirma();
    }

    @Override
    public Firma getFirmaById(String id) {
        return firmaDaoImplementation.getFirmaById(id);
    }

    @Override
    public void saveFirma(Firma firma) {
        firmaDaoImplementation.saveFirma(firma);
    }

    @Override
    public void updateFirma(Firma firma) {
        firmaDaoImplementation.updateFirma(firma);
    }

    @Override
    public void deleteFirma(String id) {
        firmaDaoImplementation.deleteFirma(id);
    }

    public Firma findByFirmaIsmi(String firmaIsmi){
        return firmaDaoImplementation.findByFirmaIsmi(firmaIsmi);
    }

    public List<Firma> findByCalisanSayisiGreaterThan(BigDecimal sayi){
        return firmaDaoImplementation.findByCalisanSayisiGreaterThan(sayi);
    }

    public List<Firma> findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(BigDecimal calisanSayisi, BigDecimal otobusSayisi){
        return firmaDaoImplementation.findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(calisanSayisi, otobusSayisi);
    }

    public List<Firma> findKoltukSayısıAzOlanFirmalar(BigDecimal koltukSayisi){
        return firmaDaoImplementation.findKoltukSayısıAzOlanFirmalar(koltukSayisi);
    }

    public List<Firma> findCalisanSayisiFazlaOlanlar(BigDecimal sayi){
        return firmaDaoImplementation.findCalisanSayisiFazlaOlanlar(sayi);
    }

    public List<Firma> findOtobusSayisiFazlaOlanlar(BigDecimal sayi){
        return firmaDaoImplementation.findOtobusSayisiFazlaOlanlar(sayi);
    }

    public List<Firma> findCalisanSayisiAzOtobusSayisiAzOLanlar(BigDecimal calisanSayisi, BigDecimal otobusSayisi){
        return firmaDaoImplementation.findCalisanSayisiAzOtobusSayisiAzOLanlar(calisanSayisi, otobusSayisi);
    }

    public List<Firma> findAllFirmaIsmiContainsCharacter(String c, String d){
        return firmaDaoImplementation.findAllFirmaIsmiContainsCharacter(c,d);
    }

    public List<Firma> findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(BigDecimal yas){
        return firmaDaoImplementation.findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(yas);
    }

    /*public List<Firma> findMaasiFazlaOlanPersoneliListele(BigDecimal soforMaasi, BigDecimal muavinMaas){
        return firmaDaoImplementation*.findMaasiFazlaOlanPersoneliListele(soforMaasi, muavinMaas);
    }*/
}
