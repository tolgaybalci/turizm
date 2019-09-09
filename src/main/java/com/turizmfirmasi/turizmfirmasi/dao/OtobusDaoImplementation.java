package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Otobus;
import com.turizmfirmasi.turizmfirmasi.repository.OtobusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OtobusDaoImplementation {

    @Autowired
    private OtobusRepository otobusRepository;

    public void saveOtobus(Otobus otobus){
        otobusRepository.save(otobus);
    }

    public List<Otobus> getAllOtobus(){
        return otobusRepository.findAll();
    }

    public Otobus getOtobusById(String id){
        return otobusRepository.findById(id).orElse(null);
    }
}

