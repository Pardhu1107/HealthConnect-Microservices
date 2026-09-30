package com.healthconnect.practitioner.controller;

import com.healthconnect.practitioner.entity.Practitioner;
import com.healthconnect.practitioner.service.PractitionerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practitioners")
public class PractitionerController {
    private final PractitionerService service;

    public PractitionerController(PractitionerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Practitioner> create(@Valid @RequestBody Practitioner practitioner) {
        return ResponseEntity.ok(service.create(practitioner));
    }

    @GetMapping
    public ResponseEntity<List<Practitioner>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practitioner> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practitioner> update(
            @PathVariable Long id,
            @Valid @RequestBody Practitioner practitioner) {
        return ResponseEntity.ok(service.update(id, practitioner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
