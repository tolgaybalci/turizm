package com.turizmfirmasi.turizmfirmasi.serviceimplementation;

import com.turizmfirmasi.turizmfirmasi.dao.TerminalDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import com.turizmfirmasi.turizmfirmasi.service.ITerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalServiceImplementation implements ITerminalService {

    @Autowired
    private TerminalDaoImplementation terminalDaoImplementation;

    @Override
    public List<Terminal> getAllTerminal() {
        return terminalDaoImplementation.getAllTerminal();
    }

    @Override
    public Terminal getTerminalById(String id) {
        return terminalDaoImplementation.getTerminalById(id);
    }

    @Override
    public void saveTerminal(Terminal terminal) {
        terminalDaoImplementation.saveTerminal(terminal);
    }

    @Override
    public void updateTerminal(Terminal terminal) {
        terminalDaoImplementation.updateTerminal(terminal);
    }

    @Override
    public void deleteTerminal(String id) {
        terminalDaoImplementation.deleteTerminal(id);
    }
}
