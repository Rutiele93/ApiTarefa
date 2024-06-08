package com.apiTarefa.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.apiTarefa.tarefa.model.Tarefa;
import com.apiTarefa.tarefa.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    ResponseEntity<List<Tarefa>> create(@Valid @RequestBody Tarefa Tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tarefaService.create(Tarefa));
    }

    @GetMapping
    List<Tarefa> list() {
        return tarefaService.list();
    }

    @PutMapping("{id}")
    List<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa Tarefa) {
        return tarefaService.update(id, Tarefa);
    }

    @DeleteMapping("{id}")
    List<Tarefa> delete(@PathVariable Long id) {
        return tarefaService.delete(id);
    }

}