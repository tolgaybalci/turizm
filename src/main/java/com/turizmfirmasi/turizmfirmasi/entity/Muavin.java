package com.turizmfirmasi.turizmfirmasi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Muavin {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String muavinIsmi;

    @Column
    private String muavinSoyIsmi;

    @Column
    private BigDecimal muavinYasi;

    @Temporal(TemporalType.DATE)
    private Date muavinDogumYili;

    @OneToOne
    @JoinColumn(name = "Otobus_id")
    private Otobus otobus;

    @ManyToOne
    @JoinColumn(name = "Firma_id")
    private Firma firma;

    @ManyToOne
    @JoinColumn(name = "Terminal_id")
    private Terminal terminal;

}
