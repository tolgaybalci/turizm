package com.turizmfirmasi.turizmfirmasi.dao;

import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import com.turizmfirmasi.turizmfirmasi.repository.OtobusRepository;
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

    public List<Terminal> getAllTerminal(){
        return terminalRepository.findAll();
    }

    public Terminal getTerminalById(String id){
        return terminalRepository.findById(id).orElse(null);
    }
}
