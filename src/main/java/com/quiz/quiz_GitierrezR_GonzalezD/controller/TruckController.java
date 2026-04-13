package com.quiz.quiz_GitierrezR_GonzalezD.controller;

import com.quiz.quiz_GitierrezR_GonzalezD.dto.TruckRequest;
import com.quiz.quiz_GitierrezR_GonzalezD.dto.TruckResponse;
import com.quiz.quiz_GitierrezR_GonzalezD.service.TruckService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public ResponseEntity<List<TruckResponse>> getAllTrucks() {
        return ResponseEntity.ok(truckService.getAllTrucks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruckResponse> getTruckById(@PathVariable Long id) {
        return ResponseEntity.ok(truckService.getTruckById(id));
    }

    @PostMapping
    public ResponseEntity<TruckResponse> createTruck(@Valid @RequestBody TruckRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(truckService.createTruck(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TruckResponse> updateTruck(@PathVariable Long id, @Valid @RequestBody TruckRequest request) {
        return ResponseEntity.ok(truckService.updateTruck(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTruck(@PathVariable Long id) {
        truckService.deleteTruck(id);
        return ResponseEntity.ok(Map.of("message", "Camión eliminado correctamente"));
    }
}
