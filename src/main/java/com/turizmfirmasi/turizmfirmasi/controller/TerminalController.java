package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.dao.TerminalDaoImplementation;
import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Terminaller")
public class TerminalController {

    @Autowired
    private TerminalDaoImplementation terminalDaoImplementation;

    @GetMapping
    public ResponseEntity<Terminal> getAllTerminal(){
        return new ResponseEntity(terminalDaoImplementation.getAllTerminal(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Terminal> addTerminal(Terminal terminal){
        terminalDaoImplementation.saveTerminal(terminal);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{terminalId}")
    public ResponseEntity<Terminal> getTerminalById(@PathVariable("terminalId") String terminalId){
        Terminal terminal = terminalDaoImplementation.getTerminalById(terminalId);
        return new ResponseEntity(terminal, HttpStatus.OK);
    }

}
