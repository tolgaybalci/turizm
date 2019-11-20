package com.turizmfirmasi.turizmfirmasi.service;

import com.turizmfirmasi.turizmfirmasi.entity.Sofor;

import java.util.List;

public interface ISoforService {

    List<Sofor> getAllSofor();

    Sofor getSoforById(String id);

    void saveSofor(Sofor sofor);

    void updateSofor(Sofor sofor);

    void deleteSofor(String id);
}
