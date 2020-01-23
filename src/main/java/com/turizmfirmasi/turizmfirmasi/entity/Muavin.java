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

    @Column
    private BigDecimal muavinMaas;

    public BigDecimal getMuavinMaas() {
        return muavinMaas;
    }

    public void setMuavinMaas(BigDecimal muavinMaas) {
        this.muavinMaas = muavinMaas;
    }

    public Otobus getOtobus() {
        return otobus;
    }

    public void setOtobus(Otobus otobus) {
        this.otobus = otobus;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @OneToOne
    private Otobus otobus;

    @ManyToOne
    private Firma firma;

    @ManyToOne
    private Terminal terminal;

    public Muavin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMuavinIsmi() {
        return muavinIsmi;
    }

    public void setMuavinIsmi(String muavinIsmi) {
        this.muavinIsmi = muavinIsmi;
    }

    public String getMuavinSoyIsmi() {
        return muavinSoyIsmi;
    }

    public void setMuavinSoyIsmi(String muavinSoyIsmi) {
        this.muavinSoyIsmi = muavinSoyIsmi;
    }

    public BigDecimal getMuavinYasi() {
        return muavinYasi;
    }

    public void setMuavinYasi(BigDecimal muavinYasi) {
        this.muavinYasi = muavinYasi;
    }

    public Date getMuavinDogumYili() {
        return muavinDogumYili;
    }

    public void setMuavinDogumYili(Date muavinDogumYili) {
        this.muavinDogumYili = muavinDogumYili;
    }
}
