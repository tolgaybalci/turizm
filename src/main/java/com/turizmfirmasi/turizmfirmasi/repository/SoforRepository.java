package com.turizmfirmasi.turizmfirmasi.repository;

import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SoforRepository extends JpaRepository<Sofor, String> {

    //yası x den büyük olan soforler listelensin
    List<Sofor> findByYasiGreaterThan(BigDecimal yasi);

    //yası x den büyük olan soforler listelensin
    @Query("SELECT s FROM Sofor s WHERE s.yasi > :sayi")
    List<Sofor> findYasiBuyukSoforler(BigDecimal sayi);

    //yaşı x den küçük ve maaşı y den büyük olan şoförler listelensin
    List<Sofor> findByYasiLessThanAndSoforMaasiGreaterThan(BigDecimal yasi, BigDecimal soforMaasi);

    //yaşı x den küçük ve maaşı y den büyük olan şoförler listelensin
    @Query("SELECT s FROM Sofor s WHERE s.yasi < :yas AND s.soforMaasi > :maas")
    List<Sofor> yasiKucukMaasiFazlaOlanSoforleriListele(BigDecimal yas, BigDecimal maas);

    //maaşı y den büyük olan şoförler listelensin
    List<Sofor> findBySoforMaasiGreaterThan(BigDecimal sayi);

    //maaşı y den büyük olan şoförler listelensin
    @Query("SELECT s FROM Sofor s WHERE s.soforMaasi > :sayi")
    List<Sofor> maasiBelirliBirMiktardanFazlaOlanlarıListele(BigDecimal sayi);

}
