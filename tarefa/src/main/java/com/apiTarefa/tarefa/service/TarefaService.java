package com.apiTarefa.tarefa.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.apiTarefa.tarefa.exception.BadRequestException;
import com.apiTarefa.tarefa.model.Tarefa;
import com.apiTarefa.tarefa.repository.TarefaRepository;

import java.util.List;


@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> list() {
        Sort sort = Sort.by(Direction.DESC, "prioridade")
                .and(Sort.by(Direction.ASC, "id"));

        return tarefaRepository.findAll(sort);
    }

    public List<Tarefa> create(Tarefa Tarefa) {
        tarefaRepository.save(Tarefa);
        return list();
    }

    public List<Tarefa> update(Long id, Tarefa Tarefa) {
        tarefaRepository.findById(id).ifPresentOrElse((existingTarefa) -> {
            Tarefa.setId(id);
            tarefaRepository.save(Tarefa);
        }, () -> {
            throw new BadRequestException("Tarefa %d não existe! ".formatted(id));
        });

        return list();

    }

    public List<Tarefa> delete(Long id) {
        tarefaRepository.findById(id).ifPresentOrElse((existingTarefa) -> tarefaRepository.delete(existingTarefa),
                () -> {
                    throw new BadRequestException("Tarefa %d não existe! ".formatted(id));
                });
        return list();
    }
}
