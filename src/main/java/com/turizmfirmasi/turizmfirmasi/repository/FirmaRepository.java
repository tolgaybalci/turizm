package com.turizmfirmasi.turizmfirmasi.repository;

import com.turizmfirmasi.turizmfirmasi.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, String> {

    Firma findByFirmaIsmi(String firmaIsmi);

    List<Firma> findByCalisanSayisiGreaterThan(BigDecimal sayi);

    List<Firma> findByCalisanSayisiGreaterThanAndOtobusSayisiLessThan(BigDecimal calisanSayisi, BigDecimal otobusSayisi);

    @Query("SELECT f FROM Firma f join f.otobus o WHERE o.koltukSayisi < :koltukSayisi")
    List<Firma> findKoltukSayısıAzOlanFirmalar(@Param("koltukSayisi") BigDecimal koltukSayisi);

    @Query("SELECT f FROM Firma f WHERE f.calisanSayisi > :sayi")
    List<Firma> findCalisanSayisiFazlaOlanlar(BigDecimal sayi);

    @Query("SELECT f FROM Firma f WHERE f.otobusSayisi > :sayi")
    List<Firma> findOtobusSayisiFazlaOlanlar(BigDecimal sayi);

    @Query("SELECT f FROM Firma f WHERE f.calisanSayisi < :calisanSayisi AND f.otobusSayisi < :otobusSayisi")
    List<Firma> findCalisanSayisiAzOtobusSayisiAzOLanlar(BigDecimal calisanSayisi, BigDecimal otobusSayisi);

    @Query("SELECT f FROM Firma f WHERE f.firmaIsmi LIKE  %?1% OR f.firmaIsmi LIKE %?2%")
    List<Firma> findAllFirmaIsmiContainsCharacter(String c, String d);

    //yaşı x den büyük olan şöforlerin firmaları listelensin
    @Query("SELECT f FROM Firma f join f.sofor s WHERE s.yasi > :yas")
    List<Firma> findYasiBelirliBirSayidanBuyukSoforlerinOlduguFirmalar(@Param("yas") BigDecimal yas);

    //maaşı x dolardan büyük olanlar listelensin(Sofor ve Muavin)
    /*@Query("SELECT f FROM Firma f join f.sofor s, f.muavin m WHERE s.soforMaasi > :soforMaasi OR m.muavinMaas >: muavinMaas")
    List<Firma> findMaasiFazlaOlanPersoneliListele(@Param("soforMaasi") BigDecimal soforMaasi, @Param("muavinMaas") BigDecimal muavinMaas);*/
}
