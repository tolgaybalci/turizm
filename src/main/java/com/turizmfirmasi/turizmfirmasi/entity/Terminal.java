package com.turizmfirmasi.turizmfirmasi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Terminal {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "TERMINAL_SEHRİ")
    private String terminalSehri;

    @Column(name = "TERMİNAL_ADRESI")
    private String terminalAdresi;

    @Column(name = "YOLCU_KAPASITESI")
    private BigDecimal yolcuKapasitesi;

    @Column(name = "KOORDINATLARI")
    private String koordinatlari;

    @OneToMany
    private List<Otobus> otobus;

    @OneToMany
    private List<Sofor> sofor;

    @OneToMany
    private List<Firma> firma;

    @OneToMany
    private List<Muavin> muavin;
}
