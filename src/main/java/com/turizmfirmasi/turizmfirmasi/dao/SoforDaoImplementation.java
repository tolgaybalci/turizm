package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import com.turizmfirmasi.turizmfirmasi.repository.SoforRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SoforDaoImplementation {

    @Autowired
    private SoforRepository soforRepository;

    public void saveSofor(Sofor sofor){ soforRepository.save(sofor); }

    public List<Sofor> getAllSofor(){ return soforRepository.findAll(); }

    public Sofor getSoforById(String id){ return soforRepository.findById(id).orElse(null); }
}
