package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import com.turizmfirmasi.turizmfirmasi.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TerminalDaoImplementation {

    @Autowired
    private TerminalRepository terminalRepository;

    public void saveTerminal(Terminal terminal){
        terminalRepository.save(terminal);
    }

    public void updateTerminal(Terminal terminal) {
        Terminal trmnl = terminalRepository.findById(terminal.getId()).orElse(null);
        trmnl.setKoordinatlari(terminal.getKoordinatlari());
        trmnl.setTerminalAdresi(terminal.getTerminalAdresi());
        trmnl.setTerminalSehri(terminal.getTerminalSehri());
        trmnl.setYolcuKapasitesi(terminal.getYolcuKapasitesi());
        terminalRepository.save(terminal);
    }

    public void deleteTerminal(String id) {
        terminalRepository.delete(getTerminalById(id));
    }

    public List<Terminal> getAllTerminal(){
        return terminalRepository.findAll();
    }

    public Terminal getTerminalById(String id){
        return terminalRepository.findById(id).orElse(null);
    }
}
