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
public class Firma {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "FIRMA_ISMI")
    private String firmaIsmi;

    @Column(name = "FIRMA_ADRESI")
    private String firmaAdresi;

    @Column(name = "CALISAN_SAYISI")
    private BigDecimal calisanSayisi;

    @Column(name = "OTOBUS_SAYISI")
    private BigDecimal otobusSayisi;

    @OneToMany
    @JoinTable(name = "Firma_Otobus", joinColumns = @JoinColumn(name = "Firma_id"),
                                       inverseJoinColumns = @JoinColumn(name = "Otobus_id"))
    private List<Otobus> otobus;

    @ManyToOne
    @JoinColumn(name = "Terminal_id")
    private Terminal terminal;

    @OneToMany
    @JoinTable(name = "Firma_Muavin", joinColumns = @JoinColumn(name = "Firma_id"),
                                      inverseJoinColumns = @JoinColumn(name = "Muavin_id"))
    private List<Muavin> muavin;
}
