package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Muavin;
import com.turizmfirmasi.turizmfirmasi.repository.MuavinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MuavinDaoImplementation {

    @Autowired
    private MuavinRepository muavinRepository;

    public void saveMuavin(Muavin muavin){ muavinRepository.save(muavin); }

    public void updateMuavin(Muavin muavin) {
        Muavin mvn = muavinRepository.findById(muavin.getId()).orElse(null);
        mvn.setMuavinIsmi(muavin.getMuavinIsmi());
        mvn.setMuavinSoyIsmi(muavin.getMuavinSoyIsmi());
        mvn.setMuavinYasi(muavin.getMuavinYasi());
        mvn.setMuavinDogumYili(muavin.getMuavinDogumYili());
        muavinRepository.save(muavin);
    }
    public void deleteMuavin(String id) {
        muavinRepository.delete(getMuavinById(id));
    }

    public List<Muavin> getAllMuavin(){ return muavinRepository.findAll(); }

    public Muavin getMuavinById(String id) { return muavinRepository.findById(id).orElse(null); }
}
