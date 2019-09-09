package com.turizmfirmasi.turizmfirmasi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import sun.nio.cs.ext.Big5;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Sofor {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String soforIsmi;

    @Column
    private String soforSoyismi;

    @Temporal(TemporalType.DATE)
    private Date soforDogumYili;

    @Column
    private BigDecimal yasi;

    @ManyToOne
    @JoinColumn(name = "Otobus_id")
    private Otobus otobus;

    @ManyToOne
    @JoinColumn(name = "Terminal_id")
    private Terminal terminal;

}

