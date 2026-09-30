package com.healthconnect.appointment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "practitioner-service")
public interface PractitionerClient {
    @GetMapping("/api/practitioners/{id}")
    Object getPractitioner(@PathVariable("id") Long id);
}
