package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.MuavinDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Muavin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MuavinServiceImplementation {

    @Autowired
    private MuavinDaoImplementation muavinDAOImplementation;

    public List<Muavin> getAllMuavin() {
        return muavinDAOImplementation.getAllMuavin();
    }

    public Muavin getMuavinById(String id) {
        return muavinDAOImplementation.getMuavinById(id);
    }

    public void saveMuavin(Muavin muavin) {
        muavinDAOImplementation.saveMuavin(muavin);
    }

    public void updateMuavin(Muavin muavin) {
        muavinDAOImplementation.updateMuavin(muavin);
    }

    public void deleteMuavin(String id) {
        muavinDAOImplementation.deleteMuavin(id);
    }

    public List<Muavin> findByMuavinYasiLessThan(BigDecimal yas){
        return muavinDAOImplementation.findByMuavinYasiLessThan(yas);
    }

    public List<Muavin> yasiKucukOlanMuavinleriListele(BigDecimal yas){
        return muavinDAOImplementation.yasiKucukOlanMuavinleriListele(yas);
    }
}
