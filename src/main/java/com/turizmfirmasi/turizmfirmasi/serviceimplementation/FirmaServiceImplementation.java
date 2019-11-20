package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.FirmaDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import com.turizmfirmasi.turizmfirmasi.service.IFirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
