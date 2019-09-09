package com.turizmfirmasi.turizmfirmasi.repository;

import com.turizmfirmasi.turizmfirmasi.entity.Sofor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoforRepository extends JpaRepository<Sofor, String> {
}
