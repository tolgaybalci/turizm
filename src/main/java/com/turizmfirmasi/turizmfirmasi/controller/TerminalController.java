package com.turizmfirmasi.turizmfirmasi.controller;

import com.turizmfirmasi.turizmfirmasi.entity.Terminal;
import com.turizmfirmasi.turizmfirmasi.service.ITerminalService;
import com.turizmfirmasi.turizmfirmasi.serviceimplementation.TerminalServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Terminaller")
public class TerminalController {

    @Autowired
    private TerminalServiceImplementation terminalServiceImplementation;

    @GetMapping
    public List<Terminal> getAllTerminal(){
        return terminalServiceImplementation.getAllTerminal();
    }

    @PostMapping
    public ResponseEntity<Terminal> saveTerminal(Terminal terminal){
        terminalServiceImplementation.saveTerminal(terminal);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/{terminalId}")
    public ResponseEntity<Terminal> getTerminalById(@PathVariable("terminalId") String terminalId){
        Terminal terminal = terminalServiceImplementation.getTerminalById(terminalId);
        return new ResponseEntity(terminal, HttpStatus.OK);
    }

    @PutMapping("/terminal")
    public ResponseEntity<Terminal> updateTerminal(@RequestBody Terminal terminal){
        terminalServiceImplementation.updateTerminal(terminal);
        return new ResponseEntity<Terminal>(terminal, HttpStatus.OK);
    }

    @DeleteMapping("/terminal/{id}")
    public ResponseEntity<Void> deleteTerminal(@PathVariable("id") String id){
        terminalServiceImplementation.deleteTerminal(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
