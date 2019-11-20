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

    public List<Otobus> getOtobus() {
        return otobus;
    }

    public void setOtobus(List<Otobus> otobus) {
        this.otobus = otobus;
    }

    public List<Sofor> getSofor() {
        return sofor;
    }

    public void setSofor(List<Sofor> sofor) {
        this.sofor = sofor;
    }

    public List<Firma> getFirma() {
        return firma;
    }

    public void setFirma(List<Firma> firma) {
        this.firma = firma;
    }

    public List<Muavin> getMuavin() {
        return muavin;
    }

    public void setMuavin(List<Muavin> muavin) {
        this.muavin = muavin;
    }

    public Terminal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerminalSehri() {
        return terminalSehri;
    }

    public void setTerminalSehri(String terminalSehri) {
        this.terminalSehri = terminalSehri;
    }

    public String getTerminalAdresi() {
        return terminalAdresi;
    }

    public void setTerminalAdresi(String terminalAdresi) {
        this.terminalAdresi = terminalAdresi;
    }

    public BigDecimal getYolcuKapasitesi() {
        return yolcuKapasitesi;
    }

    public void setYolcuKapasitesi(BigDecimal yolcuKapasitesi) {
        this.yolcuKapasitesi = yolcuKapasitesi;
    }

    public String getKoordinatlari() {
        return koordinatlari;
    }

    public void setKoordinatlari(String koordinatlari) {
        this.koordinatlari = koordinatlari;
    }
}
