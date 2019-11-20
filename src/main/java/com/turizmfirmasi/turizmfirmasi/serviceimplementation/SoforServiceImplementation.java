package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.SoforDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import com.turizmfirmasi.turizmfirmasi.service.ISoforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoforServiceImplementation implements ISoforService {

    @Autowired
    private SoforDaoImplementation soforDaoImplementation;

    @Override
    public List<Sofor> getAllSofor() {
        return soforDaoImplementation.getAllSofor();
    }

    @Override
    public Sofor getSoforById(String id) {
        return soforDaoImplementation.getSoforById(id);
    }

    @Override
    public void saveSofor(Sofor sofor) {
        soforDaoImplementation.saveSofor(sofor);
    }

    @Override
    public void updateSofor(Sofor sofor) {
        soforDaoImplementation.updateSofor(sofor);
    }

    @Override
    public void deleteSofor(String id) {
        soforDaoImplementation.deleteSofor(id);
    }
}
