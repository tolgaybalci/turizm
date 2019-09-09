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
public class Otobus {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "PLAKA")
    private String plaka;

    @Column(name = "OTOBUS_MODELI")
    private String otobusModeli;

    @Column(name = "KOLTUK_SAYISI")
    private BigDecimal koltukSayisi;

    @OneToMany
    @JoinTable(name = "Otobus_Sofor", joinColumns = @JoinColumn(name = "Otobus_id"),
                                      inverseJoinColumns = @JoinColumn(name = "Sofor_id"))
    private List<Sofor> sofor;

    @ManyToOne
    @JoinColumn(name = "Firma_id")
    private Firma firma;

    @ManyToOne
    @JoinColumn(name = "Terminal_id")
    private Terminal terminal;

    @OneToOne
    @JoinColumn(name = "Muavin_id")
    private Muavin muavin;

}
