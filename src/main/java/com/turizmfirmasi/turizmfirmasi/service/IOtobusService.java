package com.turizmfirmasi.turizmfirmasi.service;

import com.turizmfirmasi.turizmfirmasi.entity.Otobus;

import java.util.List;

public interface IOtobusService {

    List<Otobus> getAllOtobus();

    Otobus getOtobusById(String id);

    void saveOtobus(Otobus otobus);

    void updateOtobus(Otobus otobus);

    void deleteOtobus(String id);
}
