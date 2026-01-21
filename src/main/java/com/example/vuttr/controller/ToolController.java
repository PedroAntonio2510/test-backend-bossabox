package com.example.vuttr.controller;

import com.example.vuttr.domain.Tool;
import com.example.vuttr.service.ToolService;
import com.example.vuttr.service.specification.ToolQueryFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tools")
@Tag(name = "Tools", description = "Endpoints for managing tools")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    @Operation(summary = "Create a new tool", description = "Creates a new tool in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tool created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Map<String, Tool>> save(@RequestBody Tool tool) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("result", toolService.save(tool)));
    }

    @GetMapping
    @Operation(summary = "Find all tools", description = "Returns a list of all tools, with an optional filter by tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<Tool>> findAll(ToolQueryFilter filter) {
        return ResponseEntity.ok(toolService.findAll(filter.toSpecification()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a tool", description = "Deletes a tool by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tool deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Tool not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        toolService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
