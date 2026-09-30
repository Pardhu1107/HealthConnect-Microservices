package com.healthconnect.appointment.service;

import com.healthconnect.appointment.entity.Appointment;
import com.healthconnect.appointment.entity.AppointmentStatus;
import com.healthconnect.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment book(Appointment appointment) {
        boolean exists = repository.existsByPractitionerIdAndAppointmentTime(
                appointment.getPractitionerId(),
                appointment.getAppointmentTime());
        if (exists) {
            throw new RuntimeException("Appointment slot already booked for practitioner ID: " + appointment.getPractitionerId());
        }
        appointment.setStatus(AppointmentStatus.BOOKED);
        return repository.save(appointment);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    public Appointment updateStatus(Long id, AppointmentStatus status) {
        Appointment appointment = getById(id);
        appointment.setStatus(status);
        return repository.save(appointment);
    }

    public void cancel(Long id) {
        Appointment appointment = getById(id);
        appointment.setStatus(AppointmentStatus.CANCELLED);
        repository.save(appointment);
    }
}
