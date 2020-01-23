package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.SoforDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import com.turizmfirmasi.turizmfirmasi.service.ISoforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SoforServiceImplementation {

    @Autowired
    private SoforDaoImplementation soforDaoImplementation;

    public List<Sofor> getAllSofor() {
        return soforDaoImplementation.getAllSofor();
    }

    public Sofor getSoforById(String id) {
        return soforDaoImplementation.getSoforById(id);
    }

    public void saveSofor(Sofor sofor) {
        soforDaoImplementation.saveSofor(sofor);
    }

    public void updateSofor(Sofor sofor) {
        soforDaoImplementation.updateSofor(sofor);
    }

    public void deleteSofor(String id) {
        soforDaoImplementation.deleteSofor(id);
    }

    public List<Sofor> findByYasiGreaterThan(BigDecimal yasi){
        return soforDaoImplementation.findByYasiGreaterThan(yasi);
    }

    public List<Sofor> findYasiBuyukSoforler(BigDecimal sayi){
        return soforDaoImplementation.findYasiBuyukSoforler(sayi);
    }

    public List<Sofor> findByYasiLessThanAndSoforMaasiGreaterThan(BigDecimal yas, BigDecimal sofoMaasi){
        return soforDaoImplementation.findByYasiLessThanAndSoforMaasiGreaterThan(yas, sofoMaasi);
    }

    public List<Sofor> yasiKucukMaasiFazlaOlanSoforleriListele(BigDecimal yas, BigDecimal maas){
        return soforDaoImplementation.yasiKucukMaasiFazlaOlanSoforleriListele(yas, maas);
    }

    public List<Sofor> findBySoforMaasiGreaterThan(BigDecimal sayi){
        return soforDaoImplementation.findBySoforMaasiGreaterThan(sayi);
    }

    public List<Sofor> maasiBelirliBirMiktardanFazlaOlanlarıListele(BigDecimal sayi){
        return soforDaoImplementation.maasiBelirliBirMiktardanFazlaOlanlarıListele(sayi);
    }
}
