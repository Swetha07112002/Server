package com.wiringdesk.server;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License, Integer> {

    Optional<License> findByLicenseKey(String licenseKey);
}