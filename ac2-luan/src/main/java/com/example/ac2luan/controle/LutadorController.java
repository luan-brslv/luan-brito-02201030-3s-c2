package com.example.ac2luan.controle;

import com.example.ac2luan.dominio.Lutador;
import com.example.ac2luan.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutadores(){
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @GetMapping("/mortos")
    public ResponseEntity getLutadoresMortos() {
        return ResponseEntity.status(200).body(repository.findByVivoFalse());
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadoresVivos() {
        return ResponseEntity.status(200).body(repository.countByVidaGreaterThan(0.0));
    }

}
