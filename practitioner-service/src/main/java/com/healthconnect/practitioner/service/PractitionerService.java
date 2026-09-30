package com.healthconnect.practitioner.service;

import com.healthconnect.practitioner.entity.Practitioner;
import com.healthconnect.practitioner.repository.PractitionerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PractitionerService {
    private final PractitionerRepository repository;

    public PractitionerService(PractitionerRepository repository) {
        this.repository = repository;
    }

    public Practitioner create(Practitioner practitioner) {
        return repository.save(practitioner);
    }

    public List<Practitioner> getAll() {
        return repository.findAll();
    }

    public Practitioner getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Practitioner not found with id: " + id));
    }

    public Practitioner update(Long id, Practitioner practitioner) {
        Practitioner p = getById(id);
        p.setName(practitioner.getName());
        p.setSpecialization(practitioner.getSpecialization());
        p.setQualification(practitioner.getQualification());
        p.setExperience(practitioner.getExperience());
        p.setEmail(practitioner.getEmail());
        p.setPhone(practitioner.getPhone());
        p.setAvailable(practitioner.getAvailable());
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
