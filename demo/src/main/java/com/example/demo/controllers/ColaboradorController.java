package com.example.demo.controllers;

import com.example.demo.entities.Colaborador;
import com.example.demo.services.ColaboradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

   
    @GetMapping
    public List<Colaborador> listarTodos() {
        return colaboradorService.listarTodos();
    }

    // Consultar colaborador por ID
    @GetMapping("/{id}")
    public Colaborador consultarPorId(@PathVariable Long id) {
        return colaboradorService.consultarPorId(id);
    }

    // Salvar um novo colaborador
    @PostMapping
    public Colaborador salvar(@RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }

    // Deletar um colaborador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        colaboradorService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
