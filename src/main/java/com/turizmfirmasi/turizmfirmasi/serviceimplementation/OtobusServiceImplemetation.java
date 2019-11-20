package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.OtobusDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Otobus;
import com.turizmfirmasi.turizmfirmasi.service.IOtobusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtobusServiceImplemetation implements IOtobusService {

    @Autowired
    private OtobusDaoImplementation otobusDaoImplementation;

    @Override
    public List<Otobus> getAllOtobus() {
        return otobusDaoImplementation.getAllOtobus();
    }

    @Override
    public Otobus getOtobusById(String id) {
        return otobusDaoImplementation.getOtobusById(id);
    }

    @Override
    public void saveOtobus(Otobus otobus) {
        otobusDaoImplementation.saveOtobus(otobus);
    }

    @Override
    public void updateOtobus(Otobus otobus) {
        otobusDaoImplementation.updateOtobus(otobus);
    }

    @Override
    public void deleteOtobus(String id) {
        otobusDaoImplementation.deletOtobus(id);
    }
}
