package com.turizmfirmasi.turizmfirmasi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

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

    //JoinColumn ve JoinTable tablonun karmaşıklığını arttırdığı için gereksizdir. OneToMany yalnız kullanılmalıdır.

    @OneToMany
    private List<Otobus> otobus;

    @ManyToOne
    private Terminal terminal;

    @OneToMany
    private List<Muavin> muavin;

    public Firma() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirmaIsmi() {
        return firmaIsmi;
    }

    public void setFirmaIsmi(String firmaIsmi) {
        this.firmaIsmi = firmaIsmi;
    }

    public String getFirmaAdresi() {
        return firmaAdresi;
    }

    public void setFirmaAdresi(String firmaAdresi) {
        this.firmaAdresi = firmaAdresi;
    }

    public BigDecimal getCalisanSayisi() {
        return calisanSayisi;
    }

    public void setCalisanSayisi(BigDecimal calisanSayisi) {
        this.calisanSayisi = calisanSayisi;
    }

    public BigDecimal getOtobusSayisi() {
        return otobusSayisi;
    }

    public void setOtobusSayisi(BigDecimal otobusSayisi) {
        this.otobusSayisi = otobusSayisi;
    }

    public List<Otobus> getOtobus() {
        return otobus;
    }

    public void setOtobus(List<Otobus> otobus) {
        this.otobus = otobus;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public List<Muavin> getMuavin() {
        return muavin;
    }

    public void setMuavin(List<Muavin> muavin) {
        this.muavin = muavin;
    }
}
