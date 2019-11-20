package com.turizmfirmasi.turizmfirmasi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
    private List<Sofor> sofor;

    @ManyToOne
    private Firma firma;

    @ManyToOne
    private Terminal terminal;

    @OneToOne
    private Muavin muavin;

    public List<Sofor> getSofor() {
        return sofor;
    }

    public void setSofor(List<Sofor> sofor) {
        this.sofor = sofor;
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

    public Muavin getMuavin() {
        return muavin;
    }

    public void setMuavin(Muavin muavin) {
        this.muavin = muavin;
    }

    public Otobus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getOtobusModeli() {
        return otobusModeli;
    }

    public void setOtobusModeli(String otobusModeli) {
        this.otobusModeli = otobusModeli;
    }

    public BigDecimal getKoltukSayisi() {
        return koltukSayisi;
    }

    public void setKoltukSayisi(BigDecimal koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }
}
