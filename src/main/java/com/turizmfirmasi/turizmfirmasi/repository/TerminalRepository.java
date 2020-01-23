package com.turizmfirmasi.turizmfirmasi.repository;

import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, String> {

    //terminaller yolcu kapasitesine göre listelensin  (OrderBy ile)
    List<Terminal> findByOrderByYolcuKapasitesiAsc();

}
