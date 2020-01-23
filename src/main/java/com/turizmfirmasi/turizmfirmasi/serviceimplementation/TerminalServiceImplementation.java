package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.TerminalDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import com.turizmfirmasi.turizmfirmasi.service.ITerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TerminalServiceImplementation {

    @Autowired
    private TerminalDaoImplementation terminalDaoImplementation;

    public List<Terminal> getAllTerminal() {
        return terminalDaoImplementation.getAllTerminal();
    }

    public Terminal getTerminalById(String id) {
        return terminalDaoImplementation.getTerminalById(id);
    }

    public void saveTerminal(Terminal terminal) {
        terminalDaoImplementation.saveTerminal(terminal);
    }

    public void updateTerminal(Terminal terminal) {
        terminalDaoImplementation.updateTerminal(terminal);
    }

    public void deleteTerminal(String id) {
        terminalDaoImplementation.deleteTerminal(id);
    }

    public List<Terminal> findByOrderByYolcuKapasitesiAsc(){
        return terminalDaoImplementation.findByOrderByYolcuKapasitesiAsc();
    }
}
