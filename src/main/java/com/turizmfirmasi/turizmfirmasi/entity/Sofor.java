package com.turizmfirmasi.turizmfirmasi.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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

    @Column
    private BigDecimal soforMaasi;

    public BigDecimal getSoforMaasi() {
        return soforMaasi;
    }

    public void setSoforMaasi(BigDecimal soforMaasi) {
        this.soforMaasi = soforMaasi;
    }

    @ManyToOne
    private Otobus otobus;

    public Otobus getOtobus() {
        return otobus;
    }

    public void setOtobus(Otobus otobus) {
        this.otobus = otobus;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @ManyToOne
    private Terminal terminal;

    public Sofor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoforIsmi() {
        return soforIsmi;
    }

    public void setSoforIsmi(String soforIsmi) {
        this.soforIsmi = soforIsmi;
    }

    public String getSoforSoyismi() {
        return soforSoyismi;
    }

    public void setSoforSoyismi(String soforSoyismi) {
        this.soforSoyismi = soforSoyismi;
    }

    public Date getSoforDogumYili() {
        return soforDogumYili;
    }

    public void setSoforDogumYili(Date soforDogumYili) {
        this.soforDogumYili = soforDogumYili;
    }

    public BigDecimal getYasi() {
        return yasi;
    }

    public void setYasi(BigDecimal yasi) {
        this.yasi = yasi;
    }
}

