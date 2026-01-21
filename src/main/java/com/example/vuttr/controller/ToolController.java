package com.example.vuttr.controller;

import com.example.vuttr.domain.Tool;
import com.example.vuttr.service.ToolService;
import com.example.vuttr.service.specification.ToolQueryFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tools")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Tool>> save(@RequestBody Tool tool) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("result", toolService.save(tool)));
    }

    @GetMapping
    public ResponseEntity<List<Tool>> findAll(ToolQueryFilter filter) {
        return ResponseEntity.ok(toolService.findAll(filter.toSpecification()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        toolService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
