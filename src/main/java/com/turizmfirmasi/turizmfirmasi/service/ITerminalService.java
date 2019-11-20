package com.turizmfirmasi.turizmfirmasi.service;

import com.turizmfirmasi.turizmfirmasi.entity.Terminal;

import java.util.List;

public interface ITerminalService {

    List<Terminal> getAllTerminal();

    Terminal getTerminalById(String id);

    void saveTerminal(Terminal terminal);

    void updateTerminal(Terminal terminal);

    void deleteTerminal(String id);
}
