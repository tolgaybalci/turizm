package com.turizmfirmasi.turizmfirmasi.service;

import com.turizmfirmasi.turizmfirmasi.entity.Firma;

import java.util.List;

public interface IFirmaService {

    List<Firma> getAllFirma();

    Firma getFirmaById(String id);

    void saveFirma(Firma firma);

    void updateFirma(Firma firma);

    void deleteFirma(String id);
}
