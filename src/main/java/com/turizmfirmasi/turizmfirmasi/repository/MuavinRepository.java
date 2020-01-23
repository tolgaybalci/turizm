package com.turizmfirmasi.turizmfirmasi.repository;

import com.turizmfirmasi.turizmfirmasi.entity.Muavin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MuavinRepository extends JpaRepository<Muavin, String> {

    //yaşı x den küçük olan muavinler listelensin
    List<Muavin> findByMuavinYasiLessThan(BigDecimal yas);

    //yaşı x den küçük olan muavinler listelensin
    @Query("SELECT m FROM Muavin m WHERE m.muavinYasi < :yas")
    List<Muavin> yasiKucukOlanMuavinleriListele(BigDecimal yas);

}
