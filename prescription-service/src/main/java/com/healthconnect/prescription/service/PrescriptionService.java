package com.healthconnect.prescription.service;

import com.healthconnect.prescription.entity.Prescription;
import com.healthconnect.prescription.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrescriptionService {
    private final PrescriptionRepository repository;

    public PrescriptionService(PrescriptionRepository repository) {
        this.repository = repository;
    }

    public Prescription create(Prescription prescription) {
        prescription.setCreatedAt(LocalDateTime.now());
        return repository.save(prescription);
    }

    public List<Prescription> getAll() {
        return repository.findAll();
    }

    public Prescription getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
    }

    public List<Prescription> getByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
