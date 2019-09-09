package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import com.turizmfirmasi.turizmfirmasi.repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
