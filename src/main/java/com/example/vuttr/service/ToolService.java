package com.example.vuttr.service;

import com.example.vuttr.domain.Tool;
import com.example.vuttr.repository.ToolRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ToolService {

    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public Tool save(Tool tool) {
        return toolRepository.save(tool);
    }

    public List<Tool> findAll(Specification<Tool> especification) {
        return toolRepository.findAll(especification);
    }

    public void deleteById(Long id) {
        toolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Tool found with id: " + id));
        toolRepository.deleteById(id);
    }
}